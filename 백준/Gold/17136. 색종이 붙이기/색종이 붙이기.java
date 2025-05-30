import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] used;
	static int[] paper = {0, 0, 0, 0, 0};
	static int result;
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	map = new int[10][10];
    	used = new boolean[10][10];

    	result = 26;
    	
    	for (int i = 0; i < 10; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < 10; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	dfs(0, 0, 0);
    	
    	System.out.println(result == 26 ? -1 : result);
	}
	
	static void dfs(int r, int c, int size) {
		
		c += size;
		if (c >= 10) {
			r += 1;
			c -= 10;
		}
		
		if (r >= 10) {
			int sum = 0;
			
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (map[i][j] == 1 && !used[i][j]) return;
				}
			}
			
			for (int i = 0; i < 5; i++) {
				sum += paper[i];
			}
			
			result = Math.min(result, sum);
			
			return;
		}
		
		if (map[r][c] == 0 || used[r][c]) {
			dfs(r, c, 1);
		}
		else {
			if (check(r, c, 1)) {
				dfs(r, c, 1);
				back(r, c, 1);
			}
			if (check(r, c, 2)) {
				dfs(r, c, 2);
				back(r, c, 2);
			}
			if (check(r, c, 3)) {
				dfs(r, c, 3);
				back(r, c, 3);
			}
			if (check(r, c, 4)) {
				dfs(r, c, 4);
				back(r, c, 4);
			}
			if (check(r, c, 5)) {
				dfs(r, c, 5);
				back(r, c, 5);
			}
		}
		
	}
	
	static boolean check(int r, int c, int size) {
		if (paper[size - 1] >= 5) return false;
		
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (!isIn(i, j)) return false;
				if (map[i][j] != 1) return false;
				if (used[i][j]) return false;
			}
		}
		
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				used[i][j] = true;
			}
		}
		
		paper[size - 1]++;
		return true;
	}
	
	static void back(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				used[i][j] = false;
			}
		}
		
		paper[size - 1]--;
	}
	
	static boolean isIn(int r, int c) {
		return 0 <= r && r < 10 && 0 <= c && c < 10;
	}
}	
