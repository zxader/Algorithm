import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
static class Vertex implements Comparable<Vertex> {
		
		int no, weight;
		Vertex next;

		public Vertex(int no, int weight, Vertex next) {
			super();
			this.no = no;
			this.weight = weight;
			this.next = next;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		Vertex[] adjList = new Vertex[V + 1];  
		boolean[] visited = new boolean[V + 1]; 
		int[] minEdge = new int[V + 1];  
		st = new StringTokenizer(in.readLine());
		char[] p = new char[V + 1];
		for (int i = 1; i <= V; i++) {
			p[i] = st.nextToken().charAt(0);
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Vertex(to, weight, adjList[from]);
			adjList[to] = new Vertex(from, weight, adjList[to]);
		}
		

		PriorityQueue<Vertex> pq = new PriorityQueue<>();

		
		Arrays.fill(minEdge, Integer.MAX_VALUE);  
		minEdge[1] = 0; 
		
		pq.offer(new Vertex(1, 0, null));
		
		int result = 0; 
		
		int c = 0;
		while (!pq.isEmpty()) {  
			
			Vertex minVertex = pq.poll();
			if (visited[minVertex.no]) {
				continue;
			}
			
			result += minVertex.weight;
			visited[minVertex.no] = true;  
			if (++c == V) {
				break;
			}
		
			for (Vertex temp = adjList[minVertex.no]; temp != null; temp = temp.next) {
				
				if (!visited[temp.no] && temp.weight < minEdge[temp.no] && p[minVertex.no] != p[temp.no]) {
					
					minEdge[temp.no] = temp.weight;
					pq.offer(new Vertex(temp.no, minEdge[temp.no], null));
				}
			}
		}
		
		System.out.println(c == V ? result : -1);
	}

	
}