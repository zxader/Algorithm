import java.util.*;
import java.io.*;

public class Solution {
	static int[][] ladder;
	static int[][] deltas = {{0, 1}, {0, -1}, {-1, 0}};
	
	static class Point {
		int y;
		int x;
		
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= 10; t++) {
        	int T = Integer.parseInt(br.readLine());
        	sb.append("#" + T + " ");
        	ladder = new int[100][100];
        	
        	int endY = 99;
        	int endX = -1;
        	
        	for (int i = 0; i < 100; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		for (int j = 0; j < 100; j++) {
        			ladder[i][j] = Integer.parseInt(st.nextToken());
        			if (ladder[i][j] == 2) {
        				endX = j;
        			}
        		}
        	}
        	
        	Queue<Point> q = new ArrayDeque<>();
        	q.add(new Point(endY, endX));
        	ladder[endY][endX] = 0;
        	int result = -1;
        	
        	while(!q.isEmpty()) {
        		Point p = q.poll();
    			
        		if (p.y == 0) {
    				result = p.x;
        			break;
    			}
    			
        		for (int d = 0; d < 3; d++) {
    				int dr = p.y + deltas[d][0];
    				int dc = p.x + deltas[d][1];
    				
    				if (isChecked(dc, dr) && ladder[dr][dc] == 1) {
    					q.add(new Point(dr, dc));
    					ladder[dr][dc] = 0;
    					break;
    				}
    			}
        	}
        	
        	sb.append(result).append("\n");
        }
        
        System.out.println(sb);
    }
    
    static boolean isChecked(int c, int r) {
    	return 0 <= c && c < 100 && 0 <= r && r < 100;
    }
}