import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int M = Integer.parseInt(br.readLine());
    	
    	int[][] map = new int[N + 1][N + 1];
    	for (int i = 1; i <= N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for (int j = 1; j <= N; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int[] plan = new int[M];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < M; i++) {
    		plan[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Queue<Integer> q = new ArrayDeque<>();
    	boolean[] visited = new boolean[N + 1];
    	q.offer(plan[0]);
    	visited[plan[0]] = true;
    	
    	while (!q.isEmpty()) {
    		int p = q.poll();
    		
    		for (int i = 1; i <= N; i++) {
    			if (i == p) continue;
    			if (visited[i]) continue;
    			if (map[p][i] == 0) continue;
    			visited[i] = true;
    			q.offer(i);
    		}
    	}
    	
    	String result = "YES";
    	for (int i = 0; i < M; i++) {
    		if (!visited[plan[i]]) {
    			result = "NO";
    			break;
    		}
    	}
    	
    	System.out.println(result);
	}
}