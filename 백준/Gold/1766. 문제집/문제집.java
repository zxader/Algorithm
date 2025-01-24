import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node>{
		int no;
		Node next;
		
		public Node(int no, Node next) {
			this.no = no;
			this.next = next;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.no - o.no;
		}
	}
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] count = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Node[] node = new Node[N + 1];
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	node[from] = new Node(to, node[from]);
        	count[to]++;
        }
        
        PriorityQueue<Node> q = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
        	if (count[i] == 0) {
        		q.offer(new Node(i, null));
        		visited[i] = true;
        	}
        }
        List<Integer> result = new ArrayList<>();
        
        while(!q.isEmpty()) {
        	Node n = q.poll();
        	
        	result.add(n.no);
        	
        	for (Node temp = node[n.no]; temp != null; temp = temp.next) {
        		if (!visited[temp.no] && --count[temp.no] == 0) {
        			q.offer(new Node(temp.no, null));
        			visited[temp.no] = true; 
        		}
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
        	sb.append(i).append(" ");
        }
        
        System.out.println(sb);
	}
}