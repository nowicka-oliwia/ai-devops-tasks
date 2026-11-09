
# Zadanie 25 – Jenkins Pipeline dla aplikacji Node.js

## 1. Cel zadania

Celem zadania było przygotowanie pliku Jenkinsfile
dla aplikacji Node.js.

Pipeline wykorzystuje deklaratywną składnię Jenkinsa
i automatyzuje proces CI/CD.

Proces obejmuje pobieranie kodu, instalowanie zależności,
testowanie, budowanie aplikacji oraz publikowanie
obrazu Docker do rejestru.

## 2. Wyjaśnienie poszczególnych etapów

### 2.1. Checkout

```groovy
stage('Checkout') {
    steps {
        checkout scm
    }
}
```

Ten etap pobiera kod źródłowy projektu
z repozytorium Git.

Dzięki temu Jenkins pracuje na aktualnej wersji kodu.

### 2.2. Install Dependencies

```groovy
stage('Install Dependencies') {
    steps {
        sh 'npm install'
    }
}
```

Instalowane są wszystkie zależności projektu
zdefiniowane w pliku package.json.

Bez tego etapu aplikacja może nie działać poprawnie,
ponieważ może brakować wymaganych bibliotek.

### 2.3. Run Tests

```groovy
stage('Run Tests') {
    steps {
        sh 'npm test'
    }
}
```

Uruchamiane są testy automatyczne aplikacji.

Pozwala to wykryć błędy przed przygotowaniem
obrazu Docker.

Jeżeli testy zakończą się niepowodzeniem,
pipeline zostanie przerwany.

### 2.4. Build Application

```groovy
stage('Build Application') {
    steps {
        sh 'npm run build'
    }
}
```

Ten etap buduje aplikację.

Może obejmować kompilację kodu, przygotowanie
plików produkcyjnych lub optymalizację zasobów.

### 2.5. Build Docker Image

```groovy
stage('Build Docker Image') {
    steps {
        sh 'docker build -t simple-node-app:latest .'
    }
}
```

Jenkins buduje obraz Docker na podstawie
Dockerfile znajdującego się w projekcie.

Obraz zawiera aplikację oraz jej wymagane zależności.

### 2.6. Push Docker Image

```groovy
stage('Push Docker Image') {
    steps {
        // Logowanie do Docker Hub i publikacja obrazu
    }
}
```

W tym etapie Jenkins loguje się do Docker Hub
za pomocą poświadczeń zapisanych w Jenkins Credentials.

Następnie oznacza obraz nazwą użytkownika
i publikuje go w rejestrze Docker.

Dzięki temu obraz może zostać pobrany
i uruchomiony na innym serwerze.

## 3. Sekcja environment

```groovy
environment {
    DOCKER_IMAGE = 'simple-node-app'
    DOCKER_TAG = 'latest'
    DOCKER_REGISTRY = 'docker.io'
    DOCKER_CREDENTIALS = 'dockerhub-credentials'
}
```

Sekcja environment przechowuje zmienne
wykorzystywane w całym pipeline.

Dzięki temu nie trzeba wielokrotnie wpisywać
tych samych wartości.

## 4. Sekcja post

```groovy
post {
    success {
        echo 'Pipeline zakończony sukcesem!'
    }

    failure {
        echo 'Pipeline zakończony błędem!'
    }

    always {
        echo 'Zakończono wykonywanie pipeline.'
    }
}
```

Sekcja post wykonuje działania po zakończeniu pipeline.

- success – uruchamia się po pomyślnym zakończeniu.
- failure – uruchamia się, gdy pipeline zakończy się błędem.
- always – wykonuje się niezależnie od wyniku.

## 5. Najlepsze praktyki przy tworzeniu pipeline Jenkins

1. **Automatyzacja testów**

   Testy powinny być uruchamiane przed budowaniem
   i publikowaniem obrazu.

2. **Bezpieczne przechowywanie haseł**

   Hasła i tokeny nie powinny znajdować się
   bezpośrednio w Jenkinsfile.

   Należy korzystać z Jenkins Credentials.

3. **Podział pipeline na etapy**

   Każdy etap powinien odpowiadać za jedno zadanie.
   Ułatwia to znalezienie błędów.

4. **Czytelność kodu**

   Należy stosować zrozumiałe nazwy etapów
   i zmiennych.

5. **Weryfikacja kodu przed wdrożeniem**

   Nie należy publikować obrazu, jeśli testy
   lub budowanie aplikacji zakończyły się błędem.

6. **Wersjonowanie obrazów Docker**

   W środowisku produkcyjnym warto używać
   unikalnych tagów, np. numeru buildu lub
   identyfikatora commita zamiast samego latest.

7. **Monitorowanie pipeline**

   Należy analizować logi i reagować na błędy
   występujące podczas budowania aplikacji.

## 6. Wymagania do uruchomienia pipeline

- Zainstalowany Jenkins.
- Zainstalowany Node.js na agencie Jenkins.
- Zainstalowany Docker.
- Dostęp do repozytorium Git.
- Konto w Docker Hub.
- Skonfigurowane poświadczenia Jenkins
  o identyfikatorze dockerhub-credentials.
- Skonfigurowane polecenia npm test i npm run build
  w package.json.

## 7. Wnioski

Jenkins Pipeline pozwala zautomatyzować proces
budowania, testowania i publikowania aplikacji.

Podział na osobne etapy ułatwia kontrolowanie
procesu i wykrywanie błędów.

Najważniejsze jest wykonywanie testów przed
publikacją obrazu Docker oraz bezpieczne
przechowywanie danych logowania.

Wniosek końcowy:

Automatyzacja CI/CD przy użyciu Jenkinsa
przyspiesza pracę programistów, poprawia jakość
kodu i ułatwia wdrażanie aplikacji.
