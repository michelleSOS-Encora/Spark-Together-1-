function isMatch(s: string, p: string): boolean {
    const regex = new RegExp(`^${p}$`);
    const result = regex.test(s);
    return result;  
};