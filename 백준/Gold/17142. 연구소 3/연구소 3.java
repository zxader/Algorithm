import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static List<int[]> list;
	static boolean[] selected;
	static int result;
	static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new int[N][N];
    	list = new ArrayList<>();
    	result = Integer.MAX_VALUE;
    	
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < N; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			if (map[i][j] == 2) list.add(new int[] {i, j});
    		}
    	}
    	
    	selected = new boolean[list.size()];
    	comb(0, 0);
    	
    	System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	static void comb(int start, int n) {
		if (n == M) {
			result = Math.min(check(), result);
			return;
		}
		
		for (int i = start; i < list.size(); i++) {
			selected[i] = true;
			comb(i + 1, n + 1);
			selected[i] = false;
		}
	}
	
	static int check() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		
		for (int i = 0; i < list.size(); i++) {
			if (selected[i]) {
				int[] point = list.get(i);
				q.offer(point);
				visited[point[0]][point[1]] = true;
			}
		}
		
		int time = 0;
		int[][] temp = new int[N][N];
		
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size > 0) {
				int[] p = q.poll();
				temp[p[0]][p[1]] = time;
				for (int d = 0; d < 4; d++) {
					int dr = p[0] + deltas[d][0];
					int dc = p[1] + deltas[d][1];
					
					if (!isIn(dr, dc)) continue;
					if (map[dr][dc] == 1 || visited[dr][dc]) continue;
					q.offer(new int[] {dr, dc});
					visited[dr][dc] = true;
				}
				
				size--;
			}
			time++;
		}
		
		time = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) continue;
				if (!visited[i][j] && map[i][j] != 1) return Integer.MAX_VALUE;
				time = Math.max(time, temp[i][j]);
			}
		}
		
		return time;
	}
	
	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
}
