
# Zadanie 29 – Jenkins Configuration as Code (JCasC)

## 1. Cel zadania

Celem zadania było przygotowanie pliku YAML
umożliwiającego automatyczną konfigurację Jenkinsa
za pomocą mechanizmu Configuration as Code.

Plik konfiguracyjny nosi nazwę:

`jenkins-casc.yaml`

JCasC pozwala przechowywać ustawienia Jenkinsa
w pliku YAML zamiast konfigurować wszystko
ręcznie przez panel administracyjny.

## 2. Co zawiera plik konfiguracyjny?

### Podstawowe ustawienia Jenkins

W pliku skonfigurowano:

- Nazwę i komunikat systemowy.
- Liczbę wykonawców ustawioną na 2.
- Tryb pracy NORMAL.
- Lokalną autoryzację użytkowników.
- Podstawowe ustawienia bezpieczeństwa.

Ustawienie liczby wykonawców określa,
ile zadań Jenkins może wykonywać jednocześnie
na danym kontrolerze.

### Globalne narzędzia

Skonfigurowano trzy narzędzia:

- Maven 3.9.9 – narzędzie do budowania projektów Java.
- Node.js 20.18.0 – środowisko uruchomieniowe JavaScript.
- Docker – narzędzie do budowania obrazów kontenerów.

Narzędzia można następnie wykorzystywać
w pipeline bez konieczności ręcznej konfiguracji
każdego zadania.

### Wtyczki

Do poprawnego działania konfiguracji należy
zainstalować odpowiednie wtyczki:

- Configuration as Code.
- Pipeline.
- Git.
- Maven Integration.
- NodeJS.
- Docker.
- Job DSL.

Ważne: JCasC nie instaluje automatycznie
wtyczek. Muszą być one dostępne w Jenkinsie
przed zastosowaniem konfiguracji.

### Przykładowe zadanie Pipeline

Plik tworzy zadanie:

`example-nodejs-pipeline`

Zadanie wykonuje następujące etapy:

1. Checkout – pobranie kodu z repozytorium.
2. Install – instalacja zależności npm.
3. Test – uruchomienie testów.
4. Build – budowanie aplikacji.

## 3. Instalacja Jenkinsa

### Krok 1 – Instalacja Docker

Należy zainstalować Docker Desktop
lub Docker Engine.

Sprawdzenie instalacji:

```bash
docker --version
```

### Krok 2 – Utworzenie katalogu

```bash
mkdir jenkins-casc
cd jenkins-casc
```

Umieść w tym katalogu plik:

```text
jenkins-casc.yaml
```

### Krok 3 – Przygotowanie Dockerfile

Utwórz plik Dockerfile:

```dockerfile
FROM jenkins/jenkins:lts-jdk21

USER root

RUN jenkins-plugin-cli --plugins \
    configuration-as-code \
    workflow-aggregator \
    git \
    maven-plugin \
    nodejs \
    docker-plugin \
    job-dsl

USER jenkins
```

### Krok 4 – Przygotowanie Docker Compose

Utwórz plik docker-compose.yml:

```yaml
services:
  jenkins:
    build: .
    container_name: jenkins-casc
    ports:
      - "8080:8080"
      - "50000:50000"
    environment:
      CASC_JENKINS_CONFIG: /var/jenkins_home/casc/jenkins-casc.yaml
      JENKINS_ADMIN_PASSWORD: ${JENKINS_ADMIN_PASSWORD}
    volumes:
      - jenkins_home:/var/jenkins_home
      - ./jenkins-casc.yaml:/var/jenkins_home/casc/jenkins-casc.yaml:ro
    restart: unless-stopped

volumes:
  jenkins_home:
```

### Krok 5 – Konfiguracja hasła administratora

Utwórz plik `.env`:

```env
JENKINS_ADMIN_PASSWORD=zmien_to_na_mocne_haslo
```

Nie należy publikować tego pliku w repozytorium.

### Krok 6 – Uruchomienie Jenkinsa

```bash
docker compose up -d --build
```

Sprawdzenie działania kontenera:

```bash
docker compose ps
```

Podgląd logów:

```bash
docker compose logs -f jenkins
```

### Krok 7 – Otwarcie panelu

Otwórz przeglądarkę i przejdź pod adres:

```text
http://localhost:8080
```

Zaloguj się użytkownikiem:

```text
admin
```

Hasło to wartość ustawiona w pliku `.env`.

## 4. Jak działa JCasC?

Jenkins odczytuje zmienną:

```text
CASC_JENKINS_CONFIG
```

Wskazuje ona lokalizację pliku YAML.

Podczas uruchamiania Jenkins odczytuje
konfigurację i automatycznie ustawia parametry.

Dzięki temu nie trzeba ręcznie konfigurować
każdego elementu przez panel administracyjny.

## 5. Aktualizacja konfiguracji

Po zmianie pliku YAML można ponownie
załadować konfigurację przez panel Jenkinsa:

Manage Jenkins → Configuration as Code → Reload existing configuration.

Można również zrestartować kontener:

```bash
docker compose restart jenkins
```

## 6. Zalety JCasC

1. Automatyczna konfiguracja Jenkinsa.
2. Możliwość przechowywania konfiguracji w Git.
3. Łatwe odtwarzanie środowiska.
4. Mniej ręcznej pracy administratora.
5. Powtarzalność konfiguracji.
6. Łatwiejsze zarządzanie wieloma instancjami Jenkins.

## 7. Uwagi techniczne

- Wtyczki muszą być zainstalowane przed załadowaniem konfiguracji.
- Nazwy narzędzi w Jenkinsfile muszą odpowiadać nazwom z YAML.
- Nie należy przechowywać haseł bezpośrednio w repozytorium.
- Docker CLI musi być dostępny w środowisku wykonawczym, jeśli pipeline ma budować obrazy.
- Sama wtyczka Docker nie gwarantuje dostępu do Docker Engine.
- Konfiguracja timeoutu sesji wymaga osobnego ustawienia odpowiedniej wtyczki lub mechanizmu.

## 8. Wnioski

JCasC pozwala zarządzać konfiguracją Jenkinsa
za pomocą plików YAML.

Jest to wygodne rozwiązanie szczególnie
w projektach wykorzystujących CI/CD.

Konfiguracja może być wersjonowana,
przenoszona między środowiskami i odtwarzana
bez konieczności ręcznego ustawiania opcji.

Wniosek końcowy:

Jenkins Configuration as Code zwiększa
powtarzalność, automatyzację i wygodę
zarządzania środowiskiem CI/CD.
