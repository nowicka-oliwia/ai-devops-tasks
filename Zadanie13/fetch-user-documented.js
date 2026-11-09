
/**
 * Pobiera dane użytkownika z zewnętrznego API.
 *
 * @async
 * @function fetchUserData
 * @param {number|string} userId - Unikalny identyfikator użytkownika.
 * @returns {Promise<{name: string, email: string, lastLogin: Date}|null>}
 * Zwraca obiekt z danymi użytkownika lub null w przypadku błędu.
 *
 * @throws {Error} Wewnętrzny błąd HTTP jest obsługiwany przez catch.
 *
 * @example
 * fetchUserData(1).then(user => {
 *   console.log(user);
 * });
 */
function fetchUserData(userId) {
    return fetch(`https://api.example.com/users/${userId}`)
      .then(response => {
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
      })
      .then(data => {
        return {
          name: data.name,
          email: data.email,
          lastLogin: new Date(data.lastLoginTimestamp)
        };
      })
      .catch(error => {
        console.error('Fetch error:', error);
        return null;
      });
  }
  
  module.exports = fetchUserData;
  