import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int no;
		Node next;
		int time;

		public Node(int no, Node next, int time) {
			super();
			this.no = no;
			this.next = next;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Node [no=" + no + ", next=" + next + ", time=" + time + "]";
		}
	}
	static int max;
	static int N;
	static int M;
	static int X;
	static Node[] node;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		max = 0;
		node = new Node[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			node[from] = new Node(to, node[from], time);
		}
		
		for (int i = 1; i <= N; i++) {
			int a = dijk(X, i);
			int b = dijk(i, X);
			if(max < a + b) {
				max = a + b;
			}
		}
		
		sb.append(max);
		System.out.println(sb);
	}
	
	static int dijk(int start, int end) {
		int[] dk = new int[N + 1];
		boolean[] used = new boolean[N + 1];
		Arrays.fill(dk, Integer.MAX_VALUE);
		dk[start] = 0;
		for (int i = 1; i <= N; i++) {
			int idx = -1;
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= N; j++) {
				if (dk[j] < min && !used[j]) {
					min = dk[j];
					idx = j;
				}
			}
			
			if (idx == -1) {
				break;
			}
			used[idx] = true;
			if (idx == end) {
				break;
			}
			for (Node temp = node[idx]; temp != null; temp = temp.next) {
				if (dk[temp.no] > temp.time + min) {
					dk[temp.no] = temp.time + min;
				}
			}
		}
		
		return dk[end];
	}
	
}