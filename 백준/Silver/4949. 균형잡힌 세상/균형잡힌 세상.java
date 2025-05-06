import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringBuilder sb = new StringBuilder();
    	String input = br.readLine();
    	while (input.charAt(0) != '.') {
    		sb.append(check(input)).append("\n");
    		input = br.readLine();
    	}
    	
    	System.out.println(sb);
	}
	
	static String check(String str) {
		Stack<Character> s = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '[' || str.charAt(i) == '(') {
				s.add(str.charAt(i));
			}
			else if (str.charAt(i) == ']' && (s.isEmpty() || s.pop() != '[')) {
				return "no";
			}
			else if (str.charAt(i) == ')' && (s.isEmpty() || s.pop() != '(')) {
				return "no";
			}
		}
		if (!s.isEmpty()) return "no";
		return "yes";
	}
	
}
