import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int K;
	static int[][] arr;
	static boolean[] used;
	static class Node implements Comparable<Node>{
		int from, to;
		int cost;
		public Node(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Node [from=" + from + ", to=" + to + ", cost=" + cost + "]";
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static Node[] node;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		node = new Node[M];
		make();
		used = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int b = Integer.parseInt(st.nextToken());
			used[b] = true;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			node[i] = new Node(from, to, cost);
		}

		Arrays.sort(node);
		long cost = 0;
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			if (union(node[i].from, node[i].to)) {
				cost += node[i].cost;
				if(++cnt == N) {
					break;
				}
			}
		}
		sb.append(cost);
		System.out.println(sb);
	}

	static void make() {
		arr = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			arr[i][0] = i;
		}
	}

	static int find(int a) {
		if (arr[a][0] == a) {
			return a;
		}
		return arr[a][0] = find(arr[a][0]);
	}

	static boolean union(int a, int b) {
		int A = find(a);
		int B = find(b);
		if (used[A] && used[B]) {
			return false;
		}
		if (used[A] || used[B]) {
			used[A] = true;
			used[B] = true;
		}
		if (A == B) {
			return false;
		}
		arr[A][0] = B;
		return true;
	}
}