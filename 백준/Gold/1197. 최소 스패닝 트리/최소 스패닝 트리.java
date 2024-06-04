import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int no;
		Node next;
		int w;
		public Node(int no, Node next, int w) {
			super();
			this.no = no;
			this.next = next;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	static StringBuilder sb;
	static int V;
	static int E;
	static Node[] node;
	static int[] minEdge;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		node = new Node[V + 1];
		minEdge = new int[V + 1];
		visited = new boolean[V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			node[from] = new Node(to, node[from] , w);
			node[to] = new Node(from, node[to] , w);
		}
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[1] = 0;
		int sum = 0;
		Queue<Node> q = new PriorityQueue<>();
		q.offer(new Node(1, null, 0));
		int cnt = 0;
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(visited[n.no]) continue;
			visited[n.no] = true;
			sum += n.w;
			if (++cnt == V) break;
			for (Node temp = node[n.no]; temp != null; temp = temp.next ) {
				if(!visited[temp.no] &&minEdge[temp.no] > temp.w) {
					minEdge[temp.no] = temp.w;
					q.offer(new Node(temp.no, null, temp.w));
				}
			}
			
		}
		sb.append(sum);
		sb.append("\n");
		System.out.println(sb);
	}
	
}