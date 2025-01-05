import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        
        System.out.println(getCase(N - 1));
    }
    
    static int getCase(int idx) {
    	if (dp[idx] != 0) return dp[idx];
    	if (idx == 0) return dp[0] = 1;
    	if (idx == 1) return dp[1] = 2;
    	
    	dp[idx] = (getCase(idx - 1) + getCase(idx - 2)) % 10007;
    	
    	return dp[idx];   	
    }
}