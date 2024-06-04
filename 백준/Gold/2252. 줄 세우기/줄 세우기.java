import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
	static StringBuilder sb;
	static class Node{
		int num;
		Node next;
		public Node(int num, Node next) {
			super();
			this.num = num;
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [num=" + num + ", next=" + next + "]";
		}


	}
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		sb = new StringBuilder();

		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		int[] ind = new int[N + 1];
		Node[] node = new Node[N + 1];
		for (int i = 0; i < M; i++) {
			split = in.readLine().split(" ");
			int from = Integer.parseInt(split[0]);
			int to = Integer.parseInt(split[1]);
			node[from] = new Node(to, node[from]);
			ind[to]++;
		}
		Queue<Integer> q = new ArrayDeque<>();
		List<Integer> list = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			if(ind[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int n = q.poll();
			list.add(n);
			for (Node temp = node[n]; temp != null; temp = temp.next) {
				if(--ind[temp.num] == 0) {
					q.offer(temp.num);
				}
			}
		}
		for (int l : list) {
			sb.append(l).append(" ");
		}
		System.out.println(sb);
	}
}