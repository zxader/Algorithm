import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int no, cost;
		Node next;
		public Node(int no, int cost, Node next) {
			super();
			this.no = no;
			this.cost = cost;
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [no=" + no + ", cost=" + cost + ", next=" + next + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if (m == 0 && n == 0) {
				break;
			}
			Node[] node = new Node[m];
			long sum = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				node[from] = new Node(to, cost, node[from]);
				node[to] = new Node(from, cost, node[to]);
				sum += cost;
			}
			
			int[] min = new int[m];
			Arrays.fill(min, Integer.MAX_VALUE);
			boolean[] check = new boolean[m];
			PriorityQueue<Node> q = new PriorityQueue<>();
			min[0] = 0;
			q.offer(new Node(0, 0, null));
			long result = 0;
			int cnt = 0;
			while(!q.isEmpty()){
				Node cur = q.poll();
				if (check[cur.no]) continue;
				check[cur.no] = true; 
				result += min[cur.no];
				if (++cnt == m) break;
				for (Node temp = node[cur.no]; temp != null; temp = temp.next) {
					if(min[temp.no] > temp.cost) {
						min[temp.no] = temp.cost;
						q.offer(new Node(temp.no, min[temp.no], null));
					}
				}
			}
			sb.append(sum - result).append("\n");
		}
		System.out.println(sb);
	}
}