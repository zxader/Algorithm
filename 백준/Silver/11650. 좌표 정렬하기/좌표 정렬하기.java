import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	PriorityQueue<Point> q = new PriorityQueue<>((a, b) -> {
    		if (a.x == b.x) {
    			return Integer.compare(a.y, b.y);
    		}
    		return Integer.compare(a.x, b.x);
    	});
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		q.offer(new Point(x , y));
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	while (!q.isEmpty()) {
    		Point p = q.poll();
    		sb.append(p.x + " " + p.y).append("\n");
    	}
    	
    	System.out.println(sb);
    }
}