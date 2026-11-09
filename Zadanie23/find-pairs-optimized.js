// Zoptymalizowany algorytm wyszukujący pary liczb.
// Wykorzystuje Set do szybkiego sprawdzania,
// czy potrzebna liczba została już wcześniej znaleziona.

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
  
  module.exports = findPairs;
  
  // Przykład użycia:
  console.log(findPairs([1, 2, 3, 4, 5], 6));
  
  // Wynik: [[1, 5], [2, 4]]