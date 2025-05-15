import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] arr = new int[501];
    	int[] dp = new int[501];
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int A = Integer.parseInt(st.nextToken());
    		int B = Integer.parseInt(st.nextToken());
    		arr[A] = B;
    		dp[A] = 1;
    	}
    	
    	
    	for (int i = 1; i < 501; i++) {
    		for (int j = 1; j < i; j++) {
    			if (arr[i] > arr[j]) {
    				dp[i] = Math.max(dp[i], dp[j] + 1);
    			}
    		}
    	}
    	
    	int result = 0;
    	for (int i = 1; i < 501; i++) {
    		result = Math.max(dp[i], result);
    	}
    	
    	System.out.println(N - result);
	}
}	
