import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       String input = br.readLine();
       int result = 0;
       int stack = 0;
       for (int i = 0; i < input.length(); i++) {
    	   if (input.charAt(i) == '(') {
    		   stack++;
    	   } else {
    		   stack--;
    		   
    		   if (input.charAt(i - 1) == '(') {
    			   result += stack;
    		   } else {
    			   result++;
    		   }
    	   }
       }
       
       System.out.println(result);
	}
}