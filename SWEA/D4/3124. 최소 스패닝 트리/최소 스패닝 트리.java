import java.util.*;
import java.io.*;

public class Solution {
	static class Node implements Comparable<Node>{
		int no;
		Node next;
		int value;
		
		public Node(int no, Node next, int value) {
			this.no = no;
			this.next = next;
			this.value = value;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
	}

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	sb.append("#" + t + " ");
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int V = Integer.parseInt(st.nextToken());
        	int E = Integer.parseInt(st.nextToken());
        	Node[] node = new Node[V + 1];
        	boolean[] visited = new boolean[V + 1];
        	
        	for (int i = 0; i < E; i++) {
        		st = new StringTokenizer(br.readLine());
        		int from = Integer.parseInt(st.nextToken());
        		int to = Integer.parseInt(st.nextToken());
        		int value = Integer.parseInt(st.nextToken());
        		node[from] = new Node(to, node[from], value);
        		node[to] = new Node(from, node[to], value);
        	}
        	
        	PriorityQueue<Node> q = new PriorityQueue<>();
        	q.add(new Node(1, null, 0));
        	long result = 0;
        	int cnt = 0;
        	
        	while (!q.isEmpty()) {
        		Node p = q.poll();
        		
        		if (visited[p.no]) continue;
        		
        		result += p.value;
        		visited[p.no] = true; 
        		
        		if (++cnt > V - 1) break;
        		
        		for (Node temp = node[p.no]; temp != null; temp = temp.next) {
        			if (!visited[temp.no]) {
        				q.add(new Node(temp.no, null, temp.value));
        			}
        		}
        	}
        	
        	sb.append(result).append("\n");
        }
        
        System.out.println(sb);
    }
}