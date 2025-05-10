import java.io.*;
import java.util.*;

public class Main {
	static class Person {
		int r, c;
		public Person(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static class Taxi implements Comparable<Taxi>{
		int r, c, cost, usedCost;
		Person person;
		
		public Taxi(int r, int c, int cost, int usedCost, Person person) {
			this.r = r;
			this.c = c;
			this.cost = cost;
			this.usedCost = usedCost;
			this.person = person;
		}
		
		@Override
		public int compareTo(Taxi o) {
			if (this.r == o.r) {
				return this.c - o.c;
			}
			return this.r - o.r;
		}
	}
	
	static int N, M;
	static int[][] map;
	static Person[][] mapPerson;
	static Taxi taxi;
	public static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	int cost = Integer.parseInt(st.nextToken());
    	map = new int[N + 1][N + 1];
    	mapPerson = new Person[N + 1][N + 1];
    	
    	for (int i = 1; i <= N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 1; j <= N; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	int taxiR = Integer.parseInt(st.nextToken());
    	int taxiC = Integer.parseInt(st.nextToken());
    	taxi = new Taxi(taxiR, taxiC, cost, 0, null); 
    	
    	for (int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int r = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		int targetR = Integer.parseInt(st.nextToken());
    		int targetC = Integer.parseInt(st.nextToken());
    		map[r][c] = 2;
    		mapPerson[r][c] = new Person(targetR, targetC);
    	}
    	
    	System.out.println(start());
	}
	

	public static int start() {
		for (int i = 0; i < M; i++) {
			if (!search()) return -1;
			if (!move()) return -1;
		}
		
		return taxi.cost;
	}
	
	public static boolean search() {
		Queue<Taxi> q = new ArrayDeque<>();
		PriorityQueue<Taxi> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N + 1][N + 1];
		q.add(taxi);
		visited[taxi.r][taxi.c] = true;
		
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (--size >= 0) {
				Taxi t = q.poll();
				
				if (t.cost < 0) continue;
				if (map[t.r][t.c] == 2) {
					pq.add(new Taxi(t.r, t.c, t.cost, 0, mapPerson[t.r][t.c]));
				}
				
				for (int d = 0; d < 4; d++) {
					int dr = t.r + deltas[d][0];
					int dc = t.c + deltas[d][1];
					
					if (!isIn(dr, dc)) continue;
					if (visited[dr][dc]) continue;
					if (map[dr][dc] != 1) {
						q.offer(new Taxi(dr, dc, t.cost - 1, 0, null));
						visited[dr][dc] = true;
					}
				}
			}
			if (pq.size() > 0) break;
		}
		
		if (!pq.isEmpty()) {
			taxi = pq.poll();
			map[taxi.r][taxi.c] = 0;
			return true;
		}
		
		return false;
	}
	
	public static boolean move() {
		Queue<Taxi> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N + 1][N + 1];
		q.add(taxi);
		visited[taxi.r][taxi.c] = true;
		
		while (!q.isEmpty()) {
			Taxi t = q.poll();
			
			if (t.cost < 0) return false;
			if (t.r == t.person.r && t.c == t.person.c) {
				taxi = t;
				taxi.cost += taxi.usedCost * 2;
				taxi.usedCost = 0;
				
				return true;
			}
			
			for (int d = 0; d < 4; d++) {
				int dr = t.r + deltas[d][0];
				int dc = t.c + deltas[d][1];
				
				if (!isIn(dr, dc)) continue;
				if (visited[dr][dc]) continue;
				if (map[dr][dc] != 1) {
					q.offer(new Taxi(dr, dc, t.cost - 1, t.usedCost + 1, t.person));
					visited[dr][dc] = true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean isIn(int r, int c) {
		return 0 < r && r <= N && 0 < c && c <= N;
	}
}
