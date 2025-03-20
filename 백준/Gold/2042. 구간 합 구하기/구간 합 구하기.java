import java.io.*;
import java.util.*;

public class Main {
	static Map<Integer, Long> map;
	static long[] arr;
    static long[] dp;
    
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	arr = new long[N + 1];
    	for (int i = 1; i <= N; i++) {
    		arr[i] = Long.parseLong(br.readLine());
    	}
    	
    	dp = new long[N + 1];
    	dp[1] = arr[1];
    	for (int i = 2; i <= N; i++) {
    		dp[i] = dp[i - 1] + arr[i];
    	}
    	
    	map = new HashMap<>();
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < M + K; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		long c = Long.parseLong(st.nextToken());
    		
    		switch(a) {
    		case 1:
    			change(b, c);
    			break;
    		case 2:
    			sb.append(getValue(b, (int)c)).append("\n");
    			break;
    		}
    		
    	}
    	
    	System.out.println(sb);
    }
    
    static void change(int idx, long v) {
		map.put(idx, v - arr[idx]);
    }
    
    static long getValue(int b, int c) {
    	long sum = dp[c] - dp[b - 1];
    	
    	for (Map.Entry<Integer, Long> entry : map.entrySet()) {
    		int key = entry.getKey();
    		if (b <= key && key <= c) {
    			sum += entry.getValue();
    		}
    	}
    	
    	return sum;
    }
}
