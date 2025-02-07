import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int T = Integer.parseInt(br.readLine());
       StringBuilder sb = new StringBuilder();
       
       for (int t = 1; t <= T; t++) {
    	   String P = br.readLine();
    	   int N = Integer.parseInt(br.readLine());
    	   int[] arr = new int[N];
    	   boolean[] visited = new boolean[N];
    	   
    	   String[] input = br.readLine().replaceAll("[\\[\\]]", "").split(",");
    	   
    	   for (int i = 0; i < N; i++) {
    		   arr[i] = Integer.parseInt(input[i]);
    	   }
    	   
    	   boolean isReversed = false;
    	   int size = arr.length;
    	   int start = 0;
    	   int end = N - 1;
    	   int idx = 0;
    	   boolean isError = false;
    	   for (int i = 0; i < P.length(); i++) {
    		   if (P.charAt(i) == 'R') {
    			   isReversed = !isReversed;
    			   if (isReversed) {
    				   start = idx;
    				   idx = end;
    			   }
    			   else {
    				   end = idx;
    				   idx = start;
    			   }
    		   }
    		   else {
    			   if (size <= 0) {
        			   sb.append("error");
        			   isError = true;
        			   break;
        		   }
    			   visited[idx] = true;
    			   size--;
    			   if (isReversed) {
    				   idx--;
    			   }
    			   else {
    				   idx++;
    			   }
    		   }
    	   }
    	   
    	   
    	   if (!isError) {
    		   List<Integer> list = new ArrayList<>();
    		   
    		   if (isReversed) {
    			   sb.append("[");
        		   for (int i = N - 1; i >= 0; i--) {
        			   if (visited[i]) continue;
        			   list.add(arr[i]);
        		   }
        	   }
    		   else {
    			   sb.append("[");
        		   for (int i = 0; i < N; i++) {
        			   if (visited[i]) continue;
        			   list.add(arr[i]);
        		   }
    		   }
    		   
    		   for (int i = 0; i < list.size() - 1; i++) {
    			   sb.append(list.get(i) + ",");
    		   }
    		   if (list.size() - 1 >= 0) {
    			   sb.append(list.get(list.size() - 1));
    		   }
    		   sb.append("]");
    	   }
    	   sb.append("\n");
       }
       System.out.println(sb);
	}
}