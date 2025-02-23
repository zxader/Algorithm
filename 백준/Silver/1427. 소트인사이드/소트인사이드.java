import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String input = br.readLine();
    	List<Integer> list = new ArrayList<>();
    	
    	for (int i = 0; i < input.length(); i++) {
    		list.add(input.charAt(i) - '0');
    	}
    
    	Collections.sort(list, Comparator.reverseOrder());
    	
    	String output = "";
    	for (int i : list) {
    		output += i;
    	}
    	
    	System.out.println(output);
    }
}