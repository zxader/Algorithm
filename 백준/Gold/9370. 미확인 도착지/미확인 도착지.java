import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int no, cost;
		Node next;
		
		public Node(int no, int cost, Node next) {
			this.no = no;
			this.cost = cost;
			this.next = next;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static int n, m, t, s, g, h;
	static Node[] node;
	static Set<Integer> target;
	static int[] distance;
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int T = Integer.parseInt(br.readLine());
    	for (int o = 1; o <= T; o++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		n = Integer.parseInt(st.nextToken());
    		m = Integer.parseInt(st.nextToken());
    		t = Integer.parseInt(st.nextToken());
    		st = new StringTokenizer(br.readLine());
    		s = Integer.parseInt(st.nextToken());
    		g = Integer.parseInt(st.nextToken());
    		h = Integer.parseInt(st.nextToken());
    		
    		node = new Node[n + 1];
    		for (int i = 0; i < m; i++) {
    			st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		int d = Integer.parseInt(st.nextToken());
        		
        		if ((a == g && b == h) || (a == h && b == g)) d = d*2 - 1;
        		else d *= 2;
        		
        		node[a] = new Node(b, d, node[a]);
        		node[b] = new Node(a, d, node[b]);
    		}
    		
    		target = new TreeSet<>();
    		for (int i = 0; i < t; i++) {
    			target.add(Integer.parseInt(br.readLine()));
    		}
    		start();
    		for (int i : target) {
    			if (distance[i] % 2 == 1) {
    				sb.append(i + " ");
    			}
    		}
    		sb.append("\n");
    	}
    	System.out.println(sb);
	}
	
	static void start() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(s, 0, null));
		distance = new int[n + 1];
		Arrays.fill(distance, 10000000);
		distance[s] = 0;
		
		while (!q.isEmpty()) {
			Node p = q.poll();
			
			for (Node temp = node[p.no]; temp != null; temp = temp.next) {
				if (distance[temp.no] > temp.cost + distance[p.no]) {
					distance[temp.no] = temp.cost + distance[p.no];
					q.offer(new Node(temp.no, distance[temp.no], null));
				}
			}
		}
		
	}
}
