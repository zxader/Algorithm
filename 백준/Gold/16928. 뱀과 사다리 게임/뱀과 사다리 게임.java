import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int n, v;
		
		public Point(int n, int v) {
			this.n = n;
			this.v = v;
		}
	}
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	for (int i = 0; i < N + M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int from = Integer.parseInt(st.nextToken());
    		int to = Integer.parseInt(st.nextToken());
    		map.put(from, to);
    	}
    	
    	boolean[] visited = new boolean[101];
    	Queue<Point> q = new ArrayDeque();
    	q.offer(new Point(1, 0));
    	visited[1] = true;
    	int result = Integer.MAX_VALUE;
    	
    	while (!q.isEmpty()) {
    		Point p = q.poll();
    		
    		if (p.n == 100) {
    			result = Math.min(result, p.v);
    		}
    		
    		if (map.containsKey(p.n)) {
    			p.n = map.get(p.n);
    			visited[p.n] = true;
    		}
    		
    		for (int i = 1; i <= 6; i++) {
    			int dn = p.n + i;
    			if (dn > 100) continue;
    			if (visited[dn]) continue;
    			q.offer(new Point(dn, p.v + 1));
    			visited[dn] = true;
    		}
    	}
    	
    	System.out.println(result);
	}
}
