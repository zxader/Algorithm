function solution(array, commands) {
    var answer = [];
    
    for (let c of commands) {
        const a = c[0] - 1;
        const b = c[1];
        const l = c[2];
        
        const arr = array.slice(a, b);
        
        arr.sort((a, b) => a - b);
        
        answer.push(arr[l - 1]);
    }
    return answer;
}