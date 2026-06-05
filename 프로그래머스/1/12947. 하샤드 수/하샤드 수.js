function solution(x) {
    let a = x;
    let b = 0;
    while (x > 0) {
        b += x % 10;
        x = Math.floor(x/10);
    }

    return (a % b == 0) ? true : false;
}