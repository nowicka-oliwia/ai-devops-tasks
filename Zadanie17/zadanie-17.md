
# Zadanie 17 – Filtrowanie i sortowanie zadań JavaScript

## 1. Opis rozwiązania

Funkcja getCompletedTaskTitles przyjmuje tablicę obiektów
reprezentujących zadania.

Każde zadanie posiada trzy właściwości:
- id – identyfikator zadania.
- title – tytuł zadania.
- status – status zadania.

Funkcja wykonuje trzy operacje:

1. filter() – wybiera tylko zadania ze statusem completed.
2. sort() – sortuje zadania według identyfikatora rosnąco.
3. map() – zwraca tablicę zawierającą wyłącznie tytuły zadań.

## 2. Kod funkcji

```javascript
function getCompletedTaskTitles(tasks) {
    return tasks
        .filter(task => task.status === "completed")
        .sort((a, b) => a.id - b.id)
        .map(task => task.title);
}

module.exports = getCompletedTaskTitles;
```

## 3. Przykład użycia

```javascript
const getCompletedTaskTitles = require('./task-filter');

const tasks = [
    { id: 3, title: "Nauka JavaScript", status: "completed" },
    { id: 1, title: "Instalacja Node.js", status: "completed" },
    { id: 2, title: "Tworzenie aplikacji", status: "pending" },
    { id: 4, title: "Testowanie kodu", status: "completed" }
];

const result = getCompletedTaskTitles(tasks);

console.log(result);
```

## 4. Wynik działania

```text
[
  "Instalacja Node.js",
  "Nauka JavaScript",
  "Testowanie kodu"
]
```

## 5. Wyjaśnienie działania

- filter() – usuwa zadania, które nie mają statusu completed.
- sort() – ustawia zadania według id od najmniejszego do największego.
- map() – przekształca obiekty w same tytuły.

Zastosowanie tych trzech metod pozwala wykonać wszystkie
wymagane operacje w czytelny i krótki sposób.

## 6. Wnioski

Funkcja spełnia wszystkie wymagania zadania.
Filtruje ukończone zadania, sortuje je rosnąco według ID
i zwraca wyłącznie ich tytuły.

Wykorzystanie metod filter(), sort() i map()
sprawia, że kod jest prosty, czytelny i łatwy w utrzymaniu.
