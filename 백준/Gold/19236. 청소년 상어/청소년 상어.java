import java.io.*;
import java.util.*;

public class Main {
	static class Fish {
		int r, c, d;
		
		public Fish(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	static int[][] deltas = {{0,0},{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
	static int[][] map;
	static Fish[] fish;
	static boolean[] visited;
	static int result;
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	map = new int[4][4];
    	fish = new Fish[17];
    	visited = new boolean[17];
    	result = 0;
    	
    	for (int i = 0; i < 4; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < 4; j++) {
    			int a = Integer.parseInt(st.nextToken());
    			int b = Integer.parseInt(st.nextToken());
    			
    			Fish f = new Fish(i, j, b);
    			map[i][j] = a;
    			fish[a] = f;
    		}
    	}
    	
    	visited[map[0][0]] = true;
    	int d = fish[map[0][0]].d;
    	int sum = map[0][0];
    	map[0][0] = 0;
    	
    	dfs(0, 0, d, sum);
    	
    	System.out.println(result);
	}
	
	static void dfs(int r, int c, int d, int sum) {
		if (result < sum) {
			result = sum;
		}
		
		// 1. 물고기 이동
		for (int i = 1; i <= 16; i++) {
			Fish f = fish[i];
			if (visited[i]) continue;
			
			for (int j = 0; j < 8; j++) {
				int k = (f.d + j) % 9;
				if (k == 0) k = 1;
				
				int dr = f.r + deltas[k][0];
				int dc = f.c + deltas[k][1];
				
				if (isIn(dr, dc) && (dr != r || dc != c)) {
					int no = map[dr][dc];
					if (no != 0) {
						fish[no].r = f.r;
						fish[no].c = f.c;
					}
					
					map[f.r][f.c] = no;
				
					f.r = dr;
					f.c = dc;
					f.d = k;
					map[dr][dc] = i;
					
					break;
				}
			}
		}
		
		// 2. 상어 이동
		// 1) 현재 물고기 위치 및 방향 저장
		Fish[] temp = new Fish[17];
		for (int i = 1; i <= 16; i++) {
			Fish f = fish[i];
			temp[i] = new Fish(f.r, f.c, f.d);
		}
		
		int[][] tempMap = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
		
		// 2) 상어가 갈 수 있는 곳 이동
		int dr = r;
		int dc = c;
		for (int i = 0; i < 3; i++) {
			dr += deltas[d][0];
			dc += deltas[d][1];
			
			if (!isIn(dr, dc)) break;;
			if (map[dr][dc] == 0) continue;
			if (visited[map[dr][dc]]) continue;
			
			int tempFish = map[dr][dc];
			map[dr][dc] = 0;
			visited[tempFish] = true;
			
			dfs(dr, dc, fish[tempFish].d , sum + tempFish);
			
			visited[tempFish] = false;
			
			// 3) 현재 물고기 위치 및 방향 복구
			for (int j = 1; j <= 16; j++) {
				fish[j] = new Fish(temp[j].r, temp[j].c, temp[j].d);
			}
			
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					map[j][k] = tempMap[j][k];
				}
			}
		}
	}
	
	static boolean isIn(int r, int c) {
		return 0 <= r && r < 4 && 0 <= c && c < 4;
	}
}