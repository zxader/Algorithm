import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	int time = Integer.MAX_VALUE;
    	int count = 0;
    	
    	Queue<int[]> q = new ArrayDeque<>();
    	q.offer(new int[]{N, 0});
    	int[] deltas = {-1, 1, 2};
    	int[] visited = new int[100001];
    	Arrays.fill(visited, Integer.MAX_VALUE);
    	visited[N] = 0;
    	
    	while (!q.isEmpty()) {
    		int[] p = q.poll();
    		
    		if (p[1] > time) continue;
			if (p[0] == K && p[1] <= time) {
				time = p[1];
				count++;
    			continue;
    		}
			
    		for (int d = 0; d < 3; d++) {
    			int dx = p[0];
    			if (d == 2) {
    				dx *= deltas[d];
    			}
    			else {
    				dx += deltas[d];
    			}
    			
    			if (0 > dx || dx > 100000) continue;
    			if (visited[dx] < p[1] + 1) continue;
    			q.offer(new int[] {dx, p[1] + 1});
    			visited[dx] = p[1] + 1;
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append(time).append("\n");
    	sb.append(count);
    	
    	System.out.println(sb);
	}	
	
}