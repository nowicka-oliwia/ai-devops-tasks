
# ==============================
# NODE.JS
# ==============================

# Biblioteki i zależności projektu.
# Można je ponownie pobrać za pomocą npm install.
node_modules/

# Pliki logów npm – nie są potrzebne w repozytorium.
npm-debug.log*
yarn-debug.log*

# ==============================
# PLIKI ŚRODOWISKOWE
# ==============================

# Pliki mogą zawierać hasła, klucze API i dane dostępowe.
# Ignorujemy je, aby chronić poufne informacje.
.env
.env.local
.env.development
.env.production

# ==============================
# DOCKER
# ==============================

# Lokalna konfiguracja Docker Compose.
# Może zawierać ustawienia specyficzne dla komputera.
docker-compose.override.yml

# Pliki logów kontenerów.
*.log

# ==============================
# MONGODB
# ==============================

# Lokalne dane bazy MongoDB.
# Mogą zawierać prywatne dane użytkowników i informacje testowe.
data/db/
mongodb_data/
mongo-data/

# Pliki przechowujące dane bazy MongoDB.
# Nie powinny być przesyłane do repozytorium.
*.wt
*.lock

# ==============================
# PLIKI GENEROWANE
# ==============================

# Gotowe pliki aplikacji po kompilacji.
# Można je wygenerować ponownie.
dist/
build/

# Raporty testów i pokrycia kodu.
coverage/

# ==============================
# SYSTEM OPERACYJNY
# ==============================

# Pliki tworzone przez system macOS.
.DS_Store

# Pliki tworzone przez Windows.
Thumbs.db

# ==============================
# EDYTORY KODU
# ==============================

# Ustawienia lokalne Visual Studio Code.
.vscode/

# Ustawienia IDE IntelliJ.
.idea/

# ==============================
# PLIKI TYMCZASOWE
# ==============================

# Pliki tymczasowe niepotrzebne w repozytorium.
tmp/
temp/


# ==========================================
# WYJAŚNIENIE – DLACZEGO UŻYWAMY GITIGNORE?
# ==========================================

# 1. Bezpieczeństwo:
# Chronimy hasła, klucze API i dane dostępowe do MongoDB.

# 2. Oszczędność miejsca:
# Nie przesyłamy folderu node_modules, który można odtworzyć.

# 3. Ochrona bazy danych:
# Lokalne pliki MongoDB mogą zawierać prywatne informacje.

# 4. Porządek:
# Nie dodajemy logów, plików tymczasowych i plików systemowych.

# 5. Współpraca:
# Każdy programista może mieć własną konfigurację lokalną.

# Wniosek:
# Plik .gitignore pomaga utrzymać repozytorium w porządku,
# chroni poufne dane i zapobiega przesyłaniu zbędnych plików.
