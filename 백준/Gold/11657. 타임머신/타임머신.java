import java.io.*;
import java.util.*;

public class Main {
	static class Edge {
		int from, to, cost;
		
		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	Edge[] edges = new Edge[M];
    	
    	for (int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int from = Integer.parseInt(st.nextToken());
    		int to = Integer.parseInt(st.nextToken());
    		int cost = Integer.parseInt(st.nextToken());
    		
    		edges[i] = new Edge(from, to, cost);
    	}
    	
    	long[] arr = new long[N + 1];
    	Arrays.fill(arr, 10000000000L);
    	arr[1] = 0;
    	
    	for (int i = 0; i < N - 1; i++) {
    		for (int j = 0; j < M; j++) {
    			Edge e = edges[j];
    			if (arr[e.from] == 10000000000L) continue;
    			if (arr[e.from] + e.cost < arr[e.to]) {
    				arr[e.to] = arr[e.from] + e.cost;
    			}
    		}
    	}
    	
    	for (int j = 0; j < M; j++) {
    		Edge e = edges[j];
    		if (arr[e.from] == 10000000000L) continue;
			if (arr[e.from] + e.cost < arr[e.to]) {
				System.out.println(-1);
				return;
			}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 2; i <= N; i++) {
    		sb.append(arr[i] == 10000000000L ? -1 : arr[i]).append("\n");
    	}
    	
    	System.out.println(sb);
	}
}