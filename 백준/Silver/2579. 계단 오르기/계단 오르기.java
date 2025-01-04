import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static int[] dp;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        System.out.println(maxValue(N - 1));
    }
    
    static int maxValue(int idx) {
    	if (idx < 0) return 0;
    	if (dp[idx] != 0) return dp[idx];
    	
    	if (idx == 0) return dp[idx] = arr[0];
    	if (idx == 1) return dp[idx] = arr[0] + arr[1];
    	if (idx == 2) return dp[idx] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
    	
    	dp[idx] = Math.max(
    			maxValue(idx - 2) + arr[idx],
    			maxValue(idx - 3) + arr[idx - 1] + arr[idx]
    			);
    	
    	return dp[idx];
    }
}