import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	int result = 0;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if (check(input)) {
				result++;
			}
    	}
    	
    	System.out.println(result);
	}
	
	static boolean check(String str) {
		Set<Character> set = new HashSet<>();
		set.add(str.charAt(0));
		
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i - 1) == str.charAt(i)) continue;
			if (set.contains(str.charAt(i))) return false;
			set.add(str.charAt(i));
		}
		
		return true;
	}
}
