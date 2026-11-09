
# Zadanie 16 – Konwersja Bash na PowerShell

## 1. Cel zadania

Celem zadania było przekonwertowanie skryptu Bash
odpowiedzialnego za tworzenie kopii zapasowej bazy MySQL
na odpowiednik działający w systemie Windows PowerShell.

## 2. Główne różnice między Bash i PowerShell

### Zmienne

Bash:
```bash
DB_NAME="app_database"
```

PowerShell:
```powershell
$DB_NAME = "app_database"
```

W PowerShell zmienne rozpoczynają się znakiem $.

### Pobieranie daty

Bash:
```bash
DATE=$(date +%Y%m%d_%H%M%S)
```

PowerShell:
```powershell
$DATE = Get-Date -Format "yyyyMMdd_HHmmss"
```

PowerShell wykorzystuje polecenie Get-Date.

### Sprawdzanie katalogu

Bash:
```bash
if [ ! -d "$BACKUP_DIR" ]; then
```

PowerShell:
```powershell
if (!(Test-Path -Path $BACKUP_DIR)) {
```

W PowerShell wykorzystujemy Test-Path do sprawdzania,
czy katalog lub plik istnieje.

### Tworzenie katalogu

Bash:
```bash
mkdir -p "$BACKUP_DIR"
```

PowerShell:
```powershell
New-Item -ItemType Directory -Path $BACKUP_DIR -Force
```

Oba polecenia tworzą katalog, jeśli jeszcze nie istnieje.

### Wyświetlanie komunikatów

Bash:
```bash
echo "Backup zakończony sukcesem"
```

PowerShell:
```powershell
Write-Host "Backup zakończony sukcesem"
```

W PowerShell do wyświetlania komunikatów wykorzystujemy Write-Host.

### Sprawdzanie kodu zakończenia

Bash:
```bash
$?
```

PowerShell:
```powershell
$LASTEXITCODE
```

Zmienna $LASTEXITCODE przechowuje kod zakończenia
ostatnio uruchomionego programu zewnętrznego.

### Kompresja plików

Bash:
```bash
gzip
```

PowerShell:
```powershell
Compress-Archive
```

Compress-Archive tworzy archiwum ZIP.
Nie jest bezpośrednim odpowiednikiem gzip, który tworzy
plik skompresowany w formacie GZIP.

## 3. Najważniejsze różnice

| Element | Bash | PowerShell |
|---|---|---|
| Zmienne | DB_NAME | $DB_NAME |
| Data | date | Get-Date |
| Sprawdzanie katalogu | -d | Test-Path |
| Tworzenie katalogu | mkdir -p | New-Item |
| Komunikaty | echo | Write-Host |
| Kod błędu | $? | $LASTEXITCODE |
| Kompresja | gzip | Compress-Archive |

## 4. Wnioski

Bash i PowerShell pozwalają automatyzować podobne zadania,
ale różnią się składnią i dostępnymi poleceniami.

Bash jest często wykorzystywany w systemach Linux,
natomiast PowerShell jest popularnym narzędziem
automatyzacji w systemie Windows.

Podczas konwersji skryptu trzeba zwrócić uwagę
na sposób deklarowania zmiennych, sprawdzania katalogów,
obsługi błędów i kompresowania plików.

Wniosek końcowy:
PowerShell umożliwia wykonanie podobnych operacji jak Bash,
ale wymaga zastosowania odpowiednich poleceń systemowych.
