import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int h;
		int r;
		int c;
		
		public Point(int h, int r, int c) {
			this.h = h;
			this.r = r;
			this.c = c;
		}
	}
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int M = Integer.parseInt(st.nextToken());
    	int N = Integer.parseInt(st.nextToken());
    	int H = Integer.parseInt(st.nextToken());
    	int[][][] map = new int[H][N][M];
    	int count = 0;
    	Queue<Point> q = new ArrayDeque<>();
    	
    	for (int i = 0; i < H; i++) {
    		for (int j = 0; j < N; j++) {
    			st = new StringTokenizer(br.readLine());
    			for (int k = 0; k < M; k++) {
    				map[i][j][k] = Integer.parseInt(st.nextToken());
    				if (map[i][j][k] == 1) {
    					q.offer(new Point(i, j, k));
    				}
    				if (map[i][j][k] == 0) {
    					count++;
    				}
    			}
    		}
    	}
    	
    	int time = 0;
    	int[][] deltas = {{0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}};
    	while (!q.isEmpty() && count != 0) {
    		int size = q.size();
    		
    		while (--size >= 0) {
    			Point p = q.poll();
    			
    			for (int d = 0; d < 6; d++) {
    				int dh = p.h + deltas[d][0];
    				int dr = p.r + deltas[d][1];
    				int dc = p.c + deltas[d][2];
    				
    				if (0 <= dh && dh < H && 0 <= dr && dr < N && 0 <= dc && dc < M 
    						&& map[dh][dr][dc] == 0) {
    					count--;
    					map[dh][dr][dc] = 1;
    					q.offer(new Point(dh, dr, dc));
    				}
    			}
    		}
    		time++;
    	}
    	
    	if (count == 0 && time == 0) {
    		System.out.println(0);
    	}
    	else if (count == 0){
    		System.out.println(time);
    	}
    	else {
    		System.out.println(-1);
    	}
    }
}