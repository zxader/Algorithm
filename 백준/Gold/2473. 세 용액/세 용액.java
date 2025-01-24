import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        long sum = Long.MAX_VALUE;
        long[] result = new long[3];
        
        for (int i = 0; i < N - 2; i++) {
        	int start = i + 1;
        	int end = N - 1;
        	
        	while (start < end) {
        		long temp = arr[i] + arr[start] + arr[end];
        		
        		if (Math.abs(temp) < Math.abs(sum)) {
        			sum = temp;
        			result[0] = arr[i];
        			result[1] = arr[start];
        			result[2] = arr[end];
        		}
        		
        		if (temp > 0) {
        			end--;
        		}
        		else {
        			start++;
        		}
        	}
        }
        
        
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
	}
}