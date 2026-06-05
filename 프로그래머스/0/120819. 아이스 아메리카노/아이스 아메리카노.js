function solution(money) {
    let coffee = Math.floor(money / 5500);
    let rest = money % 5500;
    var answer = [coffee, rest];
    return answer;
}