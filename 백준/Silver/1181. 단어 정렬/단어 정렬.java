import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	Set<String> list = new TreeSet<>(new Comparator<String>() {
    		
    		@Override
    		public int compare(String a, String b) {
    			if (a.length() == b.length()) {
        			return a.compareTo(b);
        		}
        		return Integer.compare(a.length(), b.length());
    		}
    	});
    	
    	for (int i = 0; i < N; i++) {
    		String input = br.readLine();
    		list.add(input);
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for (String out : list) {
    		sb.append(out).append("\n");
    	}
    	
    	System.out.println(sb);
    }
}