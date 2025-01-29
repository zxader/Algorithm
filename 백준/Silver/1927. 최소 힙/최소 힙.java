import java.util.*;
import java.io.*;

public class Main {
    
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
        	int input = Integer.parseInt(br.readLine());
        	
        	if (input == 0) {
        		if (q.isEmpty()) {
        			sb.append(0);
        		}
        		else {
        			sb.append(q.poll());
        		}
        		sb.append("\n");
        	}
        	else {
        		q.offer(input);
        	}
        }
        
        System.out.println(sb);
	}
	
}