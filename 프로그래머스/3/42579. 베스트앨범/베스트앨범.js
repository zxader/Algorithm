function solution(genres, plays) {
    const map = new Map();
    
    for (let i = 0; i < genres.length; i++) {
        map.set(genres[i], []);
    }
    
    for (let i = 0; i < genres.length; i++) {
        map.get(genres[i]).push({no: i, v: plays[i]});
    }
    
    for (let m of map.values()) {

        m.sort((a, b) => {
            if (a.v == b.v) {
                return a.no - b.no;
            }
            return b.v - a.v;
        })
    }
    
    const temp = new Map();
    
    for (let [key, value] of map) {
        let sum = 0;
        for(let i of value) {
            sum += i.v;
        }
        temp.set(key, sum);
    }


    const sortedMap = [...temp].sort((a, b) => b[1] - a[1]);

    var answer = [];
    for (let [key, value] of sortedMap) {
        
        const maxCount = Math.min(map.get(key).length, 2);
        for (let i = 0; i < maxCount; i++) {
            answer.push(map.get(key)[i].no);
        }
        
    }
    return answer;
}