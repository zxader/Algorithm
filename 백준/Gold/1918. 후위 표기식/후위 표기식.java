import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	System.out.println(solve(br.readLine()));
	}
	
	static String solve(String input) {
		StringBuilder str = new StringBuilder();
		Stack<Character> s = new Stack<>();
		
		for (int i = 0; i < input.length(); i++) {
			if ('A' <= input.charAt(i) && input.charAt(i) <= 'Z') {
				str.append(input.charAt(i));
			}
			else if (input.charAt(i) == '(') {
				s.push(input.charAt(i));
			}
			else if (input.charAt(i) == ')') {
				while (!s.isEmpty() && s.peek() != '(') {
					str.append(s.pop());
				}
				s.pop();
			}
			else {
				while (!s.isEmpty() && (order(s.peek()) >= order(input.charAt(i)))) {
					if (s.peek() == '(') break;
					str.append(s.pop());
				}
				s.push(input.charAt(i));
			}
		}
		
		while (!s.isEmpty()) {
			str.append(s.pop());
		}
		
		return str.toString();
	}
	
	static int order(char c) {
		if (c == '+' || c == '-') return 1;
		return 2;
	}
}	
