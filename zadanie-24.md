
# Zadanie 24 – Analiza wydajności serwera API

## 1. Dane wydajnościowe z ostatnich 24 godzin

| Metryka | Wartość |
|---|---:|
| Średni czas odpowiedzi | 230 ms |
| 95 percentyl (P95) | 450 ms |
| 99 percentyl (P99) | 1200 ms |
| Liczba zapytań | 15 000 |
| Liczba błędów 5xx | 120 |
| Średnie użycie CPU | 45% |
| Maksymalne użycie CPU | 80% |
| Średnie użycie pamięci | 2.1 GB |
| Maksymalne użycie pamięci | 3.5 GB |
| Dostępna pamięć | 4 GB |

## 2. Interpretacja danych

### Czas odpowiedzi

Średni czas odpowiedzi wynosi 230 ms.
Jest to całkiem dobry wynik, jednak warto zwrócić uwagę
na wartości percentyli.

- P95 = 450 ms oznacza, że 95% zapytań otrzymało
  odpowiedź w czasie nieprzekraczającym 450 ms.
- P99 = 1200 ms oznacza, że 99% zapytań otrzymało
  odpowiedź w czasie nieprzekraczającym 1200 ms.

Wyniki wskazują, że większość zapytań działa sprawnie,
ale niewielka część użytkowników może doświadczać
znacznie dłuższego oczekiwania na odpowiedź.

### Liczba zapytań

Serwer obsłużył 15 000 zapytań w ciągu 24 godzin.

Średnia liczba zapytań na godzinę wynosi około 625.

Oznacza to, że serwer obsługuje umiarkowany ruch,
ale warto monitorować jego zachowanie w godzinach
największego obciążenia.

### Liczba błędów 5xx

Wystąpiło 120 błędów serwera.

Wskaźnik błędów wynosi:

120 / 15000 * 100 = 0,8%

Oznacza to, że około 0,8% zapytań zakończyło się
błędem po stronie serwera.

Jest to problem wymagający sprawdzenia,
ponieważ błędy 5xx mogą oznaczać problemy
z aplikacją, bazą danych lub infrastrukturą.

### Użycie procesora CPU

Średnie wykorzystanie CPU wynosi 45%,
natomiast maksymalne 80%.

Procesor nie jest stale przeciążony,
ale podczas większego ruchu może zbliżać się
do granicy wydajności.

### Użycie pamięci RAM

Średnie użycie pamięci wynosi 2.1 GB,
a maksymalne 3.5 GB z dostępnych 4 GB.

Oznacza to, że w najgorszym momencie wykorzystano
87,5% dostępnej pamięci.

Jest to potencjalnie największy problem infrastruktury.
Brak wolnej pamięci może powodować spowolnienia,
problemy z działaniem kontenerów lub ich restartowanie.

## 3. Zidentyfikowane problemy

1. **Wysoki czas odpowiedzi P99**

   Niektóre zapytania trwają nawet ponad sekundę.
   Może to wskazywać na wolne zapytania do bazy danych,
   brak indeksów lub problemy z zewnętrznymi usługami.

2. **Błędy serwera 5xx**

   Wskaźnik błędów wynosi 0,8%.
   Należy przeanalizować logi serwera i ustalić
   najczęstsze przyczyny błędów.

3. **Wysokie wykorzystanie pamięci RAM**

   Maksymalne wykorzystanie pamięci wynosi 87,5%.
   Pozostawia to niewielki zapas na nagły wzrost ruchu.

4. **Wysokie chwilowe użycie CPU**

   Maksymalne wykorzystanie procesora wynosi 80%.
   Warto sprawdzić, które operacje powodują największe
   obciążenie procesora.

## 4. Proponowane rozwiązania

### 4.1. Optymalizacja zapytań do bazy danych

- Dodanie indeksów do często wyszukiwanych pól.
- Unikanie pobierania niepotrzebnych danych.
- Analiza najwolniejszych zapytań.
- Ograniczenie liczby zapytań wykonywanych przez API.

### 4.2. Wprowadzenie cache

Warto zastosować Redis do przechowywania
często pobieranych danych.

Dzięki temu aplikacja nie będzie musiała
za każdym razem odpytywać bazy danych.

### 4.3. Optymalizacja pamięci

- Monitorowanie wykorzystania RAM.
- Sprawdzanie możliwych wycieków pamięci.
- Ograniczenie przechowywania dużych obiektów.
- Analiza zużycia pamięci przez kontenery Docker.
- Rozważenie zwiększenia dostępnej pamięci RAM.

### 4.4. Analiza błędów 5xx

Należy sprawdzić logi aplikacji i ustalić,
czy błędy wynikają z:

- Problemów z połączeniem z bazą danych.
- Przekroczenia limitu czasu odpowiedzi.
- Nieobsłużonych wyjątków w kodzie.
- Niedostępności zewnętrznych usług.
- Braku dostępnych zasobów serwera.

### 4.5. Monitorowanie serwera

Warto wykorzystać narzędzia:

- Prometheus – zbieranie metryk.
- Grafana – wizualizacja danych.
- Loki – analiza logów.
- cAdvisor – monitorowanie kontenerów Docker.

## 5. Priorytety działań

| Priorytet | Działanie | Powód |
|---|---|---|
| Wysoki | Analiza błędów 5xx | Poprawa niezawodności API |
| Wysoki | Optymalizacja pamięci RAM | Mały zapas dostępnej pamięci |
| Wysoki | Analiza zapytań P99 | Poprawa czasu odpowiedzi |
| Średni | Wprowadzenie Redis | Ograniczenie obciążenia bazy |
| Średni | Optymalizacja CPU | Zmniejszenie chwilowego obciążenia |
| Niski | Rozbudowa dashboardów | Lepsza obserwowalność |

## 6. Wnioski

Na podstawie przedstawionych danych można stwierdzić,
że serwer API działa stosunkowo dobrze,
ale występuje kilka obszarów wymagających poprawy.

Największą uwagę należy zwrócić na:

- Maksymalne wykorzystanie pamięci RAM wynoszące 87,5%.
- Wskaźnik błędów 5xx wynoszący 0,8%.
- Czas odpowiedzi P99 wynoszący 1200 ms.

W pierwszej kolejności proponuję przeanalizować logi
błędów serwera oraz zoptymalizować zapytania do bazy danych.

Następnie warto wdrożyć mechanizm cache i poprawić
monitorowanie wykorzystania pamięci.

Wniosek końcowy:

Serwer nie jest stale przeciążony, jednak wysokie
chwilowe zużycie pamięci i długi czas odpowiedzi
niektórych zapytań mogą negatywnie wpływać
na komfort użytkowników.

Regularne monitorowanie i optymalizacja pozwolą
zwiększyć wydajność, stabilność i niezawodność API.
