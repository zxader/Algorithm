import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] map;
	static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static Node[] node;
	
	static class Node implements Comparable<Node> {
		int no, cost;
		Node next;
		
		public Node(int no, int cost, Node next) {
			this.no = no;
			this.cost = cost;
			this.next = next;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new int[N][M];
    	
    	
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < M; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	K = setLand();
    	node = new Node[K + 1];
    	setBridge();
    	
    	System.out.println(getMinCost());
	}
	
	static int getMinCost() {
		boolean[] visited = new boolean[K];
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(1, 0, null));
		int result = 0;
		int cnt = 0;
		
		while (!q.isEmpty()) {
			Node p = q.poll();
			
			if (visited[p.no]) continue;
			visited[p.no] = true;
			result += p.cost;
			
			if (++cnt == K - 1) return result;
			
			for (Node temp = node[p.no]; temp != null; temp = temp.next) {
				if (!visited[temp.no]) {
					q.offer(new Node(temp.no, temp.cost, null));
				}
			}
		}
		
		
		return -1;
	}
	static int setLand() {
		boolean[][] visited = new boolean[N][M];
		int idx = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					Queue<int[]> q = new ArrayDeque<>();
					q.offer(new int[] {i , j});
					visited[i][j] = true;
					map[i][j] = idx;
					
					while (!q.isEmpty()) {
						int[] p = q.poll();
						
						for (int d = 0; d < 4; d++) {
							int dr = p[0] + deltas[d][0];
							int dc = p[1] + deltas[d][1];
							
							if (isIn(dr, dc) && !visited[dr][dc] && map[dr][dc] == 1) {
								map[dr][dc] = idx;
								visited[dr][dc] = true;
								q.offer(new int[] {dr, dc});
							}
							
						}
					}
					idx++;
				}
			}
		}
		
		return idx;
	}
	
	static void setBridge() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					int idx = map[i][j];
					
					for (int d = 0; d < 4; d++) {
						findBridge(i, j, idx, d, -1);
					}
				}
			}
		}
	}
	
	static void findBridge(int r, int c, int idx, int d, int cost) {
		if (map[r][c] != 0 && cost != -1) {
			if (cost <= 1) return;
			node[idx] = new Node(map[r][c], cost, node[idx]);
			return;
		}
		
		int dr = r + deltas[d][0];
		int dc = c + deltas[d][1];
		
		if (isIn(dr, dc) && map[dr][dc] != idx) {
			findBridge(dr, dc, idx, d, cost + 1);
		}
	}
	
	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}
}	
