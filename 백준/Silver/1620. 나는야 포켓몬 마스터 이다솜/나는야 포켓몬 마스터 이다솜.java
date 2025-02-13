import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	Map<String, Integer> map= new HashMap<>();
    	String[] arr = new String[N + 1];
    	
    	for (int i = 1; i <= N; i++) {
    		String input = br.readLine();
    		map.put(input, i);
    		arr[i] = input;
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < M; i++) {
    		String input = br.readLine();
    		if (map.containsKey(input)) {
    			sb.append(map.get(input));
    		}
    		else {
    			sb.append(arr[Integer.parseInt(input)]);
    		}
    		sb.append("\n");
    	}
    	
    	System.out.println(sb);
    }

}