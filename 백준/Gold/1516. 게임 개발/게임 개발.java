import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int no;
		Node next;
		
		public Node(int no, Node next) {
			super();
			this.no = no;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [no=" + no + ", next=" + next + "]";
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N + 1];
		long[] arr = new long[N + 1];
		int[] inDegree = new int[N + 1];
		Node[] node = new Node[N + 1];
		Node[] save = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			time[i] = t;
			arr[i] = t;
			int from;
			while ((from = Integer.parseInt(st.nextToken())) != -1) {
				node[from] = new Node(i, node[from]);
				save[i] = new Node(from, save[i]);
				inDegree[i]++;
			}
		}
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
			}
		}
		List<Integer> list = new ArrayList<>();
		while (!q.isEmpty()) {
			int n = q.poll();
			list.add(n);
			for (Node temp = node[n]; temp != null; temp = temp.next) {
				if (--inDegree[temp.no] == 0) {
					q.add(temp.no);
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			long max = 0;
			for (Node temp = save[list.get(i)]; temp != null; temp = temp.next) {
				if (max < arr[temp.no]) {
					max = arr[temp.no];
				}
				
			}
			arr[list.get(i)] += max;
		}

		for (int i = 1; i <= N; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
}