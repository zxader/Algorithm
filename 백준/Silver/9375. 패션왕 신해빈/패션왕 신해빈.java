import java.io.*;
import java.util.*;

public class Main {
	static Map<String, List<String>> map;
	static int result;
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	for (int t = 1; t <= T; t++) {
    		int n = Integer.parseInt(br.readLine());
    		map = new HashMap<>();

    		for (int i = 0; i < n; i++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			String name = st.nextToken();
    			String type = st.nextToken();
    			
    			if (map.containsKey(type)) {
    				map.get(type).add(name);
    			}
    			else {
    				map.put(type, new ArrayList<>());
    				map.get(type).add(name);
    			}
    		}
    		
    		int result = 1;
    		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
    			result *= (entry.getValue().size() + 1);
    		}
    		
    		sb.append(result - 1).append("\n");
    	}
    	
    	System.out.println(sb);
	}
}
