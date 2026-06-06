function solution(arr)
{
    const answer = [];
    
    for (let i of arr) {
        if (answer[answer.length - 1] == i) continue;
        answer.push(i)    
    }
    
    
    return answer;
}