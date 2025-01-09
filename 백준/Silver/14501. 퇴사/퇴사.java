import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] arr;
	static int[] dp;
	static int result;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][2];
        dp = new int[N + 2];
        result = 0;
        
        for (int i = 1; i <= N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	arr[i][0] = Integer.parseInt(st.nextToken());
        	arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        powerSet(1, 0);
        
        System.out.println(result);
    }
	
	static void powerSet(int cnt, int sum) {
		if (cnt > N + 1) return;
		if (dp[cnt] > sum) return;
		if (cnt == N + 1) {
			result = Math.max(result, sum);
			return;
		}
		
		dp[cnt] = Math.max(sum, dp[cnt]);
		powerSet(cnt + arr[cnt][0], sum + arr[cnt][1]);
		powerSet(cnt + 1, sum);
	}
}