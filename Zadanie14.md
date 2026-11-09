
def tresc = """# Zadanie 14 – Analiza logów Docker

## 1. Oryginalne logi

\`\`\`text
May 19 10:15:32 server dockerd[1234]: time="2025-05-19T10:15:32.123456789Z" level=info msg="Container 78a2b3c4 health status changed from starting to healthy"
May 19 10:16:45 server dockerd[1234]: time="2025-05-19T10:16:45.987654321Z" level=info msg="Container 78a2b3c4 failed to connect to 172.17.0.3:5432: connection refused"
May 19 10:16:47 server dockerd[1234]: time="2025-05-19T10:16:47.246813579Z" level=warning msg="Container 78a2b3c4 health status changed from healthy to unhealthy"
\`\`\`

## 2. Analiza logów

### Pierwszy wpis – godzina 10:15:32

Poziom: INFO

Komunikat:
Container health status changed from starting to healthy.

Wyjaśnienie:
Kontener Docker został uruchomiony i przeszedł kontrolę
stanu zdrowia. Oznacza to, że w tym momencie działał poprawnie.

### Drugi wpis – godzina 10:16:45

Poziom: INFO

Komunikat:
Failed to connect to 172.17.0.3:5432: connection refused.

Wyjaśnienie:
Kontener próbował połączyć się z adresem IP 172.17.0.3
na porcie 5432, ale połączenie zostało odrzucone.

Port 5432 jest standardowym portem bazy danych PostgreSQL.

Możliwe przyczyny:
- Serwer PostgreSQL nie jest uruchomiony.
- Baza danych nie zakończyła jeszcze uruchamiania.
- PostgreSQL nie nasłuchuje na odpowiednim porcie.
- Konfiguracja połączenia jest nieprawidłowa.
- Usługa PostgreSQL nie jest poprawnie skonfigurowana w Dockerze.

### Trzeci wpis – godzina 10:16:47

Poziom: WARNING

Komunikat:
Container health status changed from healthy to unhealthy.

Wyjaśnienie:
Kontener zmienił swój stan z poprawnego na niepoprawny.
Oznacza to, że kontrola zdrowia wykryła problem z działaniem usługi.

Prawdopodobnie zmiana stanu jest związana z problemem
połączenia z bazą PostgreSQL.

## 3. Zidentyfikowane problemy

1. Problem z połączeniem do PostgreSQL.
2. Możliwy brak uruchomionej usługi bazy danych.
3. Możliwy problem z konfiguracją portu 5432.
4. Kontener zmienił status z healthy na unhealthy.
5. Aplikacja może nie mieć dostępu do wymaganych danych.

## 4. Proponowane rozwiązania

### Sprawdzenie uruchomionych kontenerów

\`\`\`bash
docker ps -a
\`\`\`

Polecenie wyświetla wszystkie kontenery i ich aktualny stan.

### Sprawdzenie logów PostgreSQL

\`\`\`bash
docker logs NAZWA_KONTENERA
\`\`\`

Pozwala sprawdzić, czy baza danych uruchomiła się poprawnie.

### Sprawdzenie dostępności portu 5432

\`\`\`bash
sudo ss -lntp | grep 5432
\`\`\`

Pozwala sprawdzić, czy jakaś usługa nasłuchuje na porcie 5432.

### Sprawdzenie stanu kontenera

\`\`\`bash
docker inspect --format='{{.State.Health.Status}}' 78a2b3c4
\`\`\`

Wyświetla aktualny status kontroli zdrowia kontenera.

### Sprawdzenie konfiguracji Docker Compose

Należy sprawdzić, czy aplikacja i PostgreSQL
korzystają z tej samej sieci Docker.

W konfiguracji aplikacji warto używać nazwy usługi,
np. db:5432, zamiast adresu IP kontenera,
który może się zmieniać.

## 5. Wnioski

Na początku logów kontener działał prawidłowo i posiadał
status healthy.

Następnie wystąpił problem z połączeniem do bazy PostgreSQL
na porcie 5432. Dwie sekundy później kontener zmienił
status na unhealthy.

Najbardziej prawdopodobną przyczyną jest problem
z dostępnością serwera PostgreSQL lub konfiguracją
komunikacji między kontenerami.

Aby rozwiązać problem, należy sprawdzić logi bazy danych,
stan kontenerów oraz konfigurację sieci Docker.

Wniosek końcowy:
Regularne analizowanie logów Docker pozwala szybko wykrywać
problemy z komunikacją między usługami i reagować na błędy,
zanim wpłyną one na działanie całej aplikacji.
"""

def plik = new File("Zadanie14.md")
plik.setText(tresc, "UTF-8")

println "Utworzono plik: ${plik.absolutePath}"
println "Zadanie 14 zapisane pomyślnie!"
