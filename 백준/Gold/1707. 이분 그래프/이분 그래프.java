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
	
	static int[] visited;
	static Node[] node;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int V = Integer.parseInt(st.nextToken());
        	int E = Integer.parseInt(st.nextToken());
        	node = new Node[V + 1];
        	
        	for (int i = 0; i < E; i++) {
        		st = new StringTokenizer(br.readLine());
        		int from = Integer.parseInt(st.nextToken());
        		int to = Integer.parseInt(st.nextToken());
        		
        		node[from] = new Node(to, node[from]);
        		node[to] = new Node(from, node[to]);
        	}
        	
        	String result = "YES";
        	visited = new int[V + 1];
        	
        	loop:
        	for (int i = 1; i <= V; i++) {
        		if (visited[i] == 0) {
        			if (!check(i)) {
        				result = "NO";
        				break loop;
        			}
        		}
        	}
        	
        	sb.append(result).append("\n");
        }
    	
        System.out.println(sb);
    }
    
    static boolean check(int i) {
    	Queue<Integer> q = new ArrayDeque<>();
		q.add(i);
		visited[i] = 1;
		
		while(!q.isEmpty()) {
			int no = q.poll();

			for (Node temp = node[no]; temp != null; temp = temp.next) {
				if (visited[temp.no] == 0) {
					visited[temp.no] = -visited[no];
					q.add(temp.no);
				}
				else if(visited[temp.no] == visited[no]) {
					return false;
				}
			}
		}
		
		return true;
    }
}