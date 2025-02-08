import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());
       Map<String, Integer> map = new HashMap<>();
       
       for (int i = 0; i < N; i++) {
    	   map.put(br.readLine(), 1);
       }
       
       List<String> result = new ArrayList<>();
       for (int i = 0; i < M; i++) {
    	   String input = br.readLine();
    	   
    	   if (map.containsKey(input)) {
    		   result.add(input);
    	   }
       }
       
       Collections.sort(result);
       
       StringBuilder sb = new StringBuilder();
       sb.append(result.size()).append("\n");
       for (String str : result) {
    	   sb.append(str).append("\n");
       }
       
       System.out.println(sb);
	}
}