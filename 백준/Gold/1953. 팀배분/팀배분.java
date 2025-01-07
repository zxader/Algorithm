import java.util.*;
import java.io.*;

public class Main {
	static class Node {
		int no;
		Node next;
		
		Node(int no, Node next) {
			this.no = no;
			this.next = next;
		}
	}
	static int N;
	static Node[] node;
	static int[] colors;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        node = new Node[N + 1];
        colors = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int num = Integer.parseInt(st.nextToken());
        	
        	for (int j = 0; j < num; j++) {
        		int to = Integer.parseInt(st.nextToken());
        		
        		node[i] = new Node(to, node[i]);
        		node[to] = new Node(i, node[to]);
        	}
        }
        
        bfs();
        
        List<Integer> blue = new ArrayList<>();
        List<Integer> white = new ArrayList<>();
        
        for (int i = 1; i <= N; i++) {
        	if (colors[i] == 1) {
        		blue.add(i);
        	}
        	else {
        		white.add(i);
        	}
        }
        
        Collections.sort(blue);
        Collections.sort(white);
        
        sb.append(blue.size()).append("\n");
        for (int i : blue) {
        	sb.append(i).append(" ");
        }
        sb.append("\n");
        
        sb.append(white.size()).append("\n");
        for (int i : white) {
        	sb.append(i).append(" ");
        }
        
        System.out.println(sb);
    }
    
    static void bfs() {
    	for (int i = 1; i <= N; i++) {
    		if (colors[i] == 0) {
    			selectTeam(i);
    		}
    	}
    }
    
    static void selectTeam(int i) {
    	Queue<Integer> q = new ArrayDeque<>();
    	q.add(i);
    	colors[i] = 1;
    	
    	while (!q.isEmpty()) {
    		int no = q.poll();
    		
    		for (Node temp = node[no]; temp != null; temp = temp.next) {
    			if (colors[temp.no] == 0) {
    				colors[temp.no] = -colors[no];
    				q.add(temp.no);
    			}
    		}
    	}
    }
}