import java.util.*;
import java.io.*;

public class Main {
	static class Node {
		int no;
		int l;
		Node next;
		public Node(int no, int l, Node next) {
			super();
			this.no = no;
			this.l = l;
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [no=" + no + ", l=" + l + ", next=" + next + "]";
		}

	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int j = 1; j <= n; j++) {
			arr[j] = Integer.parseInt(st.nextToken());
		}
		Node[] node = new Node[n + 1];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			node[from] = new Node(to, l, node[from]);
			node[to] = new Node(from, l, node[to]);
		}

		int[] minDis = new int[n + 1];
		int result = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			for (int e = 1; e <= n; e++) {
				boolean[] visited = new boolean[n + 1];
				Arrays.fill(minDis, Integer.MAX_VALUE);
				minDis[i] = 0;
				for (int j = 0; j < n; j++) {
					int idx = -1;
					int min = Integer.MAX_VALUE;
					for (int k = 1; k <= n; k++) {
						if(!visited[k] && min > minDis[k]) {
							min = minDis[k];
							idx = k;
						}
					}
					if (idx == -1) break;
					visited[idx] = true;
					if (idx == e) break;
					for (Node temp = node[idx]; temp != null; temp = temp.next) {
						if (minDis[temp.no] > temp.l + minDis[idx]) {
							minDis[temp.no] = temp.l + minDis[idx];
						}
					}

				}
				int sum = 0;
				for (int j = 1; j <= n; j++) {
					if (minDis[j] <= m) {
						sum += arr[j];
					}
				}
				result = Math.max(result, sum);
			}
		}
		sb.append(result);
		System.out.println(sb);
	}
}