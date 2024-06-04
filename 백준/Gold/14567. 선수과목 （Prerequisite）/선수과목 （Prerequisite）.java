import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

	static class Edge{
		int num;
		Edge next;
		public Edge(int num, Edge next) {
			super();
			this.num = num;
			this.next = next;
		}

	}

	public static void main(String args[]) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		int[] degree = new int[N + 1];
		List<Integer> list = new ArrayList<>();
		Edge[] edge = new Edge[N + 1];
		for (int i = 0; i < M; i++) {
			split = in.readLine().split(" ");
			int from = Integer.parseInt(split[0]);
			int to = Integer.parseInt(split[1]);
			edge[from] = new Edge(to, edge[from]);
			degree[to]++;
		}


		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if(degree[i] == 0) {
				q.offer(i);
			}
		}
		int cnt = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size>=0) {
				int num = q.poll();
				degree[num] = cnt;
				list.add(num);
				for (Edge temp = edge[num]; temp != null; temp = temp.next) {
					if(--degree[temp.num] == 0) {
						q.offer(temp.num);
					}
				}
			}
			cnt++;
		}
		for(int i = 1; i <= N; i++) {
			sb.append(degree[i]).append(" ");
		}
		sb.append("\n");
		System.out.println(sb);
	}


}