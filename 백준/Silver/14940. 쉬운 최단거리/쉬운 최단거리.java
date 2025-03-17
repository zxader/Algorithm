import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int[][] result;
	static Queue<int[]> q;
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new int[N][M];
    	result = new int[N][M];
    	q = new ArrayDeque<>();
    	
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < M; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			result[i][j] = Integer.MAX_VALUE;
    			
    			if (map[i][j] == 0) {
    				result[i][j] = 0;
    			}
    			
    			if (map[i][j] == 2) {
    				q.offer(new int[] {i, j});
    				result[i][j] = 0;
    			}
    		}
    	}
    	
    	bfs();
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < M; j++) {
    			sb.append(result[i][j] == Integer.MAX_VALUE ? -1 : result[i][j]).append(" ");
    		}
    		sb.append("\n");
    	}
    	
    	System.out.println(sb);
    }
    
    static void bfs() {
    	int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    	while (!q.isEmpty()) {
    		int[] p = q.poll();
    		
    		for (int d = 0; d < 4; d++) {
    			int dr = p[0] + deltas[d][0];
    			int dc = p[1] + deltas[d][1];
    			
    			if (isIn(dr, dc) && map[dr][dc] == 1 && result[dr][dc] > result[p[0]][p[1]] + 1) {
    				q.offer(new int[] {dr, dc});
    				result[dr][dc] = result[p[0]][p[1]] + 1;
    			}
    		}
    		
    	}
    }
    
    
    static boolean isIn(int r, int c) {
    	return 0 <= r && r < N && 0 <= c && c < M;
    }
}
