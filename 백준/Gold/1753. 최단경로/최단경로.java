import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static class Node{
		int num;
		int w;
		Node next;
		
		public Node(int num, int w, Node next) {
			super();
			this.num = num;
			this.w = w;
			this.next = next;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		int V = Integer.parseInt(st.nextToken().trim());
		int E = Integer.parseInt(st.nextToken().trim());
		Node[] node = new Node[V + 1];
		int[] mindistance = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		int start = Integer.parseInt(in.readLine());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine().trim());
			int from = Integer.parseInt(st.nextToken().trim());
			int to = Integer.parseInt(st.nextToken().trim());
			int w = Integer.parseInt(st.nextToken().trim());
			node[from] = new Node(to, w, node[from]);
		}
		
		Arrays.fill(mindistance, Integer.MAX_VALUE);
		mindistance[start] = 0;
		
		for (int i = 1; i <= V; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			
			for (int j = 1; j <= V; j++) {
				if(!visited[j] && min > mindistance[j]) {
					min = mindistance[j];
					idx = j;
				}
			}
			
			if (idx == -1) {
				break;
			}
			visited[idx] = true;
			
			for (Node temp = node[idx]; temp != null; temp = temp.next) {
				if(mindistance[temp.num] > min + temp.w) {
					mindistance[temp.num] = min + temp.w;
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if (mindistance[i] != Integer.MAX_VALUE) {
				sb.append(mindistance[i]).append("\n");
			}
			else {
				sb.append("INF").append("\n");
			}
		}
		System.out.println(sb);
	}
}