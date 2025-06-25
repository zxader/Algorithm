import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] visited;
	static int[][] deltas = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	visited = new boolean[101][101];
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		int d = Integer.parseInt(st.nextToken());
    		int g = Integer.parseInt(st.nextToken());
    		visited[y][x] = true;
    		int dx = x + deltas[d][1];
			int dy = y + deltas[d][0];
			visited[dy][dx] = true;
    		List<Integer> list = new ArrayList<>();
    		list.add(d);
    		draw(dx, dy, g, 0, list);
    	}
    	
    	int result = 0;
    	for (int i = 0; i <= 99; i++) {
    		for (int j = 0; j <= 99; j++) {
    			if (visited[i][j] && visited[i + 1][j] && visited[i][j + 1] && visited[i + 1][j + 1]) {
    				result++;
    			}
    		}
    	}
    	
    	System.out.println(result);
	}
	
	static void draw(int x , int y, int g, int cnt, List<Integer> list) {
		if (g == cnt) return;
		int size = list.size() - 1;
		
		for (int i = size; i >= 0; i--) {
			int d = list.get(i) + 1;
			if (d > 3) d = 0;
			x += deltas[d][1];
			y += deltas[d][0];
			visited[y][x] = true;
			list.add(d);
		}
		
		draw(x , y, g, cnt + 1, list);
	}
}
