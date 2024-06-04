import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int num;
		Node next;
		int w;
		public Node(int num, Node next, int w) {
			super();
			this.num = num;
			this.next = next;
			this.w = w;
		}
	}
	static StringBuilder sb;
	static int N;
	static int E;
	static Node[] node;
	static int u;
	static int v;
	static int[] mindistance;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		node = new Node[N + 1];
		for (int i = 0 ; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			node[from] = new Node(to, node[from], w);
			node[to] = new Node(from, node[to], w);
		}
		st = new StringTokenizer(in.readLine());
		u = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		int su = distra(1, u);
		int sv = distra(1, v);
		int uv = distra(u, v);
		int ue = distra(u, N);
		int ve = distra(v, N);
		
		int min = Math.min(su + uv + ve, sv + uv + ue);
		if ((su == Integer.MAX_VALUE && sv == Integer.MAX_VALUE)
				|| (ue == Integer.MAX_VALUE && ve == Integer.MAX_VALUE)) {
			min = -1;
		}
		if (u == 1 && v == N) {
			min = distra(1, N);
			if(min == Integer.MAX_VALUE) {
				min = -1;
			}
		}
		sb.append(min);
		sb.append("\n");
		System.out.println(sb);
	}
	
	static int distra(int start, int end) {
		mindistance = new int[N + 1];
		visited = new boolean[N + 1];
		
		Arrays.fill(mindistance, Integer.MAX_VALUE);
		mindistance[start] = 0 ;
		for (int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			
			for (int j = 1; j <= N; j++) {
				if (!visited[j] && min > mindistance[j]) {
					min = mindistance[j];
					idx = j;
				}
			}
			if (idx == -1) {
				break;
			}
			visited[idx] = true;
			if (idx == end) {
				break;
			}
			for (Node temp = node[idx]; temp != null; temp = temp.next) {
				if(mindistance[temp.num] > min + temp.w) {
					mindistance[temp.num] = min + temp.w;
				}
			}
			
		}
		return mindistance[end];
	}
}