import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static int result;
	static int leftResult;
	static int rightResult;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        result = Integer.MAX_VALUE;
        leftResult = 0;
        rightResult = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        twoPointer();
        
        System.out.println(leftResult + " " + rightResult);
    }
    
    static void twoPointer() {
    	int left = 0;
    	int right = N - 1;
    	
    	while (left < right) {
    		int value = arr[left] + arr[right];
    		
    		if (Math.abs(value) < result) {
    			result = Math.abs(value);
    			leftResult = arr[left];
    			rightResult = arr[right];
    		}
    		
    		if (value < 0) left++;
    		else right--;
    	}
    }
}