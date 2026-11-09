
# Zadanie 18 – Bezpieczeństwo aplikacji Dockerowych

## 1. Pięć kluczowych praktyk bezpieczeństwa

1. **Uruchamianie kontenerów jako użytkownik non-root** – ogranicza uprawnienia aplikacji i zmniejsza skutki potencjalnego ataku.

2. **Korzystanie z zaufanych obrazów Docker** – należy używać oficjalnych i aktualnych obrazów oraz regularnie sprawdzać ich podatności.

3. **Ochrona haseł i danych poufnych** – nie należy umieszczać haseł i tokenów bezpośrednio w Dockerfile. Warto korzystać z Docker Secrets.

4. **Ograniczanie uprawnień kontenerów** – należy stosować zasadę najmniejszych uprawnień i unikać trybu privileged.

5. **Monitorowanie i skanowanie podatności** – należy analizować logi oraz regularnie sprawdzać obrazy Docker.

## 2. Implementacja pierwszej praktyki – użytkownik non-root

Pierwszą praktykę można wdrożyć poprzez utworzenie osobnego użytkownika w Dockerfile.

### Dockerfile

```dockerfile
FROM node:22-alpine

WORKDIR /app

# Utworzenie grupy i użytkownika bez uprawnień administratora
RUN addgroup -g 10001 appgroup && \
    adduser -D -u 10001 -G appgroup appuser

# Kopiowanie plików z odpowiednimi uprawnieniami
COPY --chown=10001:10001 package*.json ./

# Instalacja zależności produkcyjnych
RUN npm ci --omit=dev

# Kopiowanie pozostałych plików aplikacji
COPY --chown=10001:10001 . .

# Ustawienie środowiska produkcyjnego
ENV NODE_ENV=production

# Udostępnienie portu aplikacji
EXPOSE 3000

# Uruchamianie aplikacji jako zwykły użytkownik
USER 10001:10001

CMD ["npm", "start"]
```

## 3. Konfiguracja docker-compose.yml

```yaml
services:
  app:
    build: .
    container_name: secure-node-app

    ports:
      - "3000:3000"

    # Uruchamianie jako użytkownik non-root
    user: "10001:10001"

    # Blokowanie zapisu w głównym systemie plików
    read_only: true

    # Tymczasowy katalog do zapisu
    tmpfs:
      - /tmp

    # Usunięcie dodatkowych uprawnień
    cap_drop:
      - ALL

    # Blokowanie uzyskiwania nowych uprawnień
    security_opt:
      - no-new-privileges:true

    restart: unless-stopped

    environment:
      NODE_ENV: production
```

## 4. Wyjaśnienie zastosowanych zabezpieczeń

- USER – uruchamia aplikację jako zwykły użytkownik zamiast root.
- user – określa identyfikator użytkownika kontenera.
- read_only – blokuje zapis w głównym systemie plików.
- tmpfs – umożliwia tymczasowy zapis danych.
- cap_drop – usuwa dodatkowe uprawnienia systemowe.
- no-new-privileges – blokuje uzyskiwanie dodatkowych uprawnień.
- restart – automatycznie uruchamia kontener ponownie w razie awarii.

## 5. Sprawdzenie konfiguracji

```bash
docker compose config
docker compose build
docker compose up -d
docker ps
docker compose exec app id
```

Oczekiwany wynik powinien zawierać UID 10001 i GID 10001.
UID 0 oznaczałby użytkownika root.

## 6. Wnioski

Bezpieczeństwo aplikacji Dockerowych jest bardzo ważne w środowisku produkcyjnym.

Najważniejszą praktyką zastosowaną w tym zadaniu jest uruchamianie kontenera jako użytkownik non-root.

Dzięki temu aplikacja posiada ograniczone uprawnienia, co zmniejsza ryzyko przejęcia kontroli nad systemem.

Dodatkowe zabezpieczenia, takie jak read_only, cap_drop oraz no-new-privileges, jeszcze bardziej zwiększają bezpieczeństwo kontenera.

Wniosek końcowy:
Stosowanie dobrych praktyk bezpieczeństwa Docker pomaga chronić aplikację, dane i serwer produkcyjny.
```
