import java.util.*;

class Solution {

    public int solution(int[][] sizes) {

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = 0;
                temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        
        int r = 0;
        int c = 0;
        for (int i = 0; i < sizes.length; i++) {
            r = Math.max(r, sizes[i][0]);
            c = Math.max(c, sizes[i][1]);
        }
        
        
        return r * c;
    }
    
}