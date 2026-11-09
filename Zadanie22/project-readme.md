

# Simple Task API

REST API do zarządzania zadaniami, stworzone przy użyciu Node.js, Express i MongoDB.

## 1. Opis projektu

Simple Task API to prosta aplikacja backendowa umożliwiająca zarządzanie zadaniami.

Główne funkcjonalności:
- Tworzenie nowych zadań.
- Pobieranie listy wszystkich zadań.
- Pobieranie pojedynczego zadania.
- Aktualizowanie istniejących zadań.
- Usuwanie zadań.
- Filtrowanie zadań według statusu i priorytetu.
- Podstawowa autoryzacja użytkowników.

### Technologie

- Node.js – środowisko uruchomieniowe JavaScript.
- Express.js – framework do tworzenia API.
- MongoDB – baza danych.
- Mongoose – biblioteka do obsługi MongoDB.

## 2. Instalacja

### Wymagania

Przed uruchomieniem projektu należy zainstalować:
- Node.js
- npm
- MongoDB

### Pobranie projektu

```bash
git clone https://github.com/username/simple-task-api.git
cd simple-task-api
```

### Instalacja zależności

```bash
npm install
```

### Konfiguracja środowiska

Utwórz plik `.env` w głównym katalogu projektu:

```env
PORT=3000
MONGODB_URI=mongodb://localhost:27017/simple-task-api
JWT_SECRET=your_secret_key
```

### Uruchomienie aplikacji

```bash
npm start
```

W trybie deweloperskim:

```bash
npm run dev
```

API będzie dostępne pod adresem:

```text
http://localhost:3000
```

## 3. Użycie

API umożliwia zarządzanie zadaniami za pomocą żądań HTTP.

Przykładowe zadanie:

```json
{
  "title": "Nauczyć się Node.js",
  "description": "Poznać podstawy Express i MongoDB",
  "status": "pending",
  "priority": "high"
}
```

Dostępne statusy:
- pending
- in_progress
- completed

Dostępne priorytety:
- low
- medium
- high

Przykładowe żądanie:

```bash
curl http://localhost:3000/api/tasks
```

## 4. Endpointy API

| Metoda | Endpoint | Opis |
|---|---|---|
| GET | /api/tasks | Pobieranie wszystkich zadań |
| GET | /api/tasks/:id | Pobieranie zadania według ID |
| POST | /api/tasks | Tworzenie nowego zadania |
| PUT | /api/tasks/:id | Aktualizacja zadania |
| DELETE | /api/tasks/:id | Usuwanie zadania |
| GET | /api/tasks?status=completed | Filtrowanie według statusu |
| GET | /api/tasks?priority=high | Filtrowanie według priorytetu |

### Przykład tworzenia zadania

```http
POST /api/tasks
Content-Type: application/json
Authorization: Bearer YOUR_TOKEN
```

Treść żądania:

```json
{
  "title": "Przygotować projekt",
  "description": "Ukończyć dokumentację API",
  "status": "pending",
  "priority": "high"
}
```

### Przykład aktualizacji zadania

```http
PUT /api/tasks/123
Content-Type: application/json
Authorization: Bearer YOUR_TOKEN
```

Treść żądania:

```json
{
  "status": "completed"
}
```

### Przykład usuwania zadania

```http
DELETE /api/tasks/123
Authorization: Bearer YOUR_TOKEN
```

## 5. Autoryzacja

API wykorzystuje podstawową autoryzację użytkowników.

Chronione endpointy wymagają tokenu JWT przekazywanego w nagłówku:

```text
Authorization: Bearer YOUR_TOKEN
```

## 6. Podsumowanie

Simple Task API pozwala na wygodne zarządzanie zadaniami
i może stanowić podstawę do stworzenia większej aplikacji.

Projekt wykorzystuje Node.js, Express oraz MongoDB.
