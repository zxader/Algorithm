import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[100001];
        
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        dp[0] = 1;
        
        for (int j = 0; j < N; j++) {
        	for (int i = 1; i <= K; i++) {
        		if (arr[j] <= i) {
        			dp[i] += dp[i - arr[j]];
        		}
        	}
        }
        
       System.out.println(dp[K]);
	}
}