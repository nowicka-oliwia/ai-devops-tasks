
# Zadanie 20 – Walidacja adresu IPv4 za pomocą Regex

## 1. Cel zadania

Celem zadania było stworzenie wyrażenia regularnego,
które sprawdza poprawność adresów IPv4.

Adres IPv4 składa się z czterech liczb oddzielonych kropkami.
Każda liczba musi mieścić się w zakresie od 0 do 255.

Przykład poprawnego adresu:

192.168.1.1

## 2. Wyrażenie regularne

```javascript
/^(?:(?:25[0-5]|2[0-4]\d|1\d{2}|[1-9]?\d)\.){3}(?:25[0-5]|2[0-4]\d|1\d{2}|[1-9]?\d)$/
```

## 3. Wyjaśnienie działania wyrażenia

Wyrażenie regularne składa się z kilku elementów:

- `^` – oznacza początek tekstu.
- `25[0-5]` – dopasowuje liczby od 250 do 255.
- `2[0-4]\d` – dopasowuje liczby od 200 do 249.
- `1\d{2}` – dopasowuje liczby od 100 do 199.
- `[1-9]?\d` – dopasowuje liczby od 0 do 99 bez zer wiodących.
- `|` – oznacza alternatywę.
- `\.` – dopasowuje kropkę.
- `{3}` – powtarza poprzedni element dokładnie trzy razy.
- `$` – oznacza koniec tekstu.

Dzięki temu wyrażenie sprawdza cztery liczby
z zakresu 0–255 oddzielone trzema kropkami.

## 4. Funkcja JavaScript

```javascript
function isValidIPv4(ip) {
    const ipv4Regex = /^(?:(?:25[0-5]|2[0-4]\d|1\d{2}|[1-9]?\d)\.){3}(?:25[0-5]|2[0-4]\d|1\d{2}|[1-9]?\d)$/;

    return ipv4Regex.test(ip);
}

module.exports = isValidIPv4;
```

## 5. Przykłady testów

| Adres IP | Oczekiwany wynik | Opis |
|---|---|---|
| 192.168.1.1 | true | Poprawny adres |
| 10.0.0.1 | true | Poprawny adres |
| 255.255.255.255 | true | Maksymalny adres |
| 0.0.0.0 | true | Minimalny adres |
| 256.1.1.1 | false | Liczba większa niż 255 |
| 192.168.1 | false | Brakuje jednej liczby |
| 192.168.1.999 | false | Nieprawidłowa liczba |
| abc.def.ghi.jkl | false | Nieprawidłowe znaki |
| 192.168.01.1 | false | Zero wiodące |

## 6. Kod testujący

```javascript
const isValidIPv4 = require('./ipv4-validator');

const testCases = [
    "192.168.1.1",
    "10.0.0.1",
    "255.255.255.255",
    "0.0.0.0",
    "256.1.1.1",
    "192.168.1",
    "192.168.1.999",
    "abc.def.ghi.jkl",
    "192.168.01.1"
];

testCases.forEach(ip => {
    console.log(`${ip} => ${isValidIPv4(ip)}`);
});
```

## 7. Wnioski

Wyrażenia regularne pozwalają szybko sprawdzać,
czy tekst spełnia określony format.

W tym zadaniu Regex sprawdza, czy adres zawiera
dokładnie cztery liczby z zakresu 0–255,
oddzielone kropkami.

Funkcja isValidIPv4 zwraca true dla poprawnych adresów
oraz false dla niepoprawnych.

Wniosek końcowy:
Wyrażenia regularne są przydatnym narzędziem
do walidacji danych w aplikacjach JavaScript.
