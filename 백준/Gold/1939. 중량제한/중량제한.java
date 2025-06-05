import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int no, weight;
		Node next;
		
		public Node(int no, int weight, Node next) {
			this.no = no;
			this.weight = weight;
			this.next = next;
		}
		
		@Override
		public int compareTo(Node o) {
			return o.weight - this.weight;
		}
	}
	
	static int N, M;
	static Node[] node;
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	node = new Node[N + 1];
    	
    	for (int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int A = Integer.parseInt(st.nextToken());
    		int B = Integer.parseInt(st.nextToken());
    		int C = Integer.parseInt(st.nextToken());
    		
    		node[A] = new Node(B, C, node[A]);
    		node[B] = new Node(A, C, node[B]);
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	int start = Integer.parseInt(st.nextToken());
    	int end = Integer.parseInt(st.nextToken());
    	int[] dp = new int[N + 1];
    	
    	PriorityQueue<Node> q = new PriorityQueue<>();
    	q.add(new Node(start, Integer.MAX_VALUE, null));
    	dp[start] = Integer.MAX_VALUE;
    	
    	while (!q.isEmpty()) {
    		Node p = q.poll();
    		
    		if (p.no == end) break;
    		
    		for (Node temp = node[p.no]; temp != null; temp = temp.next) {
    			int min = Math.min(temp.weight, p.weight);
    			if (dp[temp.no] < min) {
    				dp[temp.no] = min;
    				q.add(new Node(temp.no, min, null));
    			}
    		}
    	}
    	
    	System.out.println(dp[end]);
	}
	
}
