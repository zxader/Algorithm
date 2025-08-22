import java.util.*;

class Solution {
    static Map<Integer, Integer> deletedNum;
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> qMax = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> qMin = new PriorityQueue<>();
        deletedNum = new HashMap<>();
        
        for (int i = 0; i < operations.length; i++) {
            String[] input = operations[i].split(" ");
            int num = Integer.parseInt(input[1]);
            
            if (input[0].equals("I")) {
                qMax.add(num);
                qMin.add(num);
                deletedNum.put(num, deletedNum.getOrDefault(num, 0) + 1);
            }
            else {
                if (num > 0) {
                    delete(qMax);
                }
                else {
                    delete(qMin);
                }
                
            }
        }
       
        if (qMax.isEmpty()) return new int[] {0, 0};
        int max = qMax.poll();
        if (qMin.isEmpty()) return new int[] {0, 0};
        int min = qMin.poll();
        int[] answer = new int[2];
        
        while(!deletedNum.containsKey(max)) {
            if (qMax.isEmpty()) return new int[] {0, 0};
            max = qMax.poll();
        }
        
        while(!deletedNum.containsKey(min)) {
            if (qMin.isEmpty()) return new int[] {0, 0};
            min = qMin.poll();
        }
                
        answer[0] = max;
        answer[1] = min;
        return answer;
    }
    
    static void delete(PriorityQueue<Integer> q) {
        if (q.isEmpty()) return;
        int num = q.poll();

        while(!deletedNum.containsKey(num)) {
            if (q.isEmpty()) return;
            num = q.poll();
        }

        deletedNum.put(num, deletedNum.get(num) - 1);                    
        if (deletedNum.get(num) == 0) deletedNum.remove(num);
    }
}