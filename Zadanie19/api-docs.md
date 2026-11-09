
# API Documentation – GET /api/users

## Opis endpointu

Endpoint `GET /api/users` służy do pobierania listy użytkowników z systemu.

Umożliwia stronicowanie wyników oraz filtrowanie użytkowników według ich roli.

## Parametry zapytania (Query Parameters)

| Parametr | Typ | Wymagany | Domyślna wartość | Opis |
|---|---|---|---|---|
| page | integer | Nie | 1 | Numer strony wyników |
| limit | integer | Nie | 10 | Liczba użytkowników na stronie (maksymalnie 100) |
| role | string | Nie | Brak | Filtr według roli użytkownika |

### Ograniczenia parametrów

- `page` – musi być liczbą całkowitą większą lub równą 1.
- `limit` – musi być liczbą całkowitą od 1 do 100.
- `role` – opcjonalny parametr określający rolę użytkownika.

## Przykładowe żądanie

### Pobranie wszystkich użytkowników

```http
GET /api/users
```

### Pobranie drugiej strony wyników

```http
GET /api/users?page=2&limit=10
```

### Filtrowanie użytkowników według roli

```http
GET /api/users?role=admin
```

### Połączenie wszystkich parametrów

```http
GET /api/users?page=1&limit=20&role=user
```

## Przykładowa odpowiedź

Status HTTP: `200 OK`

```json
{
  "users": [
    {
      "id": 1,
      "name": "Jan Kowalski",
      "email": "jan@example.com",
      "role": "admin"
    },
    {
      "id": 2,
      "name": "Anna Nowak",
      "email": "anna@example.com",
      "role": "user"
    }
  ],
  "pagination": {
    "page": 1,
    "limit": 10,
    "total": 2,
    "totalPages": 1
  }
}
```

## Kody odpowiedzi HTTP

| Kod | Znaczenie |
|---|---|
| 200 OK | Pomyślnie pobrano listę użytkowników |
| 400 Bad Request | Nieprawidłowe parametry zapytania |
| 401 Unauthorized | Użytkownik nie jest uwierzytelniony |
| 403 Forbidden | Brak uprawnień do wykonania operacji |
| 500 Internal Server Error | Wewnętrzny błąd serwera |

## Podsumowanie

Endpoint `GET /api/users` umożliwia pobieranie użytkowników,
stronicowanie wyników i filtrowanie według roli.

Dzięki parametrom `page`, `limit` i `role` można łatwo
kontrolować zakres zwracanych danych.
