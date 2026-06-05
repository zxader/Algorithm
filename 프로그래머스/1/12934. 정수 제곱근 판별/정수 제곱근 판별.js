function solution(n) {
    let x = Math.floor(Math.sqrt(n));
    if (n == Math.pow(x , 2)) return Math.pow(x + 1, 2);
    
    return -1;
}