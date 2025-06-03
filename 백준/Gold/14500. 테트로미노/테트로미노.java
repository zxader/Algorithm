import java.io.*;
import java.util.*;

public class Main {
	static int[][][] point = {
		{
			{0, 0}, {0, 1}, {0, 2}, {0, 3} 
		},
		{
			{0, 0}, {1, 0}, {2, 0}, {3, 0}
		},
		{
			{0, 0}, {0, 1}, {1, 0}, {1, 1} 
		},
		{
			{0, 0}, {1, 0}, {2, 0}, {2, 1} 
		},
		{
			{0, 0}, {1, 0}, {0, 1}, {0, 2}
		},
		{
			{0, 0}, {0, 1}, {1, 1}, {2, 1}
		},
		{
			{0, 0}, {0, 1}, {0, 2}, {-1, 2}
		},
		{
			{0, 0}, {0, 1}, {1, 0}, {2, 0}
		},
		{
			{0, 0}, {1, 0}, {1, 1}, {1, 2}
		},
		{
			{0, 0}, {1, 0}, {2, 0}, {2, -1}
		},
		{
			{0, 0}, {0, 1}, {0, 2}, {1, 2}
		},
		{
			{0, 0}, {1, 0}, {1, 1}, {2, 1} 
		},
		{
			{0, 0}, {1, 0}, {1, -1}, {2, -1}
		},
		{
			{0, 0}, {0, 1}, {-1, 1}, {-1, 2} 
		},
		{
			{0, 0}, {0, 1}, {1, 1}, {1, 2}
		},
		{
			{0, 0}, {0, 1}, {0, 2}, {1, 1} 
		},
		{
			{0, 0}, {0, 1}, {-1, 1}, {1, 1}
		},
		{
			{0, 0}, {0, 1}, {-1, 1}, {0, 2}
		},
		{
			{0, 0}, {1, 0}, {2, 0}, {1, 1}
		}
	};
	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new int[N][M];
    	
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < M; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int result = 0;
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < M; j++) {
    			result = Math.max(result, solve(i, j));
    		}
    	}
    	
    	System.out.println(result);
	}
	
	static int solve(int r, int c) {
		int sum = 0;
		for (int i = 0; i < point.length; i++) {
			
			int temp = 0;
			for (int j = 0; j < 4; j++) {
				int dr = r + point[i][j][0];
				int dc = c + point[i][j][1];
				
				if (!isIn(dr, dc)) break;
				temp += map[dr][dc];
			}
			
			sum = Math.max(sum, temp);
		}
		
		return sum;
	}
	
	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}
}
