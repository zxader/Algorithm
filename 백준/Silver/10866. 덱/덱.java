import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> d = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
        	String[] input = br.readLine().split(" ");
        	
        	switch(input[0]) {
        		case "push_front":
        			d.addFirst(Integer.parseInt(input[1]));
        			break;
	        	case "push_back":
	        		d.addLast(Integer.parseInt(input[1]));
	        		break;
	        	case "pop_front":
	        		sb.append(d.isEmpty() ? -1 : d.pollFirst()).append("\n");
	        		break;
	        	case "pop_back":
	        		sb.append(d.isEmpty() ? -1 : d.pollLast()).append("\n");
	        		break;
	        	case "size":
	        		sb.append(d.size()).append("\n");
	        		break;
	        	case "empty":
	        		sb.append(d.isEmpty() ? 1 : 0).append("\n");
	        		break;
	        	case "front":
	        		sb.append(d.isEmpty() ? -1 : d.peekFirst()).append("\n");
	        		break;
	        	case "back":
	        		sb.append(d.isEmpty() ? -1 : d.peekLast()).append("\n");
	        		break;
        	}
        }
        
        System.out.println(sb);
	}
}