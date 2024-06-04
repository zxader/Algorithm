import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int N;
	static int M;
	static int t;
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int cost;

		public Node(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

		@Override
		public String toString() {
			return "Node [from=" + from + ", to=" + to + ", cost=" + cost + "]";
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		long cost = 0;
		long total = 0;
		Node[] node = new Node[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			node[i] = new Node(A, B, C);
		}
		Arrays.sort(node);
		make();
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			if (union(node[i].to, node[i].from)) {
				total += node[i].cost + cost;
				cost += t;
				if (++cnt == N - 1) {
					break;
				}
			}
		}
		sb.append(total);
		System.out.println(sb);
	}
	
	static void make() {
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
	}
	
	static int find(int a) {
		if (arr[a] == a) {
			return a;
		}
		
		return arr[a] = find(arr[a]); 
	}
	
	static boolean union(int a, int b) {
		int A = find(a);
		int B = find(b);
		
		if (A == B) {
			return false;
		}
		arr[A] = B;
		return true;
		
	}

}