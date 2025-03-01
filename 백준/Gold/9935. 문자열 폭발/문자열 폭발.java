import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String input = br.readLine();
    	String boom = br.readLine();

    	StringBuilder sb = new StringBuilder();
    	int length = boom.length();
    	
    	for (char ch : input.toCharArray()) {
    		sb.append(ch);
    		
    		
    		if (sb.length() >= length &&
    				sb.substring(sb.length() - length).equals(boom)) {
    			sb.delete(sb.length() - length, sb.length());
    		}
    	}
    	
    	System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}