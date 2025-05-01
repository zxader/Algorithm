import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int no;
		Node next;
		
		public Node(int no, Node next) {
			this.no = no;
			this.next = next;
		}
	}
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	Node[] node = new Node[N + 1];
    	
    	for (int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int from = Integer.parseInt(st.nextToken());
    		int to = Integer.parseInt(st.nextToken());
    		node[from] = new Node(to, node[from]);
    		node[to] = new Node(from, node[to]);
    	}
    	
    	boolean[] visited = new boolean[N + 1];
    	int result = 0;
    	for (int i = 1; i <= N; i++) {
    		if (visited[i]) continue;
    		result++;
    		Queue<Integer> q = new ArrayDeque<>();
    		q.add(i);
    		visited[i] = true;
    		
    		while (!q.isEmpty()) {
    			int p = q.poll();
    			
    			for (Node temp = node[p]; temp != null; temp = temp.next) {
    				if (!visited[temp.no]) {
    					q.add(temp.no);
    					visited[temp.no] = true;
    				}
    			}
    		}
    	}
    	
    	System.out.println(result);
	}
}
