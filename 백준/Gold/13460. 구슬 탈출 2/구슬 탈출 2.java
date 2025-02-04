import java.util.*;
import java.io.*;

public class Main {
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static class State {
		Point red;
		Point blue;
		int v;
		
		public State(Point red, Point blue, int v) {
			this.red = red;
			this.blue = blue;
			this.v = v;
		}
	}
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        Point red = null;
        Point blue = null;
        
        for (int i = 0; i < N; i++) {
        	String input = br.readLine();
        	for (int j = 0; j < M; j++) {
        		arr[i][j] = input.charAt(j);
        		
        		if(arr[i][j] == 'R') {
        			red = new Point(i, j);
        		}
        		else if(arr[i][j] == 'B') {
        			blue = new Point(i, j);
        		}
        	}
        }
        
        boolean[][][][] visited = new boolean[N][M][N][M];
        int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int result = -1;
        
        Queue<State> q = new ArrayDeque<>();
        visited[red.r][red.c][blue.r][blue.c] = true;
        q.offer(new State(red, blue, 0));
        
        while (!q.isEmpty()) {
        	State p = q.poll();
        	if (result != - 1) break;
        	if (p.v >= 10) break;
        	
        	for (int d = 0; d < 4; d++) {
        		boolean redCheck = false;
        		boolean blueCheck = false;
        		
        		int blueY = p.blue.r;
        		int blueX = p.blue.c;
        		int blueCount = 0;
        		
        		while (true) {
        			blueY += deltas[d][0];
        			blueX += deltas[d][1];
        			blueCount++;
        			
        			if (arr[blueY][blueX] == 'O') {
        				blueCheck = true;
        				break;
        			}
        			if (arr[blueY][blueX] == '#') {
        				blueY -= deltas[d][0];
            			blueX -= deltas[d][1];
        				break;
        			}
        		}
        		
        		if (blueCheck) continue;
        		
        		int redY = p.red.r;
        		int redX = p.red.c;
        		int redCount = 0;
        		
        		while(true) {
        			redY += deltas[d][0];
        			redX += deltas[d][1];
        			redCount++;
        			
        			if (arr[redY][redX] == 'O') {
        				redCheck = true;
        				break;
        			}
        			if (arr[redY][redX] == '#') {
        				redY -= deltas[d][0];
            			redX -= deltas[d][1];
        				break;
        			}
        		}
        		
        		if (redCheck) {
        			result = p.v + 1;
        			break;
        		}
        		
        		if (redY == blueY && redX == blueX) {
        			if (redCount > blueCount) {
        				redY -= deltas[d][0]; 
        				redX -= deltas[d][1];
        			}
        			else {
        				blueY -= deltas[d][0];
        				blueX -= deltas[d][1];
        			}
        		}
        		
        		if (visited[redY][redX][blueY][blueX]) continue;
        		visited[redY][redX][blueY][blueX] = true;
        		q.offer(new State(new Point(redY, redX), new Point(blueY,blueX), p.v + 1));
        	}
        }
        
        System.out.println(result);
	}
}