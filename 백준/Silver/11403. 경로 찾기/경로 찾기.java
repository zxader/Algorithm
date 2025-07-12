import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] result;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	arr = new int[N][N];
    	result = new int[N][N];
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < N; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	for (int i = 0; i < N; i++) {
    		bfs(i);
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			sb.append(result[i][j] + " ");
    		}
    		sb.append("\n");
    	}
    	
    	System.out.println(sb);
	}
	
	static void bfs(int start) {
		boolean[] visited = new boolean[N];
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		
		while (!q.isEmpty()) {
			int n = q.poll();
			
			for (int i = 0; i < N; i++) {
				if (visited[i]) continue;
				if (arr[n][i] == 0) continue;
				visited[i] = true;
				result[start][i] = 1;
				q.offer(i);
			}
		}
	}
}
