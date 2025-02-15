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
    		
    		int[] deltas = {p.x - 1, p.x + 1, p.x * 2};
    		
    		for (int d: deltas) {
    			if (d >= 0 && d <= 100000 && !visited[d]) {
    				q.offer(new Point(d, p.v + 1));
    				visited[d] = true;
    			}
    		}
    	}
    	
    	System.out.println(result);
    }
}