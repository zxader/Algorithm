import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int no;
		Node next;
		int cost;
		
		public Node(int no, Node next, int cost) {
			super();
			this.no = no;
			this.next = next;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

		@Override
		public String toString() {
			return "Node [no=" + no + ", next=" + next + ", cost=" + cost + "]";
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine().trim());
		int M = Integer.parseInt(br.readLine().trim());
		Node[] node = new Node[N + 1];
		int[] min = new int[N + 1];
		boolean[] check = new boolean[N + 1];
		// 입력
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken().trim());
			int to = Integer.parseInt(st.nextToken().trim());
			int cost = Integer.parseInt(st.nextToken().trim());
			node[from] = new Node(to, node[from], cost);
		}
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int start = Integer.parseInt(st.nextToken().trim());
		int end = Integer.parseInt(st.nextToken().trim());
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		Arrays.fill(min, Integer.MAX_VALUE);
		min[start] = 0;
		q.offer(new Node(start, null, 0));
		
		while(!q.isEmpty()) {
			Node no = q.poll();
			
			if (check[no.no]) {
				continue;
			}
			check[no.no] = true; 
			if (no.no == end) {
				break;
			}
			
			for (Node temp = node[no.no]; temp != null; temp = temp.next) {
				if (!check[temp.no] && min[no.no] + temp.cost < min[temp.no]) {
					min[temp.no] = min[no.no] + temp.cost;
					q.offer(new Node(temp.no, null, min[temp.no]));
				}
			}
		}
		sb.append(min[end]);
		System.out.println(sb);
	}
}