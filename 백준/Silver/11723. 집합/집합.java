import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int M = Integer.parseInt(br.readLine());
    	
    	Set<Integer> set = new HashSet<>();
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < M; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		String c = st.nextToken();
    		int n = 0;
    		switch(c) {
    		case "add":
    			n = Integer.parseInt(st.nextToken());
    			set.add(n);
    			break;
    		case "remove":
    			n = Integer.parseInt(st.nextToken());
    			set.remove(n);
    			break;
    		case "check":
    			n = Integer.parseInt(st.nextToken());
    			sb.append(set.contains(n) ? 1 : 0).append("\n");
    			break;
    		case "toggle":
    			n = Integer.parseInt(st.nextToken());
    			if (set.contains(n)) {
    				set.remove(n);
    			}
    			else {
    				set.add(n);
    			}
    			break;
    		case "all":
    			for (int j = 1; j <= 20; j++) {
    				set.add(j);
    			}
    			break;
    		case "empty":
    			set.clear();
    			break;
    		}
    	}
    	
    	System.out.println(sb);
	}
	
}
