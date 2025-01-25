import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        boolean[][] dp = new boolean[N + 1][N + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i <= N; i++) {
        	dp[i][i] = true;;
        }
        
        for (int i = 1; i < N; i++) {
        	if (arr[i] == arr[i + 1]) {
        		dp[i][i + 1] = true;;
        	}
        }
        
        for (int i = 3; i <= N; i++) {
        	for (int j = 1; j <= N - i + 1; j++) {
        		int k = j + i - 1;
        		if (arr[j] == arr[k] && dp[j + 1][k - 1]) {
        			dp[j][k] = true;
        		}
        	}
        }
        
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int S = Integer.parseInt(st.nextToken());
        	int E = Integer.parseInt(st.nextToken());
        	sb.append(dp[S][E] ? 1 : 0).append("\n");
        }
        
        System.out.println(sb);
	}
}