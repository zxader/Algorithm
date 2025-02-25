import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int x;
		int v;
		
		public Point(int x, int v) {
			this.x = x;
			this.v = v;
		}
	}
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	Queue<Point> q = new ArrayDeque<>();
    	boolean[] visited = new boolean[100001];
    	visited[N] = true;
    	q.offer(new Point(N, 0));
    	int result = 0;
    	
    	while (!q.isEmpty()) {
    		Point p = q.poll();
    		
    		if (p.x == K) {
    			result = p.v;
    			break;
    		}
    		
    		int[] deltas = {2*p.x, p.x - 1, p.x + 1};
    		
    		for (int d = 0; d < 3; d++) {
    			int dx = deltas[d];
    			
    			if (0 <= dx && dx <= 100000 && !visited[dx]) {
    				visited[dx] = true;
    				if (d == 0) {
    					q.offer(new Point(dx, p.v));
    				}
    				else {
    					q.offer(new Point(dx, p.v + 1));
    				}
    			}
    		}
    	}
    	
    	System.out.println(result);
    }
}