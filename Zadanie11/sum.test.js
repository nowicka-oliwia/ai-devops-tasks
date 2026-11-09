// Importujemy funkcję sum z pliku sum.js
const sum = require('./sum');

// Test sprawdzający poprawność dodawania
test('dodaje dwie liczby', () => {
    // Oczekujemy, że wynik 2 + 3 będzie równy 5
    expect(sum(2, 3)).toBe(5);
});

// Test sprawdzający dodawanie liczb ujemnych
test('dodaje liczby ujemne', () => {
    expect(sum(-2, -3)).toBe(-5);
});

// Test sprawdzający dodawanie zera
test('dodaje zero', () => {
    expect(sum(5, 0)).toBe(5);
});