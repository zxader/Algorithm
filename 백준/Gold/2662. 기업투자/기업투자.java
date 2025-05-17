import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int[][] arr = new int[N + 1][M + 1];
    	
    	for (int i = 1; i <= N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j <= M; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int[][] dp = new int[N + 1][M + 1];
    	int[][] cost = new int[N + 1][M + 1];
    	
    	for (int i = 1; i <= M; i++) {
    		for (int j = 1; j <= N; j++) {
    			dp[j][i] = dp[j][i - 1];
    			for (int k = 1; k <= j; k++) {
    				if (dp[j][i] < dp[j - k][i - 1] + arr[k][i]) {
    					dp[j][i] = dp[j - k][i - 1] + arr[k][i];
    					cost[j][i] = k;
    				}
    			}
    		}
    	}
    	
    	List<Integer> list = new ArrayList<>();
    	
    	int idx = N;
    	for (int i = M; i > 0; i--) {
    		list.add(cost[idx][i]);
    		if (cost[idx][i] != 0) {
    			idx -= cost[idx][i];
    		}
    	}
    	
    	Collections.reverse(list);
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append(dp[N][M]).append("\n");
    	for (int i : list) {
    		sb.append(i).append(" ");
    	}
    	
    	System.out.println(sb);
	}
}	
