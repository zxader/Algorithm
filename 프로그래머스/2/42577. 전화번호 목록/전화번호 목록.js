function solution(phone_book) {
    const set = new Set(phone_book);
    
    for (let p of phone_book) {
        let temp = '';
        for (let i = 0; i < p.length - 1; i++) {
            temp += p[i];
            if (set.has(temp)) return false;
        }
        
        
    }
    
    return true;
}