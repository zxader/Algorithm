import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map, dp;
	static int INF = 1_000_000_000;
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	map = new int[N][N];
    	dp = new int[N][1 << N];
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < N; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	System.out.println(tps(0, 1));
	}
	
	static int tps(int no, int visited) {
		if (visited == (1 << N) - 1) {
			if (map[no][0] == 0) return INF;
			return map[no][0];
		}
		
		if (dp[no][visited] != 0) return dp[no][visited];
		
		int min = INF;
		for (int i = 1; i < N; i++) {
			if ((visited & (1 << i)) == 0 && map[no][i] != 0) {
				int cost = map[no][i] + tps(i, visited | 1 << i);
				min = Math.min(min, cost);
			}
		}
		
		return dp[no][visited] = min;
	}
}	
