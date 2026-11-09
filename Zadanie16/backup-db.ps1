
# Prosty skrypt do backupu bazy danych w Windows

# Nazwa bazy danych
$DB_NAME = "app_database"

# Katalog przechowywania kopii zapasowych
$BACKUP_DIR = "C:\backups\db"

# Aktualna data i godzina
$DATE = Get-Date -Format "yyyyMMdd_HHmmss"

# Nazwa pliku backupu
$FILENAME = Join-Path $BACKUP_DIR "${DB_NAME}_${DATE}.sql.gz"

# Sprawdź, czy katalog istnieje
if (!(Test-Path -Path $BACKUP_DIR)) {
    New-Item -ItemType Directory -Path $BACKUP_DIR -Force | Out-Null
    Write-Host "Utworzono katalog $BACKUP_DIR"
}

# Wykonaj backup
Write-Host "Rozpoczynam backup bazy $DB_NAME..."

# Wykonanie mysqldump i zapisanie wyniku
$SQL_FILE = Join-Path $BACKUP_DIR "${DB_NAME}_${DATE}.sql"
& mysqldump -u root -p $DB_NAME --result-file="$SQL_FILE"

# Sprawdź, czy backup zakończył się sukcesem
if ($LASTEXITCODE -eq 0) {

    # Kompresja pliku SQL do formatu ZIP
    Compress-Archive -Path $SQL_FILE -DestinationPath "$FILENAME.zip" -Force

    # Usuń nieskompresowany plik SQL
    Remove-Item $SQL_FILE

    Write-Host "Backup zakończony sukcesem: $FILENAME.zip"

} else {

    Write-Host "Błąd podczas wykonywania backupu!"
    exit 1
}
