
def tresc = """# Zadanie 9 – Analiza i poprawa pliku YAML

## 1. Oryginalny plik YAML

\`\`\`yaml
services:
  web:
    image: nginx
    ports:
      - "80:80"
  app:
    build: .
    ports
      - "3000:3000"
    depends_on:
      - db
  db:
    image: postgres
    environment:
      POSTGRES_PASSWORD=password
\`\`\`

## 2. Znalezione błędy

Po analizie pliku YAML znaleziono następujące błędy:

1. Brakuje dwukropka po nazwie `ports` w usłudze `app`.
   Poprawna składnia to `ports:`.

2. Nieprawidłowa składnia sekcji `ports` powoduje,
   że plik YAML nie zostanie poprawnie odczytany.

3. Hasło bazy danych jest zapisane bez cudzysłowów.
   Warto zastosować zapis tekstowy w cudzysłowie,
   aby jednoznacznie określić wartość.

## 3. Poprawiony plik YAML

\`\`\`yaml
services:
  web:
    image: nginx
    ports:
      - "80:80"

  app:
    build: .
    ports:
      - "3000:3000"
    depends_on:
      - db

  db:
    image: postgres
    environment:
      POSTGRES_PASSWORD: "password"
\`\`\`

## 4. Wyjaśnienie poprawionych elementów

- `services` – definiuje usługi uruchamiane przez Docker Compose.
- `web` – kontener serwera Nginx.
- `image: nginx` – wykorzystuje obraz Nginx.
- `ports` – określa mapowanie portów.
- `80:80` – udostępnia port 80.
- `app` – usługa aplikacji.
- `build: .` – buduje obraz na podstawie Dockerfile z bieżącego katalogu.
- `3000:3000` – udostępnia port 3000.
- `depends_on` – określa zależność aplikacji od bazy danych.
- `db` – usługa bazy danych PostgreSQL.
- `POSTGRES_PASSWORD` – ustawia hasło użytkownika PostgreSQL.

## 5. Sprawdzenie poprawności

Aby sprawdzić poprawność pliku Docker Compose,
można użyć polecenia:

\`\`\`bash
docker compose config
\`\`\`

Jeżeli konfiguracja jest poprawna, Docker Compose
wyświetli przetworzoną konfigurację bez błędów składniowych.

## 6. Wnioski

Podczas analizy pliku znaleziono błąd składniowy:
brak dwukropka po właściwości `ports` w usłudze `app`.

Po dodaniu dwukropka i poprawieniu formatowania
plik YAML ma prawidłową strukturę.

Dzięki analizie można zauważyć, że nawet drobny błąd
w składni YAML może uniemożliwić uruchomienie aplikacji
za pomocą Docker Compose.

Wniosek: Należy zwracać uwagę na dwukropki,
wcięcia i poprawną strukturę plików YAML.
"""

def plik = new File("Zadanie9.md")
plik.setText(tresc, "UTF-8")

println "Utworzono plik: ${plik.absolutePath}"
println "Zadanie 9 zapisane pomyślnie!"