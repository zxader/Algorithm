import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Start{
		double x;
		double y;
		public Start(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Node implements Comparable<Node>{
		int no;
		Node next;
		double w;
		public Node(int no, Node next, double w) {
			super();
			this.no = no;
			this.next = next;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return Double.compare(this.w, o.w);
		}
	}
	static StringBuilder sb;
	static int N;
	static boolean[] visited;
	static double[] minEdge;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(in.readLine());
		visited = new boolean[N];
		minEdge = new double[N];
		Start[] start = new Start[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			start[i] = new Start(x, y);
		}
		Node[] node = new Node[N];
		for (int i = 0; i < N - 1; i++) {
			for (int j = i; j < N; j++) {
				double x = start[i].x - start[j].x;
				double y = start[i].y - start[j].y;
				double l = Math.sqrt(x*x + y*y);
				node[i] = new Node(j, node[i], l);
				node[j] = new Node(i, node[j], l);
			}
		}
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[0] = 0;
		Queue<Node> q = new PriorityQueue<>();
		q.offer(new Node(0, null, minEdge[0]));
		double sum = 0;
		int cnt = 0;
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(visited[n.no]) continue;
			visited[n.no] = true;
			sum += n.w;
			if (++cnt == N) break;
			for (Node temp = node[n.no]; temp != null; temp = temp.next) {
				if (minEdge[temp.no] > temp.w) {
					minEdge[temp.no] = temp.w;
					q.offer(new Node(temp.no, null, temp.w));
				}
			}
		}
		sb.append(Math.round(sum*100)/100.0);
		sb.append("\n");
		System.out.println(sb);
	}
	
}