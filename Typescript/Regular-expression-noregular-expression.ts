function isMatch(s: string, p: string): boolean {
    const m = s.length;
    const n = p.length;
    
    // DP table
    const tabla: boolean[][] = Array.from({ length: m + 1 }, () => Array(n + 1).fill(false));
    
    // Base case: empty string matches empty pattern
    tabla[0][0] = true;
    
    // Handle patterns like a*, .*, etc., that can match empty string
    for (let j = 2; j <= n; j++) {
        if (p[j - 1] === '*') {
            tabla[0][j] = tabla[0][j - 2];
        }
    }
    
    // Fill the DP table
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            if (p[j - 1] === s[i - 1] || p[j - 1] === '.') {
                tabla[i][j] = tabla[i - 1][j - 1];
            } else if (p[j - 1] === '*') {
                tabla[i][j] = tabla[i][j - 2]; // '*' means zero occurrences
                if (p[j - 2] === s[i - 1] || p[j - 2] === '.') {
                    tabla[i][j] = tabla[i][j] || tabla[i - 1][j]; // '*' means one or more occurrences
                }
            }
        }
    }
    
    return tabla[m][n];
}
