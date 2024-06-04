import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int w;
		public Edge(int from, int to, int w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	static StringBuilder sb;
	static int[] parents;
	static int N;
	static int M;
	static Edge[] edge;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edge = new Edge[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edge[i] = new Edge(from, to, w);
		}
		Arrays.sort(edge);
		make();
		int sum = 0;
		int max = 0;
		int cnt = 0;
		for (int i = 0 ; i < M; i++) {
			if(union(edge[i].from,edge[i].to)) {
				sum += edge[i].w;
				max = Math.max(max, edge[i].w);
				if(++cnt == N - 1) {
					break;
				}
			}
		}
		sb.append(sum - max);
		sb.append("\n");
		System.out.println(sb);
	}
	
	static void make() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if (parents[a] == a) {
			return a;
		}
		
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int A = find(a);
		int B = find(b);
		
		if (A == B) {
			return false;
		}
		parents[B] = A;
		return true;
	}
}