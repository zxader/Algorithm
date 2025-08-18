import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	String[] arr = new String[N];
    	int[] count = new int[26];
    	
    	for (int i = 0; i < N; i++) {
    		String input = br.readLine();
    		arr[i] = input;
    		
    		for (int j = 0; j < input.length(); j++) {
    			int c = input.charAt(j) - '0' - 17;
    			count[c] += Math.pow(10, input.length() - 1 - j);
    		}
    	}
    	
    	int[] visited = new int[26];
    	for (int i = 9; i >= 0; i--) {
    		int max = 0;
    		int c = -1;
    		
    		for (int j = 0; j < 26; j++) {
    			if (visited[j] != 0) continue;
    			if (max < count[j]) {
    				max = count[j];
    				c = j;
    			}
    		}
    		
    		if (c != -1) {
    			visited[c] = i;
    		}
    	}
    	
    	
    	int result = 0;
    	for (int i = 0; i < N; i++) {
    		int num = 0;
    		
    		for (int j = 0; j < arr[i].length(); j++) {
    			int c = visited[arr[i].charAt(j) - '0' - 17];
    			num *= 10;
    			num += c;
    		}
    		
    		result += num;
    	}
    	
    	System.out.println(result);
	}
}