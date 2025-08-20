import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        list = new TreeSet<>();
        dfs(0, "");
        for (String s : list) {
            if (s.equals(word)) break;
            answer++;
        }
        return answer;
    }
    
    static char[] alpa = {'A', 'E', 'I', 'O', 'U'};
    static Set<String> list;
    static void dfs(int cnt, String result) {
        if (cnt == 5) {
            list.add(result);
            return;
        }
        dfs(cnt + 1, result);
        for (int i = 0; i < 5; i++) {
            dfs(cnt + 1, result + alpa[i]);
        }
    }
}