import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
        	String[] input = br.readLine().split(" ");
        	
        	switch(input[0]) {
        		case "push":
        			q.offer(Integer.parseInt(input[1]));
        			break;
	        	case "pop":
	        		sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
	        		break;
	        	case "size":
	        		sb.append(q.size()).append("\n");
	        		break;
	        	case "empty":
	        		sb.append(q.isEmpty() ? 1 : 0).append("\n");
	        		break;
	        	case "front":
	        		sb.append(q.isEmpty() ? -1 : q.peekFirst()).append("\n");
	        		break;
	        	case "back":
	        		sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
	        		break;
        	}
        }
        
        System.out.println(sb);
	}
}