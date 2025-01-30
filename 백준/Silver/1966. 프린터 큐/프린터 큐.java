import java.util.*;
import java.io.*;

public class Main {
	static class Document {
		int no;
		int value;
		
		public Document(int no, int value) {
			this.no = no;
			this.value = value;
		}
	}
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	
        	Queue<Document> q = new ArrayDeque<>();
        	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < N; i++) {
        		int value = Integer.parseInt(st.nextToken());
        		q.offer(new Document(i, value));
        		pq.offer(value);
        	}
        	
        	int cnt = 0;
        	while (!q.isEmpty()) {
        		Document p = q.poll();
        		
        		if (pq.peek() > p.value) {
        			q.add(p);
        		}
        		else {
        			pq.poll();
        			cnt++;
        			
        			if (p.no == M) {
        				sb.append(cnt).append("\n");
        				break;
        			}
        		}
        	}
        	
        }
        
        System.out.println(sb);
	}
}