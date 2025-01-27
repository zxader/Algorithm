import java.util.*;
import java.io.*;

public class Main {
    
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] group = new int[N][M];
        int[] groupId = new int[N * M + 1];
        
        for (int i = 0; i < N; i++) {
        	String input = br.readLine();
        	for (int j = 0; j < M; j++) {
        		map[i][j] = input.charAt(j) - '0';
        	}
        }
        
        int id = 1;
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < M; j++) {
        		if (!visited[i][j] && map[i][j] == 0) {
        			Queue<int[]> q = new ArrayDeque<>();
        			visited[i][j] = true;
        			q.offer(new int[] {i, j});
        			int result = 0;
        			
        			while (!q.isEmpty()) {
        				int[] p = q.poll();
        				result++;
        				group[p[0]][p[1]] = id;
        				
        				for (int d = 0; d < 4; d++) {
        					int dr = p[0] + deltas[d][0];
        					int dc = p[1] + deltas[d][1];
        					
        					if (0 <= dr && dr < N && 0 <= dc && dc < M && !visited[dr][dc] && map[dr][dc] == 0) {
        						visited[dr][dc] = true;
        						
        						q.offer(new int[] {dr, dc});
        					}
        				}
        			}
        			
        			groupId[id] = result;
        			id++;
        		}
        	}
        }
        
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < M; j++) {
        		if (map[i][j] == 1) {
        			Set<Integer> set = new HashSet<>();
    				for (int d = 0; d < 4; d++) {
    					int dr = i + deltas[d][0];
    					int dc = j + deltas[d][1];
    					
    					if (0 <= dr && dr < N && 0 <= dc && dc < M && map[dr][dc] == 0) {
    						set.add(group[dr][dc]);
    					}
        			}
    				
    				for (int k : set) {
    					map[i][j] += groupId[k];
    				}
        		}
        	}
        }
	
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < M; j++) {
    			sb.append(map[i][j] % 10);
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb);
	}
}