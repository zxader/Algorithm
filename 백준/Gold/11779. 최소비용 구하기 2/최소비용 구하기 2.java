import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
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
	
	static int N;
	static Node[] node;
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	int M = Integer.parseInt(br.readLine());
    	node = new Node[N + 1];
    	
    	for (int i = 0; i < M; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int from = Integer.parseInt(st.nextToken());
    		int to = Integer.parseInt(st.nextToken());
    		int cost = Integer.parseInt(st.nextToken());
    		node[from] = new Node(to, cost, node[from]);
    	}
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int start = Integer.parseInt(st.nextToken());
    	int end = Integer.parseInt(st.nextToken());
    	dijk(start, end);
	}
	
	static void dijk(int start, int end) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		int[] distance = new int[N + 1];
		int[] prev = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		q.offer(new Node(start, 0, null));
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		
		while (!q.isEmpty()) {
			Node p = q.poll();
		
			if (p.no == end) break;
			
			for (Node temp = node[p.no]; temp != null; temp = temp.next) {
				if (distance[temp.no] > temp.cost + distance[p.no]) {
					distance[temp.no] = temp.cost + distance[p.no];
					q.offer(new Node(temp.no, distance[temp.no], null));
					prev[temp.no] = p.no;
				}
			}
		}
		
		int idx = end;
		list.add(end);

		while (prev[idx] != 0) {
			int i = prev[idx];
			list.add(i);
			idx = i;
		}
		
		sb.append(distance[end]).append("\n");
		sb.append(list.size()).append("\n");
		
		for (int i = list.size() - 1; i >= 0; i--) {
			sb.append(list.get(i)).append(" ");
		}
		sb.append("\n");
		
		System.out.println(sb);
	}
}
