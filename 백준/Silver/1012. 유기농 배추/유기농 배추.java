import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	
    	StringBuilder sb = new StringBuilder();
    	for (int t = 1; t <= T; t++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int M = Integer.parseInt(st.nextToken());
    		int N = Integer.parseInt(st.nextToken());
    		int K = Integer.parseInt(st.nextToken());
    		
    		int[][] map = new int[M][N];
    		for (int i = 0; i < K; i++) {
    			st = new StringTokenizer(br.readLine());
    			int r = Integer.parseInt(st.nextToken());
    			int c = Integer.parseInt(st.nextToken());
    			map[r][c] = 1;
    		}
    		
    		Queue<int[]> q = new ArrayDeque<>();
    		boolean[][] visited = new boolean[M][N];
    		int result = 0;
    		int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    		for (int i = 0; i < M; i++) {
    			for (int j = 0; j < N; j++) {
    				if (!visited[i][j] && map[i][j] == 1) {
    					result++;
    					visited[i][j] = true;
    					q.offer(new int[] {i, j});
    					
    					while (!q.isEmpty()) {
    						int[] p = q.poll();
    						
    						for (int d = 0; d < 4; d++) {
    							int dr = p[0] + deltas[d][0];
    							int dc = p[1] + deltas[d][1];
    							
    							if (0 <= dr && dr < M && 0 <= dc && dc < N && 
    									!visited[dr][dc] && map[dr][dc] == 1) {
    								visited[dr][dc] = true;
    								q.offer(new int[] {dr, dc});
    							}
    						}
    					}
     				}
    			}
    		}
    		sb.append(result).append("\n");
    	}
    	
    	System.out.println(sb);
    }
}