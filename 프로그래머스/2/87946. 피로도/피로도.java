import java.util.*;

class Solution {
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        dfs(0, k, dungeons, new boolean[dungeons.length], new int[dungeons.length]);
        return answer;
    }
    
    static void dfs(int cnt, int k, int[][] dungeons, boolean[] visited, int[] result) {
        if (cnt == dungeons.length) {
            
            int sum = 0;
            for (int i = 0; i < cnt; i++) {
                if (dungeons[result[i]][0] <= k) {
                    sum++;
                    k -= dungeons[result[i]][1];
                }
            }
            
            answer = Math.max(answer, sum);
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            result[cnt] = i;
            dfs(cnt + 1, k, dungeons, visited, result);
            visited[i] = false;
        }
        
    }    
}