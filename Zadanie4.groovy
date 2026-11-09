
def tresc = """# Zadanie 4 – Przypisywanie roli modelowi AI

## 1. Zwykłe pytanie

Prompt:

Jak poprawić bezpieczeństwo aplikacji internetowej?

### Przykładowa odpowiedź AI:

Aby poprawić bezpieczeństwo aplikacji internetowej, warto:

1. Stosować silne hasła.
2. Korzystać z szyfrowania HTTPS.
3. Regularnie aktualizować oprogramowanie.
4. Zabezpieczać formularze przed atakami.
5. Wykonywać kopie zapasowe danych.
6. Ograniczać dostęp do poufnych informacji.

Dzięki tym działaniom można zmniejszyć ryzyko ataków
i utraty danych.

## 2. Pytanie z przypisaną rolą

Prompt:

Jesteś doświadczonym specjalistą ds. cyberbezpieczeństwa
i ekspertem w zabezpieczaniu aplikacji internetowych.

Przeanalizuj, jak poprawić bezpieczeństwo aplikacji internetowej.
Przedstaw konkretne zalecenia, wyjaśnij ich znaczenie
i podaj praktyczne przykłady.

### Przykładowa odpowiedź AI:

Jako specjalista ds. cyberbezpieczeństwa zalecam zastosowanie
wielowarstwowego podejścia do ochrony aplikacji internetowej.

1. Walidacja danych wejściowych
   - Sprawdzaj wszystkie dane przesyłane przez użytkownika.
   - Stosuj zapytania parametryzowane, aby ograniczyć ryzyko SQL Injection.

2. Uwierzytelnianie i autoryzacja
   - Stosuj bezpieczne hashowanie haseł, np. Argon2.
   - Wprowadź uwierzytelnianie wieloskładnikowe (MFA).
   - Przydzielaj użytkownikom tylko niezbędne uprawnienia.

3. Szyfrowanie komunikacji
   - Korzystaj z protokołu HTTPS.
   - Wymuszaj bezpieczne połączenia za pomocą odpowiedniej konfiguracji.

4. Ochrona przed popularnymi atakami
   - Zabezpiecz aplikację przed XSS i CSRF.
   - Stosuj odpowiednie nagłówki bezpieczeństwa HTTP.
   - Regularnie analizuj zależności pod kątem znanych podatności.

5. Monitorowanie i aktualizacje
   - Regularnie aktualizuj frameworki i biblioteki.
   - Monitoruj logi aplikacji.
   - Przygotuj procedurę reagowania na incydenty.

6. Kopie zapasowe
   - Regularnie wykonuj kopie zapasowe.
   - Sprawdzaj możliwość ich odtworzenia.

Podsumowanie:
Bezpieczeństwo aplikacji powinno być uwzględniane
na każdym etapie jej tworzenia i utrzymania.
Najlepsze rezultaty daje połączenie dobrych praktyk
programistycznych, odpowiedniej konfiguracji oraz monitorowania.

## 3. Porównanie odpowiedzi

| Kryterium | Zwykłe pytanie | Pytanie z rolą |
|---|---|---|
| Szczegółowość | Niewielka | Duża |
| Długość | Krótka | Dłuższa |
| Specjalistyczny język | Podstawowy | Techniczny |
| Przykłady | Ogólne | Konkretne |
| Charakter odpowiedzi | Uniwersalny | Ekspercki |

## 4. Moje obserwacje

Po porównaniu obu odpowiedzi zauważyłem, że przypisanie modelowi
konkretnej roli znacząco wpływa na sposób przedstawiania informacji.

Zwykłe pytanie spowodowało wygenerowanie krótkiej i ogólnej odpowiedzi.
Model przedstawił podstawowe wskazówki dotyczące bezpieczeństwa aplikacji.

Po przypisaniu AI roli specjalisty ds. cyberbezpieczeństwa odpowiedź
stała się bardziej szczegółowa i profesjonalna. Pojawiły się
specjalistyczne pojęcia, takie jak SQL Injection, XSS, CSRF i MFA,
a także konkretne przykłady rozwiązań.

## 5. Wnioski

Moim zdaniem przypisywanie roli modelowi AI jest bardzo przydatne,
szczególnie gdy potrzebujemy odpowiedzi z konkretnej dziedziny.

Dzięki temu możemy uzyskać bardziej specjalistyczne informacje,
lepiej dopasowane do wykonywanego zadania.

Wniosek końcowy: Dobrze określona rola AI pomaga uzyskać
bardziej szczegółowe, profesjonalne i uporządkowane odpowiedzi.

Uwaga: Odpowiedzi w dokumencie są przykładowe i nie pochodzą
z rzeczywistych rozmów z asystentem AI.
"""

def plik = new File("zadanie-4.md")
plik.setText(tresc, "UTF-8")

println "Utworzono plik: ${plik.absolutePath}"
println "Zadanie 4 zapisane pomyślnie!"
