
import os
import sys
import requests
from requests.auth import HTTPBasicAuth

# Konfiguracja połączenia z Jenkins
JENKINS_URL = os.getenv("JENKINS_URL", "http://localhost:8080")
JENKINS_USER = os.getenv("JENKINS_USER")
JENKINS_TOKEN = os.getenv("JENKINS_TOKEN")

# Sprawdzenie konfiguracji
if not JENKINS_USER or not JENKINS_TOKEN:
    print("Błąd: Ustaw zmienne JENKINS_USER i JENKINS_TOKEN.")
    sys.exit(1)

# Sesja HTTP z autoryzacją
session = requests.Session()
session.auth = HTTPBasicAuth(JENKINS_USER, JENKINS_TOKEN)
session.headers.update({
    "Content-Type": "application/json"
})

def get_jenkins_data(endpoint):
    """Pobiera dane z Jenkins API."""
    url = f"{JENKINS_URL.rstrip('/')}/{endpoint.lstrip('/')}"

    try:
        response = session.get(url, timeout=15)
        response.raise_for_status()
        return response.json()

    except requests.exceptions.Timeout:
        print("Błąd: Przekroczono czas oczekiwania na Jenkins.")
    except requests.exceptions.ConnectionError:
        print("Błąd: Nie można połączyć się z Jenkins.")
    except requests.exceptions.HTTPError as error:
        print(f"Błąd HTTP: {error}")
    except requests.exceptions.RequestException as error:
        print(f"Błąd komunikacji: {error}")
    except ValueError:
        print("Błąd: Niepoprawna odpowiedź JSON.")

    return None


def list_jobs():
    """Wyświetla wszystkie zadania Jenkins."""
    data = get_jenkins_data("api/json?tree=jobs[name,url,color]")

    if data is None:
        return

    jobs = data.get("jobs", [])

    if not jobs:
        print("Nie znaleziono żadnych zadań.")
        return

    print("\n=== Lista zadań Jenkins ===")

    for job in jobs:
        status = job.get("color", "unknown")
        print(f"Nazwa: {job['name']}")
        print(f"Status: {status}")
        print(f"URL: {job['url']}")
        print("-" * 40)


def check_build_status(job_name):
    """Sprawdza status ostatniego buildu wybranego zadania."""
    endpoint = (
        f"job/{job_name}/lastBuild/api/json"
        "?tree=number,result,building,timestamp"
    )

    data = get_jenkins_data(endpoint)

    if data is None:
        return

    print(f"\n=== Status zadania: {job_name} ===")
    print(f"Build numer: {data.get('number')}")
    print(f"W trakcie budowania: {data.get('building')}")
    print(f"Wynik: {data.get('result') or 'BUILDING / UNKNOWN'}")


def run_job(job_name):
    """Uruchamia wybrane zadanie Jenkins."""
    url = f"{JENKINS_URL.rstrip('/')}/job/{job_name}/build"

    try:
        # Pobranie tokenu CSRF
        crumb_response = session.get(
            f"{JENKINS_URL.rstrip('/')}/crumbIssuer/api/json",
            timeout=15
        )
        crumb_response.raise_for_status()
        crumb = crumb_response.json()

        # Dodanie tokenu CSRF do nagłówka
        headers = {
            crumb["crumbRequestField"]: crumb["crumb"]
        }

        # Uruchomienie zadania
        response = session.post(
            url,
            headers=headers,
            timeout=15
        )

        if response.status_code in (200, 201, 202):
            print(f"Zadanie '{job_name}' zostało uruchomione.")
        else:
            response.raise_for_status()

    except requests.exceptions.RequestException as error:
        print(f"Nie udało się uruchomić zadania: {error}")


def main():
    if len(sys.argv) < 2:
        print("""
Użycie:
  python jenkins-manager.py list
  python jenkins-manager.py status NAZWA_ZADANIA
  python jenkins-manager.py run NAZWA_ZADANIA
        """)
        return

    command = sys.argv[1]

    if command == "list":
        list_jobs()

    elif command == "status" and len(sys.argv) == 3:
        check_build_status(sys.argv[2])

    elif command == "run" and len(sys.argv) == 3:
        run_job(sys.argv[2])

    else:
        print("Nieznana komenda lub niepoprawne argumenty.")


if __name__ == "__main__":
    main()
