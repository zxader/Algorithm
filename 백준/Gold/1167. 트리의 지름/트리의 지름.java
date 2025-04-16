import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int no, v;
		Node next;
		
		public Node(int no, int v, Node next) {
			this.no = no;
			this.v = v;
			this.next = next;
		}
	}
	
	static Node[] node;
	static boolean[] visited;
	static int max;
	static int idx;
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int V = Integer.parseInt(br.readLine());
    	node = new Node[V + 1];
    	visited = new boolean[V + 1];
    	max = 0;
    	idx = 0;
    	
    	for (int i = 0; i < V; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int from = Integer.parseInt(st.nextToken());

    		while (true) {
    			int to = Integer.parseInt(st.nextToken());
    			if (to == -1) break;
    			int v = Integer.parseInt(st.nextToken());
    			node[from] = new Node(to, v, node[from]);
    		}
    	}
    	
    	dfs(1, 0);
    	max = 0;
    	visited = new boolean[V + 1];
    	dfs(idx, 0);
    	
    	System.out.println(max);
	}
	
	static void dfs(int no, int sum) {
		visited[no] = true;
		
		if (sum > max) {
			max = sum;
			idx = no;
		}
		
		for (Node temp = node[no]; temp != null; temp = temp.next) {
			if (visited[temp.no]) continue;
			dfs(temp.no, sum + temp.v);
		}
	}
}
