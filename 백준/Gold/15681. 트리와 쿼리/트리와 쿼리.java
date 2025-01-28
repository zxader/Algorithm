import java.util.*;
import java.io.*;

public class Main {
	static class Node {
		int no;
		Node next;
		
		public Node(int no, Node next) {
			this.no = no;
			this.next = next;
		}
	}
	
	static int N;
	static int R;
	static int Q;
    static Node[] node;
    static boolean[] visited;
    static int[] nodeNum;
    
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        node = new Node[N + 1];
        visited = new boolean[N + 1];
        nodeNum = new int[N + 1];
        
        for (int i = 0; i < N - 1; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	node[from] = new Node(to, node[from]);
        	node[to] = new Node(from, node[to]);
        }
        
        visited[R] = true;
        nodeNum[R] = dfs(R);
      
        for (int i = 0; i < Q; i++) {
        	sb.append(nodeNum[Integer.parseInt(br.readLine())]).append("\n");
        }
        
        System.out.println(sb);
	}
	
	static int dfs(int num) {
		if (nodeNum[num] != 0) return nodeNum[num];
		nodeNum[num] = 1;
		
		for (Node temp = node[num]; temp != null; temp = temp.next) {
			if (!visited[temp.no]) {
				visited[temp.no] = true;
				nodeNum[num] += dfs(temp.no);
			}
		}
		
		return nodeNum[num];
	}
}