import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int no;
		int cost;
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
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Node[] node = new Node[N + 1];
		int[] degree = new int[N + 1];
		Queue<Integer> q = new ArrayDeque<>();
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (c == 0) {
				dp[i] = t;
			}
			for (int j = 0; j < c; j++) {
				int k = Integer.parseInt(st.nextToken());
				node[k] = new Node(i, t, node[k]);
				degree[i]++;
			}
		}
		boolean[] used = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) {
				q.offer(i);
				used[i] = true;
			}
		}
		List<Integer> list = new ArrayList<>();
	
		while(!q.isEmpty()) {
			int no = q.poll();
			list.add(no);
			for (Node temp = node[no]; temp != null; temp = temp.next) {
				if (--degree[temp.no] == 0) {
					q.offer(temp.no);
					used[temp.no] = true; 
				}
				if (dp[temp.no] < temp.cost + dp[no]) {
					dp[temp.no] = temp.cost + dp[no];
				}
			}
		}
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum = Math.max(sum, dp[i]);
		}
		sb.append(sum);
		System.out.println(sb);
	}
}