def tresc = """# Zadanie 5 – Wizualizacja ASCII Art

## 1. Pierwszy prompt – prosty diagram

Prompt:

Stwórz prosty diagram ASCII Art przedstawiający połączenie klienta,
serwera aplikacji i bazy danych.

### Odpowiedź AI:

    +----------+       +-------------------+       +------------+
    |          |       |                   |       |            |
    |  KLIENT  | ----> | SERWER APLIKACJI  | ----> |  BAZA      |
    |          |       |                   |       |  DANYCH    |
    +----------+       +-------------------+       +------------+

## 2. Drugi prompt – ulepszony diagram

Prompt:

Dodaj do diagramu opisy elementów i kierunki przepływu danych.

### Odpowiedź AI:

    +------------------+
    |      KLIENT      |
    |                  |
    | Przegladarka WWW |
    +------------------+
             |
             | 1. Wyslanie zapytania HTTP
             v
    +----------------------+
    |   SERWER APLIKACJI   |
    |                      |
    | Logika biznesowa     |
    | Przetwarzanie danych |
    +----------------------+
             |
             | 2. Zapytanie SQL
             v
    +----------------------+
    |     BAZA DANYCH      |
    |                      |
    | Przechowywanie danych|
    | Odczyt i zapis       |
    +----------------------+
             |
             | 3. Wynik zapytania
             v
    +----------------------+
    |   SERWER APLIKACJI   |
    +----------------------+
             |
             | 4. Odpowiedz HTTP
             v
    +----------------------+
    |       KLIENT         |
    | Wyświetlenie wyniku  |
    +----------------------+

## 3. Opis działania diagramu

1. Klient wysyła żądanie HTTP do serwera aplikacji.
2. Serwer przetwarza żądanie i komunikuje się z bazą danych.
3. Baza danych zwraca wymagane informacje.
4. Serwer przekazuje odpowiedź do klienta.
5. Klient wyświetla otrzymane dane użytkownikowi.

## 4. Porównanie diagramów

| Kryterium | Pierwszy diagram | Drugi diagram |
|---|---|---|
| Wygląd | Prosty | Rozbudowany |
| Opisy elementów | Brak | Są |
| Kierunki przepływu | Podstawowe | Szczegółowe |
| Czytelność | Dobra | Bardzo dobra |
| Szczegółowość | Niska | Wysoka |

## 5. Moje wnioski

Pierwszy diagram przedstawia podstawowe połączenie klienta,
serwera aplikacji i bazy danych. Jest prosty i łatwy do zrozumienia,
ale nie pokazuje dokładnie sposobu komunikacji między elementami.

Drugi diagram jest bardziej szczegółowy. Zawiera opisy poszczególnych
elementów oraz kierunki przepływu danych. Dzięki temu łatwiej zrozumieć,
jak działa komunikacja w aplikacji internetowej.

Moim zdaniem drugi diagram jest bardziej przydatny podczas nauki
i dokumentowania systemów informatycznych.

Wniosek końcowy: Dodanie opisów i kierunków przepływu danych
znacznie poprawia czytelność i wartość informacyjną diagramu.
"""

def plik = new File("zadanie-5.md")
plik.setText(tresc, "UTF-8")

println "Utworzono plik: ${plik.absolutePath}"
println "Zadanie 5 zapisane pomyślnie!"