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
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	int[] times = new int[N + 1];
        	int[] order = new int[N + 1];
        	Node[] node = new Node[N + 1];
        	int[] dp = new int[N + 1];
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i = 1; i <= N; i++) {
        		times[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	for (int i = 0; i < K; i++) {
        		st = new StringTokenizer(br.readLine());
        		int from = Integer.parseInt(st.nextToken());
        		int to = Integer.parseInt(st.nextToken());
        		node[from] = new Node(to, node[from]);
        		order[to]++;
        	}
        	
        	int W = Integer.parseInt(br.readLine());
        	
        	Queue<Integer> q = new ArrayDeque<>();
        	
        	for (int i = 1; i <= N; i++) {
        		if (order[i] == 0) {
        			q.offer(i);
        			dp[i] = times[i];
        		}
        	}
        	
        	while(!q.isEmpty()) {
        		int size = q.size();
        		
        		while(--size >= 0) {
        			int p = q.poll();
        			
        			for (Node temp = node[p]; temp != null; temp = temp.next) {
        				dp[temp.no] = Math.max(dp[temp.no], dp[p] + times[temp.no]);
        				if (--order[temp.no] == 0) {
        					q.offer(temp.no);
        				}
        			}
        		}
        	}
        
        	sb.append(dp[W]).append("\n");
        }
        System.out.println(sb);
	}
}