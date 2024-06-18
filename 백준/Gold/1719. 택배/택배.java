import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static String[][] result;
	static Node[] node;
	static class Node{
		int no;
		int value;
		Node next;
		
		public Node(int no, int value, Node next) {
			super();
			this.no = no;
			this.value = value;
			this.next = next;
		}


		@Override
		public String toString() {
			return "Node [no=" + no + ", value=" + value + ", next=" + next + "]";
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new String[N + 1][N + 1];
		node = new Node[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			node[from] = new Node(to, value, node[from]);
			node[to] = new Node(from, value, node[to]);
		}
		for (int i = 1; i <= N; i++) {
				dijk(i);
			
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					sb.append("- ");
					continue;
				}
				sb.append(result[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void dijk(int start) {
		int[][] check = new int[N + 1][2];
		for (int i = 1; i < N + 1; i++) {
			check[i][0] = Integer.MAX_VALUE;
		}
		boolean[] used = new boolean[N + 1];
		check[start][0] = 0;
		used[start] = true;
		for (Node temp = node[start]; temp != null; temp = temp.next) {
			check[temp.no][1] = temp.no;
			check[temp.no][0] = temp.value;
		}
		for (int i = 0; i < N; i++) {
			int idx = -1;
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= N; j++) {
				if (!used[j] && min > check[j][0]) {
					min = check[j][0];
					idx = j;
				}
			}
			if (idx == -1) {
				break;
			}
			used[idx] = true;
			for (Node temp = node[idx]; temp != null; temp = temp.next) {
				if (!used[temp.no] && check[temp.no][0] > check[idx][0] + temp.value) {
					check[temp.no][0] = check[idx][0] + temp.value;
					check[temp.no][1] = check[idx][1];
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			if (i == start) continue;
			result[start][i] = check[i][1] + "";
		}
	}
}