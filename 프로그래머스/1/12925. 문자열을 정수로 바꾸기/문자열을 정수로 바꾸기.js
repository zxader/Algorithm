function solution(s) {
    var answer = 0;
    let temp = "";
    if (s[0] != "-") return +s;
    for (let i = 1; i < s.length; i++) {
            temp += s[i];
    }
 
    answer = -temp;
 
    return answer;
}