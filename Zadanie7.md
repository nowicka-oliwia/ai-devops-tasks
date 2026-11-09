#!/bin/bash

echo "Sprawdzanie statusu usługi Docker..."

if systemctl is-active --quiet docker; then
    echo "Docker działa poprawnie."
else
    echo "Docker nie działa. Próba uruchomienia..."

    sudo systemctl start docker

    if systemctl is-active --quiet docker; then
        echo "Docker został uruchomiony pomyślnie."
    else
        echo "Nie udało się uruchomić Dockera."
        exit 1
    fi
fi

echo "Sprawdzanie zakończone."

# Wyświetlenie komunikatu informującego o rozpoczęciu sprawdzania Dockera
echo "Sprawdzanie statusu usługi Docker..."

# Sprawdzenie, czy usługa Docker jest aktualnie uruchomiona
# Opcja --quiet ukrywa dodatkowe komunikaty systemowe
if systemctl is-active --quiet docker; then

    # Jeśli Docker działa, wyświetlamy odpowiedni komunikat
    echo "Docker działa poprawnie."

else

    # Jeśli Docker nie działa, informujemy o próbie uruchomienia
    echo "Docker nie działa. Próba uruchomienia..."

    # Uruchomienie usługi Docker z uprawnieniami administratora
    sudo systemctl start docker

    # Ponowne sprawdzenie, czy Docker został uruchomiony
    if systemctl is-active --quiet docker; then

        # Komunikat o pomyślnym uruchomieniu Dockera
        echo "Docker został uruchomiony pomyślnie."

    else

        # Informacja o niepowodzeniu uruchomienia usługi
        echo "Nie udało się uruchomić Dockera."

        # Zakończenie skryptu z kodem błędu 1
        exit 1

    fi
fi

# Wyświetlenie komunikatu o zakończeniu działania skryptu
echo "Sprawdzanie zakończone."