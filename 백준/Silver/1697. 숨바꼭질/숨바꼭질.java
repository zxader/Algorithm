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

    	boolean[] visited = new boolean[100001];
    	Queue<Point> q = new ArrayDeque<>();
    	q.offer(new Point(N, 0));
    	
    	int result = 0;
    	while (!q.isEmpty()) {
    		Point p = q.poll();

    		if (p.x == K) {
    			result = p.v;
    			break;
    		}
    		
    		if (visited[p.x]) continue;
    		
    		visited[p.x] = true;
    		
    		if (p.x - 1 >= 0) {
    			q.offer(new Point(p.x - 1, p.v + 1));
    		}
    		if (p.x + 1 <= 100000) {
    			q.offer(new Point(p.x + 1, p.v + 1));
    		}
    		if (p.x * 2 <= 100000) {
    			q.offer(new Point(p.x * 2, p.v + 1));
    		}
    	}
    	
    	System.out.println(result);
    }
}