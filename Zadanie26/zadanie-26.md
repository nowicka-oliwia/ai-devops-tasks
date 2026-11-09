
# Zadanie 26 – Znajdowanie i poprawianie błędów w Jenkinsfile

## 1. Cel zadania

Celem zadania było znalezienie błędów w oryginalnym
pliku Jenkinsfile oraz przygotowanie poprawionej wersji.

Oryginalny kod zawierał błędy składniowe i błędne
polecenia npm.

## 2. Lista znalezionych błędów

### Błąd 1 – Nieprawidłowa nazwa steps

Oryginalny kod:

```groovy
stesp {
    sh 'npm install'
    sh 'npm build'
}
```

Problem:

Zamiast `steps` wpisano `stesp`.
Jenkins nie rozpoznaje takiej instrukcji.

Poprawka:

```groovy
steps {
    sh 'npm install'
    sh 'npm run build'
}
```

### Błąd 2 – Nieprawidłowe polecenie npm build

Oryginalny kod:

```groovy
sh 'npm build'
```

Problem:

Polecenie `npm build` nie jest standardowym
poleceniem uruchamiającym skrypt budowania aplikacji.

Poprawka:

```groovy
sh 'npm run build'
```

Polecenie `npm run build` uruchamia skrypt build
zdefiniowany w package.json.

### Błąd 3 – Nieprawidłowe umiejscowienie when

Oryginalny kod:

```groovy
stage('Deploy') {
    steps {
        sh 'docker build -t myapp .'
        sh 'docker push myapp:latest'
    }
    when {
        branch 'master'
    }
}
```

Problem:

W deklaratywnym Jenkins Pipeline warunek `when`
powinien znajdować się przed sekcją `steps`.

Poprawka:

```groovy
stage('Deploy') {
    when {
        branch 'master'
    }

    steps {
        sh 'docker build -t myapp:latest .'
        sh 'docker push myapp:latest'
    }
}
```

### Błąd 4 – Niespójne tagowanie obrazu Docker

Oryginalny kod:

```groovy
sh 'docker build -t myapp .'
sh 'docker push myapp:latest'
```

Problem:

Obraz jest budowany bez jawnego tagu,
a następnie publikowany z tagiem latest.

Może to powodować problemy z odnalezieniem
odpowiedniego obrazu.

Poprawka:

```groovy
sh 'docker build -t myapp:latest .'
sh 'docker push myapp:latest'
```

Dzięki temu obraz ma taki sam tag podczas
budowania i publikowania.

## 3. Poprawiona wersja Jenkinsfile

```groovy
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'npm install'
                sh 'npm run build'
            }
        }

        stage('Test') {
            steps {
                sh 'npm test'
            }
        }

        stage('Deploy') {
            when {
                branch 'master'
            }

            steps {
                sh 'docker build -t myapp:latest .'
                sh 'docker push myapp:latest'
            }
        }
    }

    post {
        success {
            echo 'Pipeline zakończony sukcesem!'
        }

        failure {
            echo 'Wystąpił błąd podczas wykonywania pipeline!'
        }

        always {
            echo 'Zakończono wykonywanie pipeline.'
        }
    }
}
```

## 4. Jak działają poprawione etapy?

- Build – instaluje zależności i buduje aplikację.
- Test – uruchamia testy automatyczne.
- Deploy – buduje obraz Docker i publikuje go,
  ale tylko dla gałęzi master.
- Post – wyświetla informacje o wyniku pipeline.

## 5. Wnioski

Podczas analizy znaleziono błędy dotyczące
składni Jenkins Pipeline oraz poleceń npm i Docker.

Najważniejszym problemem była literówka w nazwie
steps, która uniemożliwiała poprawne odczytanie pipeline.

Poprawiono również polecenie budowania aplikacji,
umiejscowienie warunku when oraz tagowanie obrazu Docker.

Wniosek końcowy:

Nawet drobne błędy składniowe mogą uniemożliwić
uruchomienie całego pipeline.

Dlatego warto dokładnie sprawdzać Jenkinsfile
przed uruchomieniem procesu CI/CD.
