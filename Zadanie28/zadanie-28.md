
# Zadanie 28 – Zarządzanie Jenkins API za pomocą Pythona

## 1. Cel zadania

Celem zadania było stworzenie skryptu Python,
który komunikuje się z Jenkins API.

Skrypt jenkins-manager.py umożliwia:

- Wyświetlanie wszystkich zadań Jenkins.
- Sprawdzanie statusu ostatnich buildów.
- Uruchamianie wybranego zadania.
- Obsługę autoryzacji.
- Obsługę błędów komunikacji.

## 2. Wykorzystane biblioteki

### requests

Biblioteka requests służy do wykonywania
żądań HTTP.

W skrypcie wykorzystano ją do komunikacji
z Jenkins API.

Instalacja:

```bash
pip install requests
```

### os

Moduł os umożliwia odczytywanie zmiennych
środowiskowych.

Wykorzystano go do pobrania adresu Jenkinsa,
nazwy użytkownika oraz tokenu API.

### sys

Moduł sys pozwala obsługiwać argumenty
przekazywane podczas uruchamiania programu
oraz kończyć działanie skryptu w przypadku błędu.

## 3. Konfiguracja połączenia

Skrypt wykorzystuje trzy zmienne środowiskowe:

```bash
export JENKINS_URL="http://localhost:8080"
export JENKINS_USER="admin"
export JENKINS_TOKEN="twoj_token_api"
```

Dzięki temu dane logowania nie są zapisane
bezpośrednio w kodzie programu.

Autoryzacja odbywa się za pomocą HTTP Basic Auth,
gdzie hasło zastępuje token API użytkownika Jenkins.

## 4. Wyjaśnienie działania funkcji

### get_jenkins_data()

Funkcja odpowiada za pobieranie danych
z Jenkins API.

Wysyła żądanie GET, sprawdza odpowiedź
i zwraca dane w formacie JSON.

Obsługuje między innymi:
- Błędy połączenia.
- Przekroczenie czasu oczekiwania.
- Błędy HTTP.
- Niepoprawne odpowiedzi JSON.

### list_jobs()

Funkcja pobiera listę wszystkich zadań Jenkins.

Wykorzystuje endpoint:

```text
/api/json?tree=jobs[name,url,color]
```

Wyświetla nazwę zadania, jego status
oraz adres URL.

### check_build_status()

Funkcja sprawdza ostatni build wybranego zadania.

Wykorzystuje endpoint:

```text
/job/NAZWA_ZADANIA/lastBuild/api/json
```

Pobiera:
- Numer buildu.
- Wynik wykonania.
- Informację, czy build jest aktualnie uruchomiony.

### run_job()

Funkcja uruchamia wybrane zadanie Jenkins.

Wykonuje żądanie POST do endpointu:

```text
/job/NAZWA_ZADANIA/build
```

Przed uruchomieniem pobiera token CSRF,
czyli zabezpieczenie chroniące przed
nieautoryzowanymi żądaniami.

Następnie przekazuje token w nagłówku
żądania i uruchamia zadanie.

### main()

Funkcja main odpowiada za obsługę argumentów
przekazywanych podczas uruchamiania skryptu.

Na podstawie podanej komendy wybiera odpowiednią
funkcję programu.

## 5. Przykładowe użycie

### Instalacja biblioteki

```bash
pip install requests
```

### Wyświetlenie wszystkich zadań

```bash
python jenkins-manager.py list
```

### Sprawdzenie statusu buildu

```bash
python jenkins-manager.py status nazwa-zadania
```

### Uruchomienie zadania

```bash
python jenkins-manager.py run nazwa-zadania
```

## 6. Przykładowe wyniki

Lista zadań:

```text
=== Lista zadań Jenkins ===

Nazwa: NodeJS-Build
Status: blue
URL: http://localhost:8080/job/NodeJS-Build/

Nazwa: Docker-Deploy
Status: red
URL: http://localhost:8080/job/Docker-Deploy/
```

Status buildu:

```text
=== Status zadania: NodeJS-Build ===
Build numer: 15
W trakcie budowania: False
Wynik: SUCCESS
```

Uruchomienie zadania:

```text
Zadanie 'NodeJS-Build' zostało uruchomione.
```

## 7. Obsługa błędów i bezpieczeństwo

Skrypt obsługuje błędy HTTP, brak połączenia
z serwerem oraz przekroczenie czasu oczekiwania.

Zastosowano również kilka praktyk bezpieczeństwa:

- Token API przechowywany jest w zmiennej środowiskowej.
- Nie zapisujemy haseł bezpośrednio w kodzie.
- Wykorzystywany jest token CSRF.
- Żądania HTTP posiadają limit czasu oczekiwania.

W środowisku produkcyjnym należy dodatkowo
korzystać z HTTPS i ograniczyć uprawnienia
użytkownika Jenkins do niezbędnego minimum.

## 8. Wnioski

Dzięki Jenkins API można automatyzować
zarządzanie zadaniami bez konieczności
ręcznego korzystania z panelu Jenkins.

Python i biblioteka requests pozwalają
w prosty sposób komunikować się z serwerem.

Skrypt może być rozwijany o kolejne funkcje,
takie jak:
- Pobieranie historii buildów.
- Sprawdzanie logów.
- Anulowanie uruchomionych buildów.
- Monitorowanie wyników pipeline.

Wniosek końcowy:

Integracja Pythona z Jenkins API ułatwia
automatyzację procesów CI/CD i zarządzanie
zadaniami Jenkins.
