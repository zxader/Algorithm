import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int no;
		Node next;
		
		public Node(int no, Node next) {
			this.no = no;
			this.next = next;
		}
	}
	
	static Node[] node;
	static int N;
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	node= new Node[N + 1];
    	
    	for (int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int from = Integer.parseInt(st.nextToken());
    		int to = Integer.parseInt(st.nextToken());
    		node[from] = new Node(to, node[from]);
    		node[to] = new Node(from, node[to]);
    	}
    	
    	int v = Integer.MAX_VALUE;
    	int n = -1;
    	
    	for (int i = 1; i <= N; i++) {
    		int sum = sum(i);
    		if (v > sum) {
    			n = i;
    			v = sum;
    		}
    	}
    	
    	System.out.println(n);
	}
	
	static int sum(int no) {
		int sum = 0;

		for (int i = 1; i <= N; i++) {
			if (no == i) continue;
			sum += getKevin(no, i);
		}
		
		return sum;
	}
	
	static int getKevin(int from, int to) {
		int cnt = 0;
		
		Queue<Node> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		q.offer(new Node(from ,null));
		visited[from] = true;
		
		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			while (--size >= 0) {
				Node p = q.poll();
				if (p.no == to) return cnt;
				
				for (Node temp = node[p.no]; temp != null; temp = temp.next) {
					if (!visited[temp.no]) {
						visited[temp.no] = true;
						q.offer(new Node(temp.no, null));
					}
				}
			}
		}
		
		return cnt;
	}
}
