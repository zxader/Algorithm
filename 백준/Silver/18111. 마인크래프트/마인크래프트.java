import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int B = Integer.parseInt(st.nextToken());
    	List<Integer> list = new ArrayList<>();
    	
    	int max = 0;
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < M; j++) {
    			int num = Integer.parseInt(st.nextToken());
    			list.add(num);
    			max = Math.max(max, num);
    		}
    	}
    	
    	int result = 0;
    	int resultTime = Integer.MAX_VALUE;
    	
    	for (int i = max; i >= 0; i--) {
    		int time = 0;
    		int temp = B;
    		
    		for (int j : list) {
    			if (i == j) continue;
    			int n = i - j;
    			if (n < 0) {
    				temp -= n;
    				time -= (2 * n);
    			}
    			else {
    				temp -= n;
    				time += n;
    			}
    		}
    		
    		if (temp >= 0 && resultTime > time) {
    			result = i;
    			resultTime = time;
    		}
    	}
    			
		System.out.println(resultTime + " " + result);
	}
	
}
