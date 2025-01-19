import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < N; i++) {
        	int x = Integer.parseInt(br.readLine());
        	
        	if (x == 0) {
        		if (q.isEmpty()) {
        			sb.append(x).append("\n");
        		}
        		else {
        			sb.append(q.poll()).append("\n");
        		}
        	}
        	else {
        		q.add(x);
        	}
        }
        
        System.out.println(sb);
	}
}