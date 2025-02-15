import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int M = Integer.parseInt(st.nextToken());
    	int N = Integer.parseInt(st.nextToken());
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = M; i <= N; i++) {
    		if (check(i)) {
    			sb.append(i).append("\n");
    		}
    	}
    	
    	System.out.println(sb);
    }
    
    static boolean check(int num) {
    	if (num < 2) return false;
    	
    	for (int i = 2; i <= Math.sqrt(num); i++) {
    		if (num % i == 0) return false;
    	}
    	
    	return true;
    }
}