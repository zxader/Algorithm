import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	boolean[] arr = new boolean[15000];
    	
    	for (int i = 1; i <= 10000; i++) {
    		String temp = String.valueOf(i);
    		int sum = 0;
    		for (int j = 0; j < temp.length(); j++) {
    			sum += temp.charAt(j) - '0';
    		}
    		
    		sum += i;
    		arr[sum] = true;
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 1; i <= 10000; i++) {
    		if (!arr[i]) {
    			sb.append(i).append("\n");
    		}
    	}
    	System.out.println(sb);
    }
}