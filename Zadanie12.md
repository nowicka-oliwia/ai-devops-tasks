
# Zadanie 12 – Optymalizacja kodu Python

## 1. Oryginalny kod

```python
def find_duplicates(list_of_items):
    duplicates = []
    for i in range(len(list_of_items)):
        for j in range(i+1, len(list_of_items)):
            if list_of_items[i] == list_of_items[j] and list_of_items[i] not in duplicates:
                duplicates.append(list_of_items[i])
    return duplicates
```

## 2. Czy kod można zoptymalizować?

Tak. Oryginalny kod można zoptymalizować,
ponieważ wykorzystuje dwie zagnieżdżone pętle.
Powoduje to wielokrotne porównywanie elementów listy.

Można zastosować zbiór (set), który pozwala szybciej
sprawdzać, czy dany element został już wcześniej znaleziony.

## 3. Zoptymalizowana wersja kodu

```python
def find_duplicates(list_of_items):
    seen = set()
    duplicates = set()

    for item in list_of_items:
        if item in seen:
            duplicates.add(item)
        else:
            seen.add(item)

    return list(duplicates)
```

## 4. Wyjaśnienie usprawnień

1. Zastosowanie set()
   - Zbiór przechowuje unikalne elementy.
   - Sprawdzanie, czy element znajduje się w zbiorze,
     jest przeciętnie bardzo szybkie.

2. Usunięcie zagnieżdżonych pętli
   - Oryginalny kod porównuje elementy wielokrotnie.
   - Nowy kod przechodzi przez listę tylko jeden raz.

3. Zastosowanie dwóch zbiorów
   - seen przechowuje elementy już sprawdzone.
   - duplicates przechowuje znalezione duplikaty.

4. Konwersja wyniku na listę
   - list(duplicates) zwraca wynik w postaci listy,
     tak jak w oryginalnej funkcji.

## 5. Przykład działania

```python
liczby = [1, 2, 3, 2, 4, 5, 1, 3]

wynik = find_duplicates(liczby)

print(wynik)
```

Przykładowy wynik:

```text
[1, 2, 3]
```

Kolejność elementów w wyniku może być różna,
ponieważ zbiory w Pythonie nie gwarantują kolejności.

## 6. Porównanie wydajności

| Kryterium | Oryginalny kod | Zoptymalizowany kod |
|---|---|---|
| Liczba pętli | Dwie zagnieżdżone | Jedna |
| Złożoność czasowa | O(n²) | O(n) średnio |
| Wykorzystanie pamięci | Mniejsze | Większe |
| Wyszukiwanie elementów | Wolniejsze | Szybsze |
| Wydajność | Niższa | Wyższa |

## 7. Wnioski

Oryginalna funkcja działa poprawnie, ale przy dużych listach
może być wolna ze względu na dwie zagnieżdżone pętle.

Zoptymalizowana wersja wykorzystuje zbiory Python,
dzięki czemu sprawdzanie powtarzających się elementów
jest znacznie szybsze.

Złożoność czasowa została zmniejszona z O(n²) do O(n)
w przypadku średnim.

Wniosek: Zastosowanie odpowiednich struktur danych,
takich jak set, pozwala znacząco poprawić wydajność programu.
```

## 2. Zapisanie pliku i wysłanie do GitHub

```bash
git add Zadanie12.md
git commit -m "Zadanie 12: Optymalizacja kodu Python"
git push
```

**Uwaga:** Zoptymalizowana wersja może zwracać duplikaty w innej kolejności niż oryginał. Zachowuje jednak tę samą funkcjonalność dla elementów, które można umieścić w zbiorze (`set`).