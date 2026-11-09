
# Zadanie 27 – Diagram pipeline CI/CD w Jenkinsie

## 1. Cel zadania

Celem zadania było przygotowanie diagramu Mermaid
przedstawiającego typowy pipeline CI/CD w Jenkinsie.

Diagram znajduje się w pliku jenkins-pipeline.md.

## 2. Wyjaśnienie zależności między etapami

### 1. Checkout kodu

Jenkins pobiera najnowszy kod źródłowy
z repozytorium Git.

Jest to pierwszy etap pipeline, ponieważ
pozostałe operacje wymagają dostępu do kodu.

### 2. Budowanie aplikacji

Po pobraniu kodu następuje budowanie aplikacji.

Na tym etapie instalowane są potrzebne zależności
i przygotowywane są pliki aplikacji.

### 3. Testowanie

Uruchamiane są testy jednostkowe,
które sprawdzają poprawność działania poszczególnych
funkcji aplikacji.

Jeżeli testy zakończą się błędem,
pipeline zostaje przerwany.

### 4. Analiza statyczna kodu

Kod jest sprawdzany bez jego uruchamiania.

Analiza pozwala wykryć:
- Błędy programistyczne.
- Nieprawidłowe praktyki.
- Problemy z jakością kodu.
- Potencjalne problemy z utrzymaniem aplikacji.

### 5. Bezpieczeństwo

Na tym etapie wykonywane jest skanowanie
zależności i kodu pod kątem podatności.

Pozwala to wykryć niebezpieczne biblioteki
i potencjalne zagrożenia przed wdrożeniem.

### 6. Budowanie obrazu Docker

Po pozytywnym przejściu wcześniejszych etapów
Jenkins buduje obraz Docker.

Obraz zawiera aplikację oraz środowisko
potrzebne do jej uruchomienia.

### 7. Testy integracyjne

Sprawdzane jest współdziałanie różnych elementów
systemu, np. aplikacji, bazy danych i API.

Testy pozwalają wykryć problemy,
których nie wykryły testy jednostkowe.

### 8. Wdrożenie na staging

Jeżeli testy integracyjne zakończą się sukcesem,
aplikacja zostaje wdrożona na środowisko staging.

Jest to środowisko testowe przypominające produkcję.

### 9. Testy akceptacyjne

Na środowisku staging sprawdzane jest,
czy aplikacja spełnia wymagania użytkowników
i działa poprawnie z punktu widzenia funkcjonalności.

### 10. Wdrożenie na produkcję

Po pozytywnej akceptacji aplikacja zostaje
wdrożona na środowisko produkcyjne.

Na tym etapie aplikacja staje się dostępna
dla rzeczywistych użytkowników.

## 3. Zależności między etapami

Etapy pipeline są ze sobą bezpośrednio powiązane.

Każdy kolejny etap rozpoczyna się dopiero wtedy,
gdy poprzedni zakończy się sukcesem.

Przykładowo:

- Bez pobrania kodu nie można rozpocząć budowania.
- Bez poprawnego budowania nie można uruchomić testów.
- Bez zaliczonych testów nie powinno się publikować obrazu.
- Bez pozytywnych testów integracyjnych nie należy
  wdrażać aplikacji na staging.
- Bez akceptacji staging nie powinno się wdrażać
  aplikacji na produkcję.

W przypadku błędu pipeline zostaje zatrzymany,
aby zapobiec wdrożeniu niepoprawnej wersji aplikacji.

## 4. Korzyści z zastosowania CI/CD

1. Automatyzacja procesu wdrażania.
2. Szybsze wykrywanie błędów.
3. Większe bezpieczeństwo aplikacji.
4. Lepsza kontrola jakości kodu.
5. Powtarzalność procesu wdrażania.
6. Mniejsze ryzyko błędów podczas publikacji.

## 5. Wnioski

Pipeline CI/CD w Jenkinsie pozwala automatycznie
przeprowadzić aplikację przez kolejne etapy
budowania, testowania i wdrażania.

Każdy etap ma określone zadanie i zależy
od poprawnego wykonania wcześniejszych etapów.

Szczególnie ważne są testy, analiza statyczna
oraz kontrola bezpieczeństwa, ponieważ pozwalają
wykryć problemy jeszcze przed wdrożeniem aplikacji.

Wniosek końcowy:

Dobrze zaprojektowany pipeline CI/CD zwiększa
niezawodność aplikacji, przyspiesza pracę zespołu
i ogranicza ryzyko wdrożenia błędnego kodu.
