import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int no, cost;
		Node next;
		
		public Node(int no, Node next, int cost) {
			this.no = no;
			this.next = next;
			this.cost = cost;
		}
	}
	static Node[] node;
	static int start;
	static int n;
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	node = new Node[n + 1];
    	
    	for (int i = 0; i < n - 1; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int no = Integer.parseInt(st.nextToken());
    		int next = Integer.parseInt(st.nextToken());
    		int cost = Integer.parseInt(st.nextToken());
    		
    		node[no] = new Node(next, node[no], cost);
    		node[next] = new Node(no, node[next], cost);
    	}
    	
    	solve(1);
    	System.out.println(solve(start));
	}
	
	static int solve(int s) {
		int max = 0;
		
		Queue<Node> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n + 1];
		q.offer(new Node(s, null, 0));
		visited[s] = true;
		
		while (!q.isEmpty()) {
			Node p = q.poll();
			
			if (max < p.cost) {
				max = p.cost;
				start = p.no;
			}
			
			for (Node temp = node[p.no]; temp != null; temp = temp.next) {
				if (visited[temp.no]) continue;
				visited[temp.no] = true;
				q.offer(new Node(temp.no, null, p.cost + temp.cost));
			}
		}
		
		return max;
	}
}
