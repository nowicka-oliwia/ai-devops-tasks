
# Zadanie 23 – Analiza złożoności algorytmu findPairs

## 1. Opis zadania

Celem zadania było przeanalizowanie algorytmu
wyszukującego pary liczb, których suma jest równa
podanej wartości targetSum.

Następnie należało zoptymalizować algorytm,
aby działał szybciej i wykorzystywał odpowiednią
strukturę danych.

## 2. Oryginalny algorytm

```javascript
function findPairs(arr, targetSum) {
  const pairs = [];

  for (let i = 0; i < arr.length; i++) {
    for (let j = i + 1; j < arr.length; j++) {
      if (arr[i] + arr[j] === targetSum) {
        pairs.push([arr[i], arr[j]]);
      }
    }
  }

  return pairs;
}
```

## 3. Analiza złożoności oryginalnego algorytmu

### Złożoność czasowa: O(n²)

Algorytm wykorzystuje dwie zagnieżdżone pętle.

Pierwsza pętla przechodzi przez wszystkie elementy tablicy.
Druga pętla porównuje aktualny element z kolejnymi elementami.

W przypadku większych tablic liczba porównań
znacząco wzrasta.

### Złożoność pamięciowa: O(k)

Algorytm przechowuje znalezione pary w tablicy pairs.

Oznaczenie k oznacza liczbę znalezionych par.
W najgorszym przypadku może ich być O(n²).

## 4. Zoptymalizowany algorytm

```javascript
function findPairs(arr, targetSum) {
  const pairs = [];
  const seen = new Set();

  for (const num of arr) {
    const complement = targetSum - num;

    if (seen.has(complement)) {
      pairs.push([complement, num]);
    }

    seen.add(num);
  }

  return pairs;
}
```

## 5. Wyjaśnienie optymalizacji

W zoptymalizowanej wersji wykorzystano strukturę Set.

Set przechowuje liczby, które zostały już sprawdzone.

Dla każdej liczby obliczana jest wartość complement,
czyli liczba potrzebna do uzyskania targetSum.

Jeśli potrzebna liczba znajduje się już w zbiorze,
oznacza to, że znaleziono odpowiednią parę.

Dzięki temu nie trzeba porównywać każdego elementu
z wszystkimi pozostałymi elementami tablicy.

## 6. Analiza złożoności zoptymalizowanego algorytmu

### Złożoność czasowa: O(n) średnio

Algorytm przechodzi przez tablicę tylko jeden raz.

Operacje sprawdzania i dodawania elementów do Set
mają średnio złożoność O(1).

Dlatego całkowita złożoność czasowa wynosi O(n)
średnio, pomijając koszt zapisywania wyników.

### Złożoność pamięciowa: O(n + k)

Set może przechowywać maksymalnie n elementów,
natomiast tablica pairs przechowuje k znalezionych par.

## 7. Porównanie algorytmów

| Kryterium | Oryginalny | Zoptymalizowany |
|---|---|---|
| Złożoność czasowa | O(n²) | O(n) średnio |
| Dwie zagnieżdżone pętle | Tak | Nie |
| Wykorzystanie Set | Nie | Tak |
| Dodatkowa pamięć | O(k) | O(n + k) |
| Wydajność | Niższa | Wyższa |

## 8. Przykład działania

```javascript
const findPairs = require('./find-pairs-optimized');

const numbers = [1, 2, 3, 4, 5];
const targetSum = 6;

console.log(findPairs(numbers, targetSum));
```

Wynik:

```text
[[1, 5], [2, 4]]
```

## 9. Wnioski

Oryginalny algorytm wykorzystuje dwie zagnieżdżone
pętle, przez co jego złożoność czasowa wynosi O(n²).

Zoptymalizowana wersja wykorzystuje Set,
dzięki czemu można sprawdzać potrzebne liczby
znacznie szybciej.

Złożoność czasowa została zmniejszona do O(n)
w przypadku średnim.

Wadą nowej wersji jest większe wykorzystanie pamięci,
ponieważ przechowuje dodatkowy zbiór sprawdzonych liczb.

Wniosek końcowy:

Zastosowanie odpowiednich struktur danych pozwala
znacząco poprawić wydajność algorytmów.
W tym przypadku Set pozwolił zastąpić zagnieżdżone
pętle pojedynczym przejściem przez tablicę.

Uwaga: zoptymalizowana wersja zachowuje możliwość
wielokrotnego występowania tej samej pary wartości,
jeżeli wejściowa tablica zawiera odpowiednie duplikaty.
