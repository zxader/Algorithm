import java.util.*;

class Solution {
    static int N;
    static int[][] network;
    static boolean[] check;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        network = new int[N][N];
        check = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                network[i][j] = computers[i][j];
            }
        }
        
        for (int i = 0; i < N; i++) {
            if(!check[i]) {
                checkNetwork(i);
                answer++;                
            }
    
        }
        
        return answer;
    }
    
    static void checkNetwork(int n) {
        check[n] = true;
        for (int i = 0; i < N; i++) {
            if (check[i]) continue;
            
            if (network[n][i] == 1) {
                checkNetwork(i);
            }
        }
    }
}