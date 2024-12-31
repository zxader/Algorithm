import java.util.*;
import java.io.*;

public class Main {
	static int K;
	static int N;
	static int[] arr;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        
        for (int i = 0; i < K; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        System.out.println(binarySerach());
    }
    
    
    static long binarySerach() {
    	long start = 0;
    	long end = Integer.MAX_VALUE;
    	long result = 1;
    	
    	while(start <= end) {
    		long mid = (start + end) / 2;
    		int value = 0;
    		
    		for (int i = 0; i < K; i++) {
    			value += arr[i]/mid;
    		}
    		
    		if (value >= N) {
    			start = mid + 1;
    			result = Math.max(result, mid);
    		}
    		else {
    			end = mid - 1;
    		}
    	}
    	
    	return result;
    }
}