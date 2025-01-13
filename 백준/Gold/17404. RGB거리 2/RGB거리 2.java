import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] colors = new int[N + 1][3];
        int[][] dp = new int[N + 1][3];
        
        for (int i = 1; i <= N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < 3; j++) {
        		colors[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int result = Integer.MAX_VALUE;
        
        for (int firstColor = 0; firstColor < 3; firstColor++) {
        	
        	for (int i = 0; i < 3; i++) {
        		dp[1][i] = (i == firstColor) ? colors[1][i] : 1001;
        	}
        	
        	for (int i = 2; i <= N; i++) {
        		dp[i][0] = colors[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
        		dp[i][1] = colors[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
        		dp[i][2] = colors[i][2] + Math.min(dp[i - 1][1], dp[i - 1][0]);
        	}
        	
        	for (int lastColor = 0; lastColor < 3; lastColor++) {
        		if (lastColor != firstColor) {
        			result = Math.min(result, dp[N][lastColor]);
        		}
        	}
        }
        
        System.out.println(result);
    }
}