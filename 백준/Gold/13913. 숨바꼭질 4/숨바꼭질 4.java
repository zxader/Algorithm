import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int K;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bfs();
		System.out.println(sb);
	}
	static int[] dx = {1, -1};
	static class Position {
		int x;
		int v;
		Position before;
		
		public Position (int x, int v) {
			this.x = x;
			this.v = v;
		}
	}
	static void bfs() {
		Queue<Position> q = new ArrayDeque<>();
		q.add(new Position(N, 0));
		boolean[] check = new boolean[100001];
		check[N] = true;
		
		while(!q.isEmpty()) {
			Position p = q.poll();
			
			if (p.x == K) {
				List<Integer> list = new ArrayList<>();
				sb.append(p.v).append("\n");
				while(p.before != null) {
					list.add(p.x);
					p = p.before;
				}
				list.add(N);
				for (int i = list.size() - 1; i >= 0; i--) {
					sb.append(list.get(i) + " ");
				}
			}
			
			for (int i = 0; i < 3; i++) {
				int d = 0;
				if (i == 2) {
					d = p.x * 2;
				}
				else {
					d = p.x + dx[i];
				}
				if (0 <= d && d <= 100000 && !check[d]) {
					Position after = new Position(d, p.v + 1);
					after.before = p;
					q.add(after);
					check[d] = true;
				}
			}
		}
		
	}
}