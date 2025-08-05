import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int r, c;
		Node next;
		
		public Node(int r, int c, Node next) {
			this.r = r;
			this.c = c;
			this.next = next;
		}
	}
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int K = Integer.parseInt(br.readLine());
    	int[][] map = new int[N + 1][N + 1];
    	
    	for (int i = 0; i < K; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int r = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		map[r][c] = 1;
    	}
    	
    	int L = Integer.parseInt(br.readLine());
    	String[] arr = new String[10001];
    	for (int i = 0; i < L; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int t = Integer.parseInt(st.nextToken());
    		String d = st.nextToken();
    		arr[t] = d;
    	}
    	
    	Node head = new Node(1, 1, null);
    	Node tail = head;
    	tail.next = head;
    	
    	int len = 1;
    	int r = 1;
    	int c = 1;
    	int d = 0;
    	int[] dy = {0, 1, 0, -1};
    	int[] dx = {1, 0, -1, 0};
    	int time = 0;
    	map[1][1] = 2;
    	
    	while (true) {
    		
    		r += dy[d];
    		c += dx[d];
    		
    		time++;
    		if (r < 1 || r > N || c < 1 || c > N) break;
    		if (map[r][c] == 2) break;
    		
    		head.next = new Node(r, c, null);
    		head = head.next;
    		
    		if (map[r][c] != 1) {
    			map[tail.r][tail.c] = 0;
    			tail = tail.next;
    		}
    		else {
    			len++;
    		}
    		
    		map[r][c] = 2;
    		
    		d = changeDirect(d, arr[time]);
    	}
    	
    	System.out.println(time);
	}	
	
	static int changeDirect(int d, String D) {
		if (D == null) return d;
		if (D.equals("D")) {
			switch (d) {
			case 0:
				return 1;
			case 1:
				return 2;
			case 2:
				return 3;
			case 3:
				return 0;
			}
		}
		else if (D.equals("L")) {
			switch (d) {
			case 0:
				return 3;
			case 1:
				return 0;
			case 2:
				return 1;
			case 3:
				return 2;
			}
		}
		return d;
	}
}