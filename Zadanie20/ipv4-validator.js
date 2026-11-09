
function isValidIPv4(ip) {
    const ipv4Regex = /^(?:(?:25[0-5]|2[0-4]\d|1\d{2}|[1-9]?\d)\.){3}(?:25[0-5]|2[0-4]\d|1\d{2}|[1-9]?\d)$/;

    return ipv4Regex.test(ip);
}

// Przykładowe testy
console.log(isValidIPv4("192.168.1.1"));   // true
console.log(isValidIPv4("10.0.0.1"));      // true
console.log(isValidIPv4("255.255.255.255")); // true
console.log(isValidIPv4("0.0.0.0"));       // true

console.log(isValidIPv4("256.1.1.1"));     // false
console.log(isValidIPv4("192.168.1"));     // false
console.log(isValidIPv4("192.168.1.999")); // false
console.log(isValidIPv4("abc.def.ghi.jkl")); // false
console.log(isValidIPv4("192.168.01.1"));  // false

module.exports = isValidIPv4;
