// Oryginalny algorytm wyszukujący pary liczb,
// których suma jest równa targetSum.

function findPairs(arr, targetSum) {
    const pairs = [];
  
    for (let i = 0; i < arr.length; i++) {
      for (let j = i + 1; j < arr.length; j++) {
        if (arr[i] + arr[j] === targetSum) {
          pairs.push([arr[i], arr[j]]);
        }
      }
    }
  
    return pairs;
  }
  
  module.exports = findPairs;
  
  // Przykład użycia:
  console.log(findPairs([1, 2, 3, 4, 5], 6));
  
  // Wynik: [[1, 5], [2, 4]]