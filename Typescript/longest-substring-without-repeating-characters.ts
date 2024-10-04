function lengthOfLongestSubstring(s: string): number {
    const cache: Array<string> = [];
    let acc = "";
    let count = 1;
    for(let i = 0; i < s.length; i++){
        if(acc.includes(s[i])){
            cache.push(acc);
            acc = "";
            continue;
        }
            acc += s[i];
            count+=1;
    }
    cache.push(acc);
    const max = cache.reduce((acc, value) => {
        if(value.length > acc.length){
            acc = value;
        }
        return acc;
    }, "").length;
    return max;
};
