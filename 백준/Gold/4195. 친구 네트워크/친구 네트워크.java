import java.io.*;
import java.util.*;

public class Main {
	static Map<String, Integer> headMap = new HashMap<>();
	static Map<String, String> map = new HashMap<>();
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringBuilder sb = new StringBuilder();
    	int T = Integer.parseInt(br.readLine());
    	for (int t = 1; t <= T; t++) {
        	headMap = new HashMap<>();
        	map = new HashMap<>();
    		int F = Integer.parseInt(br.readLine());
    		
    		for (int i = 0; i < F; i++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			String f1 = st.nextToken();
    			String f2 = st.nextToken();
    			
    			if (map.containsKey(f1) && map.containsKey(f2)) {
    				String head1 = getHead(f1);
    				String head2 = getHead(f2);
    				
    				if (head1 != head2) {
    					headMap.put(head1, headMap.get(head1) + headMap.get(head2));
        				map.put(head2, head1);
        				map.put(f2, head1);
    				}
    				sb.append(headMap.get(head1));
    			
    			}
    			else if (map.containsKey(f1)) {
    				String head1 = getHead(f1);
    				headMap.put(head1, headMap.get(head1) + 1);
    				map.put(f2, head1);
    				sb.append(headMap.get(head1));
    			}
    			else if (map.containsKey(f2)) {
    				String head2 = getHead(f2);
    				headMap.put(head2, headMap.get(head2) + 1);
    				map.put(f1, head2);
    				sb.append(headMap.get(head2));
    			}
    			else {
    				map.put(f1, f1);
    				map.put(f2, f1);
    				headMap.put(f1, 2);
    				sb.append(2);
    			}
    			sb.append("\n");
    		}
    		
    	}
    	System.out.println(sb);
    	
	}
	
	static String getHead(String f) {
		String head = map.get(f);
		while (head != map.get(head)) {
			head = map.get(head);
		}
		map.put(f, head);
		return head;
	}
	
}
