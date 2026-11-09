def tresc = """# Zadanie 2 – Porównanie modeli AI

## 1. Wybrane modele

- Model 1: GPT-4
- Model 2: Claude 3.5 Sonnet

## 2. Pytanie zadane obu modelom

Wyjaśnij, czym jest język programowania Python.
Podaj jego najważniejsze zalety oraz pokaż prosty przykład kodu.

## 3. Odpowiedź modelu GPT-4

Python to wysokopoziomowy język programowania o prostej i czytelnej składni.
Jest wykorzystywany do tworzenia stron internetowych, analizy danych,
sztucznej inteligencji i automatyzacji.

Najważniejsze zalety:
1. Prosta składnia.
2. Duża liczba bibliotek.
3. Szerokie zastosowanie.
4. Duża społeczność programistów.
5. Łatwość nauki.

Przykład kodu:

    imie = input("Podaj swoje imię: ")
    print("Witaj, " + imie + "!")

Program pobiera imię użytkownika i wyświetla powitanie.

## 4. Odpowiedź modelu Claude 3.5 Sonnet

Python jest popularnym językiem programowania, który wyróżnia się
prostotą i czytelnością. Jest szczególnie polecany osobom rozpoczynającym
naukę programowania.

Zastosowania Pythona:
- tworzenie stron internetowych,
- analiza danych,
- sztuczna inteligencja,
- automatyzacja zadań,
- uczenie maszynowe.

Przykład kodu:

    def powitanie(imie):
        return f"Cześć, {imie}! Miło Cię poznać."

    uzytkownik = input("Jak masz na imię? ")
    print(powitanie(uzytkownik))

W tym przykładzie wykorzystano funkcję, która przyjmuje imię użytkownika
i zwraca komunikat powitalny.

## 5. Porównanie odpowiedzi

| Kryterium | GPT-4 | Claude 3.5 Sonnet |
|---|---|---|
| Szczegółowość | Konkretna | Bardziej opisowa |
| Długość | Krótsza | Dłuższa |
| Przykład | Prosty | Wykorzystuje funkcję |
| Czytelność | Bardzo dobra | Bardzo dobra |

## 6. Podsumowanie

GPT-4 przedstawił odpowiedź w sposób krótki, konkretny i uporządkowany.
Jego przykład kodu był prosty i odpowiedni dla początkujących.

Claude 3.5 Sonnet przygotował bardziej rozbudowaną odpowiedź.
Pokazał przykład wykorzystujący funkcję, dzięki czemu można było
poznać nieco bardziej zaawansowany sposób programowania.

Moim zdaniem GPT-4 lepiej sprawdza się przy szybkich i konkretnych
odpowiedziach, natomiast Claude 3.5 Sonnet jest pomocny przy
dokładniejszym wyjaśnianiu zagadnień.

Wniosek: Oba modele są przydatne, ale różnią się długością,
szczegółowością i sposobem przedstawiania przykładów.

Uwaga: Odpowiedzi są przykładowe i nie pochodzą z rzeczywistych
rozmów z wymienionymi modelami.
"""

def plik = new File("zadanie-2.md")
plik.setText(tresc, "UTF-8")

println "Utworzono plik: ${plik.absolutePath}"
println "Zadanie 2 zostało zapisane pomyślnie."