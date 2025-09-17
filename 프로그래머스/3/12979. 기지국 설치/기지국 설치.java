import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        Arrays.sort(stations);        
        
        int start = 1;
        int answer = 0;
        int v = 2 * w + 1;
        
        for (int i = 0; i < stations.length; i++) {
            int a = stations[i] - w;
            int b = stations[i] + w;
            
            if (a <= start) {
                start = b + 1;
                continue;
            }
            
            answer += (a - start) / v;
            if ((a-start)%v != 0) answer++;
            start = b + 1;
        }
        
        int end = stations[stations.length - 1] + w;
        if (end < n) {
             answer += (n - end) / v;
            if ((n - end)%v != 0) answer++;
        }
        return answer;
    }
}