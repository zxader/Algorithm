import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int r = Integer.parseInt(st.nextToken());
    	int c = Integer.parseInt(st.nextToken());
    	
    	System.out.println(dfs(N, r, c, 0, 0, 0));
	}
	
	static int[][] deltas = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
	static int dfs(int N, int r, int c, int startR, int startC, int startValue) {
		if (N == 1) {
			for (int d = 0; d < 4; d++) {
				int dr = startR + deltas[d][0];
				int dc = startC + deltas[d][1];
				if (dr == r && dc == c) break;
				startValue++;
			}
			return startValue;
		}
		
		int v = (int)Math.pow(2, N - 1);
		int vR = startR + v;
		int vC = startC + v;
		if (r < vR && c < vC) {
			return dfs(N - 1, r, c, startR, startC, startValue);
		}
		else if (r < vR && c >= vC) {
			return dfs(N - 1, r, c, startR, startC + v, startValue + v * v);
		}
		else if (r >= vR && c < vC) {
			return dfs(N - 1, r, c, startR + v, startC, startValue + 2 * v * v);
		}
		else {
			return dfs(N - 1, r, c, startR + v, startC + v, startValue + 3 * v * v);
		}
		
	}
}
