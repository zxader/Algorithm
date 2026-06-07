function solution(s){
    const stack = [];
    for (let c of s) {
        if (c == "(") {
            stack.push("(");
        }
        else {
            if (stack.length > 0) {
                stack.pop();
            }
            else {
                return false;
            }
        }
    }
    if (stack.length > 0) return false;

    return true;
}