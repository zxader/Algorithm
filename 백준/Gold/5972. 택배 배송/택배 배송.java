import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int no, value;
		Node next;
		
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
	static int N;
	static int M;
	static Node[] node;
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	node = new Node[N + 1];
    	
    	for (int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int from = Integer.parseInt(st.nextToken());
    		int to = Integer.parseInt(st.nextToken());
    		int value = Integer.parseInt(st.nextToken());
    		node[from] = new Node(to, node[from], value);
    		node[to] = new Node(from, node[to], value);
    	}
    	
    	System.out.println(start());
    }
    
    static int start() {
    	int[] minValue = new int[N + 1];
    	Arrays.fill(minValue, Integer.MAX_VALUE);
    	PriorityQueue<Node> q = new PriorityQueue<>();
    	q.offer(new Node(1, null, 0));
    	minValue[1] = 0;
    	
    	while (!q.isEmpty()) {
    		Node p = q.poll();
    		
    		for (Node temp = node[p.no]; temp != null; temp = temp.next) {
    			if (minValue[temp.no] > minValue[p.no] + temp.value) {
    				minValue[temp.no] = minValue[p.no] + temp.value;
    				q.offer(new Node(temp.no, null, temp.value));
    			}
    		}
    	}
    	
    	return minValue[N];
    }
}
