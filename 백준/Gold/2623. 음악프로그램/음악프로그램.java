import java.util.*;
import java.io.*;

public class Main {
	static class Node {
		int no;
		Node next;
		public Node(int no, Node next) {
			super();
			this.no = no;
			this.next = next;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		Node[] node = new Node[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			for (int j = 1; j < num; j++) {
				int to = Integer.parseInt(st.nextToken());
				node[from] = new Node(to, node[from]);
				arr[to]++;
				from = to;
			}
		}

		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (arr[i] == 0) {
				q.offer(i);
			}
		}
		List<Integer> list = new ArrayList<>();
		while(!q.isEmpty()) {
			int poll = q.poll();
			list.add(poll);
			for (Node temp = node[poll]; temp != null; temp = temp.next) {
				if (--arr[temp.no] == 0) {
					q.offer(temp.no);
				}
			}
		}
		if (list.size() < N) {
			sb.append(0);
		}
		else {
			for (int i : list) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}
}