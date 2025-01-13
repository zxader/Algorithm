import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
        	String[] input = br.readLine().split(" ");
        	String command = input[0];
        	
        	switch(command) {
	    		case "push":
	    			q.offer(Integer.parseInt(input[1]));
	    			break;
	    		case "pop":
	    			sb.append((q.isEmpty()) ? -1 : q.poll()).append("\n");
	    			break;
	    		case "size":
	    			sb.append(q.size()).append("\n");
	    			break;
	    		case "empty":
	    			sb.append((q.isEmpty()) ? 1 : 0).append("\n"); 
	    			break;
	    		case "front":
	    			sb.append((q.isEmpty()) ?  -1 : q.peek()).append("\n");
	    			break;
	    		case "back":
	    			sb.append((q.isEmpty()) ? -1 : q.peekLast()).append("\n");
	    			break;
        	}
        }
        
        System.out.println(sb);
	}
}