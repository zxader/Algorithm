import java.util.*;
import java.io.*;

public class Main
{
    static class Node implements Comparable<Node> {
        int no;
        Node next;
        double cost;
        
        Node(int no, Node next, double cost) {
            this.no = no;
            this.next = next;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return Double.compare(this.cost, o.cost);
        }
    }
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] gods = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            gods[i][0] = x;
            gods[i][1] = y;
        }
        
        
        Node[] nodes = new Node[N + 1];
    
        boolean[] visited = new boolean[N + 1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            
            nodes[from] = new Node(to, nodes[from], 0.0);
            nodes[to] = new Node(from, nodes[to], 0.0);
        }
        
        for (int i =1; i <= N; i++) {
            
            int x1 = gods[i][0];
            int y1 = gods[i][1];

            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                
                int x2 = gods[j][0];
                int y2 = gods[j][1];
                
                double d = getDistance(x1, y1, x2, y2);
                
                nodes[i] = new Node(j, nodes[i], d);
                nodes[j] = new Node(i, nodes[j], d);
            }
        }
        
        int count = 0;
        double result = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(1, null, 0));
        
        while (!q.isEmpty()) {
            Node n = q.poll();
            int no = n.no;
            
            if (visited[no]) continue;
            
            result += n.cost;
            count++;
            visited[no] = true;
            
            if (count == N) break;

            for (Node temp = nodes[no]; temp != null; temp = temp.next) {
                if (visited[temp.no]) continue;
                
                
                q.offer(new Node(temp.no, null, temp.cost));
            }
        }
        
        System.out.printf("%.2f\n", result);
	}
	
	static double getDistance(int x1, int y1, int x2, int y2) {
	    long x = x2 - x1;
	    long y = y2 - y1;
	    double d =  Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	    return d;
	}
}