import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[] arr;
	static boolean[] target;
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	arr = new boolean[N];
    	String input = br.readLine();
    	for (int i = 0; i < input.length(); i++) {
    		if (input.charAt(i) == '1') {
    			arr[i] = true;
    		}
    	}
    	
    	input = br.readLine();
    	target = new boolean[N];
    	for (int i = 0; i < input.length(); i++) {
    		if (input.charAt(i) == '1') {
    			target[i] = true;
    		}
    	}
    	
    	int result = Math.min(solve(true), solve(false));
    	
    	System.out.println(result == Integer.MAX_VALUE ? - 1: result);
    }
    
    static int solve(boolean first) {
    	boolean[] copy = arr.clone();
    	int count = 0;
    	
    	if (first) {
    		change(0, copy);
    		count++;
    	}
    	
    	for (int i = 1; i < N; i++) {
    		if (copy[i - 1] != target[i - 1]) {
    			change(i, copy);
    			count++;
    		}
    	}
    	
    	for (int i = 0; i < N; i++) {
    		if (copy[i] != target[i]) return Integer.MAX_VALUE;
    	}
    	
    	return count;
    }
    
    static boolean isIn(int x) {
    	return 0 <= x && x < N;
    }
    
    static int[] deltas = {-1, 0, 1};
    
    static void change(int x, boolean[] arr) {
    	for (int d = 0; d < 3; d++) {
    		int dx = x + deltas[d];
    		if (isIn(dx)) {
    			arr[dx] = !arr[dx];
    		}
    	}
    }
}
