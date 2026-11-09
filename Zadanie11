
# Zadanie 11 – Testy jednostkowe z Jest

## 1. Czym jest Jest?

Jest to popularny framework do testowania kodu JavaScript.
Pozwala automatycznie sprawdzać, czy funkcje działają poprawnie.

Jest jest wykorzystywany między innymi w projektach Node.js
i aplikacjach React.

Dzięki testom jednostkowym można szybciej wykrywać błędy
i sprawdzać poprawność działania poszczególnych funkcji.

## 2. Instalacja Jest

Aby zainstalować Jest w projekcie Node.js, należy otworzyć terminal
w katalogu projektu i wykonać polecenie:

```bash
npm install --save-dev jest
```

Polecenie instaluje Jest jako zależność developerską.

Następnie w pliku package.json należy dodać skrypt:

```json
{
  "scripts": {
    "test": "jest"
  }
}
```

## 3. Struktura plików projektu

```text
projekt/
│
├── node_modules/
├── sum.js
├── sum.test.js
├── package.json
└── package-lock.json
```

## 4. Plik sum.js

```javascript
function sum(a, b) {
    return a + b;
}

module.exports = sum;
```

Funkcja sum przyjmuje dwie liczby i zwraca ich sumę.
Eksportowanie funkcji umożliwia wykorzystanie jej w teście.

## 5. Plik sum.test.js

```javascript
const sum = require('./sum');

test('dodaje dwie liczby', () => {
    expect(sum(2, 3)).toBe(5);
});

test('dodaje liczby ujemne', () => {
    expect(sum(-2, -3)).toBe(-5);
});

test('dodaje zero', () => {
    expect(sum(5, 0)).toBe(5);
});
```

Testy sprawdzają trzy przypadki:
- Dodawanie dwóch dodatnich liczb.
- Dodawanie dwóch liczb ujemnych.
- Dodawanie zera.

## 6. Uruchomienie testów

W terminalu należy wykonać polecenie:

```bash
npm test
```

Jest automatycznie wyszuka pliki testowe i uruchomi
zawarte w nich testy.

## 7. Przykładowy wynik

```text
PASS ./sum.test.js

Test Suites: 1 passed, 1 total
Tests:       3 passed, 3 total
Snapshots:   0 total
```

Oznacza to, że wszystkie trzy testy zakończyły się powodzeniem.

## 8. Wyjaśnienie najważniejszych poleceń

- test() – definiuje pojedynczy test jednostkowy.
- expect() – określa wartość, którą chcemy sprawdzić.
- toBe() – porównuje wynik z oczekiwaną wartością.
- require() – importuje funkcję z innego pliku.
- module.exports – udostępnia funkcję innym plikom.

## 9. Wnioski

Jest ułatwia testowanie aplikacji JavaScript.
Dzięki niemu można automatycznie sprawdzać poprawność działania funkcji.

W wykonanym zadaniu utworzono funkcję sum oraz trzy testy jednostkowe.
Wszystkie testy powinny zakończyć się powodzeniem.

Testy jednostkowe pomagają wykrywać błędy już na wczesnym etapie
tworzenia aplikacji i poprawiają jakość kodu.
