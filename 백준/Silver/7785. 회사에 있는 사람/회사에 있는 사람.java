import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       
       Set<String> set = new TreeSet<>(Comparator.reverseOrder());
       
       for (int i = 0; i < N; i++) {
    	   StringTokenizer st = new StringTokenizer(br.readLine());
    	   String name = st.nextToken();
    	   String log = st.nextToken();
    	   if (log.equals("enter")) {
    		   set.add(name);
    	   }
    	   else {
    		   set.remove(name);
    	   }
       }
       
       StringBuilder sb = new StringBuilder();
       for (String result : set) {
    	   sb.append(result).append("\n");
       }
       
       System.out.println(sb);
	}
}