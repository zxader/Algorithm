import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        loop:
        for (int i = 3; i < 4998; i++) {
            for (int j = 3; j <= i; j++) {
                int tempYellow = (i - 2) * (j - 2);
                int tempBrown = i * j - tempYellow;
                
                if (tempYellow == yellow && tempBrown == brown) {
                    answer[0] = i;
                    answer[1] = j;
                    break loop;
                }
            }
        }
        return answer;
    }
}