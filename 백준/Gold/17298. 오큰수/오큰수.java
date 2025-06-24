import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] arr = new int[N];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int[] result = new int[N];
    	Stack<Integer> s = new Stack<>();
    	result[N - 1] = -1;
    	s.add(arr[N - 1]);
    	for (int i = N - 2; i >= 0; i--) {
    		if (s.isEmpty()) {
    			result[i] = -1;
    			continue;
    		}
    		if (arr[i] < s.peek()) {
    			result[i] = s.peek();
    		}
    		else {
    			while (!s.isEmpty()) {
    				if (arr[i] < s.peek()) {
    					result[i] = s.peek();
    					break;
    				}
    				s.pop();
    			}
    			if (result[i] == 0) result[i] = -1;
    		}
    		s.add(arr[i]);
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < N; i++) {
    		sb.append(result[i] + " ");
    	}
    	System.out.println(sb);
	}
	
}
