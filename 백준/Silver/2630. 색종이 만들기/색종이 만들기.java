import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	map = new int[N][N];
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < N; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	System.out.println(dfs(N, 0, 0, 0));
    	System.out.println(dfs(N, 0, 0, 1));
	}
	
	
	static int dfs(int N, int r, int c, int color) {
		if (N == 0) return 0;
		boolean check = false;
		for (int i = r; i < r + N; i++) {
			if (check) break;
			for (int j = c; j < c + N; j++) {
				if (map[i][j] != color) {
					check = true;
					break;
				}
			}
		}
		
		if (check) {
			return dfs(N/2 , r, c, color) +
					dfs(N/2, r, c + N/2, color) +
					dfs(N/2, r + N/2, c, color) +
					dfs(N/2, r + N/2, c + N/2, color);
		}
		else {
			return 1;
		}
		
	}
}
