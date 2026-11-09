
# Zadanie 21 – Konwersja JSON do CSV

## 1. Cel zadania

Celem zadania było przekształcenie danych JSON
zawierających informacje o użytkownikach do formatu CSV.

Wynikowy plik zawiera cztery kolumny:
- id
- name
- email
- roles

## 2. Oryginalny format JSON

Dane wejściowe znajdowały się w pliku users.json.

JSON przechowuje użytkowników jako tablicę obiektów.
Każdy użytkownik posiada identyfikator, imię i nazwisko,
adres e-mail oraz tablicę ról.

## 3. Wygenerowany format CSV

```csv
id,name,email,roles
1,Jan Kowalski,jan@example.com,"admin;user"
2,Anna Nowak,anna@example.com,user
```

## 4. Opis procesu konwersji

1. Odczytano dane JSON.
2. Wyodrębniono tablicę użytkowników z pola users.
3. Dla każdego użytkownika pobrano wartości id, name, email i roles.
4. Utworzono nagłówki kolumn CSV.
5. Zapisano dane użytkowników w osobnych wierszach.
6. Tablicę roles zamieniono na tekst, rozdzielając role średnikiem.

## 5. Potencjalne wyzwania

### Tablica roles

W JSON pole roles jest tablicą, natomiast CSV
przechowuje dane w postaci tekstowej.

Dlatego zastosowano średnik jako separator ról.

Przykład:

JSON:
```json
"roles": ["admin", "user"]
```

CSV:
```csv
"admin;user"
```

### Inne potencjalne problemy

- Przecinki w nazwach lub adresach wymagają cudzysłowów.
- Znaki cudzysłowu wewnątrz tekstu trzeba odpowiednio uciekać.
- Polskie znaki powinny być zapisane w kodowaniu UTF-8.
- Brakujące wartości mogą powodować puste komórki.
- Zagnieżdżone obiekty wymagają dodatkowego sposobu reprezentacji.

## 6. Porównanie formatów

| Cecha | JSON | CSV |
|---|---|---|
| Struktura | Obiekty i tablice | Wiersze i kolumny |
| Tablice | Obsługiwane | Wymagają konwersji |
| Czytelność | Dobra dla programistów | Dobra dla arkuszy |
| Zastosowanie | API i aplikacje | Excel i analiza danych |

## 7. Wnioski

Konwersja JSON do CSV pozwala przedstawić dane
w prostszej strukturze tabelarycznej.

Największym wyzwaniem było przekształcenie tablicy roles
do postaci tekstowej.

Zastosowanie średnika pozwoliło zachować wszystkie role
użytkownika w jednej kolumnie.

Wniosek końcowy:
JSON jest wygodny do przechowywania złożonych danych,
natomiast CSV sprawdza się przy analizie danych
i pracy z arkuszami kalkulacyjnymi.
