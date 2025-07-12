import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	int M = Integer.parseInt(br.readLine());
    	String s = br.readLine();
    	int result = 0;
    	
    	for (int i = 0; i < M; i++) {
    		if (s.charAt(i) == 'I') {
    			char c = 'I';
    			int cnt = 1;
    			while (true) {
    				if (cnt == 2 * N + 1) break;
    				if (i + 1 >= M) break;
    				if (s.charAt(i + 1) == c) break;
    				c = (c == 'I') ? 'O' : 'I';
    				cnt++;
    				i++;
    			}
    			if (cnt == 2 * N + 1) {
    				result++;
    				while (true) {
    					if (i + 1 >= M || i + 2 >= M) break;
    					if (s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I') {
    						result++;
    						i += 2;
    					}
    					else {
    						break;
    					}
    				}
    			}
    		}
    	}
    	System.out.println(result);
	}
	
}
