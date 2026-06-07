function solution(priorities, location) {
    
    
    const q = [];
    
    for (let i = 0; i < priorities.length; i++) {
        q.push({no:i, v:priorities[i]});
    }
    
    const arr = [];
    let cnt = 1;
    while(q.length > 0) {
        let max = q[0].v;
        let idx = 0;
        for (let i = 1; i < q.length; i++) {
            if (max < q[i].v) {
                max = q[i].v;
                idx = i;
            }
        }
        
        for (let i = 0; i < idx; i++) {
            q.push(q.shift());
        }
        
        arr[q.shift().no] = cnt;
        cnt++;
    }
    console.log(arr);

    return arr[location];
}