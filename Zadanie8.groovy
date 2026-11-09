
def tresc = """# Zadanie 8 – Problem z uruchomieniem kontenera Docker

## 1. Komunikat błędu

ERROR: for app Cannot start service app:
driver failed programming external connectivity on endpoint app (172.18.0.2):
Error starting userland proxy:
listen tcp4 0.0.0.0:3000: bind: address already in use

## 2. Wyjaśnienie błędu

Błąd oznacza, że port 3000 jest już zajęty przez inny proces
lub kontener Docker.

Docker próbuje uruchomić aplikację i przypisać jej port 3000,
ale system nie pozwala na to, ponieważ port jest już używany.

## 3. Sugerowane rozwiązania

### Rozwiązanie 1 – Sprawdzenie zajętego portu

    sudo lsof -i :3000

### Rozwiązanie 2 – Sprawdzenie uruchomionych kontenerów

    docker ps

### Rozwiązanie 3 – Zatrzymanie niepotrzebnego kontenera

    docker stop ID_KONTENERA

### Rozwiązanie 4 – Zmiana portu w docker-compose.yml

    ports:
      - "3001:3000"

Port 3001 będzie dostępny na komputerze,
a port 3000 pozostanie portem aplikacji wewnątrz kontenera.

### Rozwiązanie 5 – Ponowne uruchomienie aplikacji

    docker compose up -d

## 4. Wnioski

Problem wystąpił, ponieważ port 3000 był już wykorzystywany
przez inny proces lub kontener.

Aby rozwiązać problem, można sprawdzić, co zajmuje port,
zatrzymać niepotrzebny proces lub zmienić port w konfiguracji Dockera.

Najprostszym rozwiązaniem jest zmiana portu zewnętrznego
z 3000 na 3001.

Dzięki temu aplikacja może zostać uruchomiona bez konfliktu portów.
"""

def plik = new File("Zadanie8.md")
plik.setText(tresc, "UTF-8")

println "Utworzono plik: ${plik.absolutePath}"
println "Zadanie 8 zapisane pomyślnie!"