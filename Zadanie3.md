
def tresc = """# Zadanie 3 – Podstawowe formatowanie promptu

## 1. Prompt niestrukturyzowany

Polecenie:
dockerfile node

### Przykładowa odpowiedź AI:

Aby utworzyć Dockerfile dla aplikacji Node.js, można użyć następującego kodu:

    FROM node:18
    WORKDIR /app
    COPY . .
    RUN npm install
    EXPOSE 3000
    CMD ["npm", "start"]

Dockerfile wykorzystuje Node.js w wersji 18, kopiuje pliki aplikacji,
instaluje zależności i uruchamia aplikację na porcie 3000.

## 2. Prompt strukturyzowany

Polecenie:

Napisz prosty Dockerfile dla aplikacji Node.js, który:
- używa Node 18 jako obrazu bazowego
- kopiuje pliki package.json i package-lock.json
- instaluje zależności
- kopiuje resztę plików aplikacji
- wystawia port 3000
- uruchamia aplikację poleceniem "npm start"

### Przykładowa odpowiedź AI:

    FROM node:18

    WORKDIR /app

    COPY package*.json ./

    RUN npm install

    COPY . .

    EXPOSE 3000

    CMD ["npm", "start"]

### Wyjaśnienie:

- FROM node:18 – wybiera obraz Node.js w wersji 18.
- WORKDIR /app – ustawia katalog roboczy aplikacji.
- COPY package*.json ./ – kopiuje pliki package.json i package-lock.json.
- RUN npm install – instaluje wymagane zależności.
- COPY . . – kopiuje pozostałe pliki aplikacji.
- EXPOSE 3000 – deklaruje port aplikacji.
- CMD ["npm", "start"] – uruchamia aplikację.

## 3. Porównanie odpowiedzi

| Kryterium | Prompt prosty | Prompt strukturyzowany |
|---|---|---|
| Szczegółowość | Mała | Duża |
| Długość odpowiedzi | Krótsza | Dłuższa |
| Kolejność instrukcji | Ogólna | Dokładnie określona |
| Instalacja zależności | npm install | npm install |
| Kopiowanie plików | Wszystkie pliki od razu | Najpierw pliki package |
| Wyjaśnienie kodu | Krótkie | Szczegółowe |

## 4. Wnioski

Po porównaniu obu odpowiedzi zauważyłem, że sposób sformułowania promptu
ma duży wpływ na jakość otrzymanego wyniku.

Prompt niestrukturyzowany był bardzo krótki, dlatego odpowiedź AI
była ogólna i nie zawierała dokładnych wyjaśnień poszczególnych instrukcji.

Prompt strukturyzowany pozwolił uzyskać bardziej uporządkowany wynik.
AI przygotowało Dockerfile zgodny z podanymi wymaganiami oraz wyjaśniło
działanie poszczególnych poleceń.

Moim zdaniem lepiej korzystać ze strukturyzowanych promptów,
ponieważ pozwalają dokładniej określić oczekiwany rezultat,
ograniczają nieporozumienia i ułatwiają uzyskanie poprawnej odpowiedzi.

Wniosek końcowy: Im dokładniej opisujemy zadanie, tym większa szansa
na otrzymanie odpowiedzi dopasowanej do naszych oczekiwań.

Uwaga: Odpowiedzi w tym dokumencie są przykładowe.
"""

def plik = new File("zadanie-3.md")
plik.setText(tresc, "UTF-8")

println "Utworzono plik: ${plik.absolutePath}"
println "Zadanie 3 zapisane pomyślnie!"
