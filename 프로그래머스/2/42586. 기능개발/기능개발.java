import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            q.offer(progresses[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        int cnt = 0;
        int preTime = (100 - q.peek()) / speeds[0];
        if ((100 - q.peek()) % speeds[0] != 0) preTime++;
        while (!q.isEmpty()) {
            int p = q.poll();
            int time = (100 - p) / speeds[idx];           
            if ((100 - p) % speeds[idx] != 0) time++;
            
            if (preTime >= time) {
                cnt++;
            }
            else {
                preTime = time;
                list.add(cnt);
                cnt = 1;
            }
            
            idx++;
        }
        
        list.add(cnt);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}