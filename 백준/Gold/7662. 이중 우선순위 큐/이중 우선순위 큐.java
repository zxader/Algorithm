import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	StringBuilder sb = new StringBuilder();
    	for (int t = 1; t <= T; t++) {
    		int k = Integer.parseInt(br.readLine());
    		TreeMap<Integer, Integer> map = new TreeMap<>();
    		
    		for (int i = 0; i < k; i++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			String c = st.nextToken();
    			int n = Integer.parseInt(st.nextToken());
    			
    			if (c.equals("I")) {
    				if (map.containsKey(n)) {
    					map.put(n, map.get(n) + 1);
    				}
    				else {
    					map.put(n, 1);
    				}
    			}
    			else {
    				if (map.size() == 0) continue;
    				if (n == -1) {
    					int key = map.firstKey();
    					int v = map.get(key) -1;
    					if (v == 0) {
    						map.remove(key);
    					}
    					else {
    						map.put(key, v);
    					}
    				}
    				else {
    					int key = map.lastKey();
    					int v = map.get(key) -1;
    					if (v == 0) {
    						map.remove(key);
    					}
    					else {
    						map.put(key, v);
    					}
    				}
    			}
    		}
    		if (map.size() == 0) {
    			sb.append("EMPTY");
    		}
    		else {
    			sb.append(map.lastKey() + " " + map.firstKey());
    		}
    		sb.append("\n");
    	}
    	
    	System.out.println(sb);
	}
	
}
