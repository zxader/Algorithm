import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	char[][] map = new char[N][M];
    	
    	Queue<int[]> q = new ArrayDeque<>();
    	boolean[][] visited = new boolean[N][M];
    	
    	for (int i = 0; i < N; i++) {
    		String input = br.readLine();
    		for (int j = 0; j < M; j++) {
    			map[i][j] = input.charAt(j);
    			if (map[i][j] == 'I') {
    				q.offer(new int[] {i, j});
    				visited[i][j] = true;
    			}
    		}
    	}
    	
    	int result = 0;
    	int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    	while (!q.isEmpty()) {
    		int[] p = q.poll();
    		
    		for (int d = 0; d < 4; d++) {
    			int dr = p[0] + deltas[d][0];
    			int dc = p[1] + deltas[d][1];
    			
    			if (dr < 0 || dr >= N || dc < 0 || dc >= M) continue;
    			if (map[dr][dc] == 'X' || visited[dr][dc]) continue;
    			visited[dr][dc] = true;
    			if (map[dr][dc] == 'P') result++;
    			q.offer(new int[] {dr, dc});
    		}
    	}
    	
    	System.out.println(result == 0 ? "TT" : result);
	}
	
}
