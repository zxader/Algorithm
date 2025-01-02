import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static int M;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int [N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	sum += arr[i];
        }
        
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        
        if (sum <= M) {
        	System.out.println(arr[N - 1]);
        }
        else {
        	int result = 0;
            
        	int start = 1;
        	int end = arr[N - 1];
        	
        	while (start <= end) {
        		int mid = (start + end) / 2;
        		int temp = 0;
        		for (int i = 0; i < N; i++) {
        			if (arr[i] <= mid) {
        				temp += arr[i];
        			}
        			else {
        				temp += mid;
        			}
        		}
        		
        		if (temp <= M) {
        			start = mid + 1;
        			result = mid;
        		}
        		else {
        			end = mid - 1;
        		}
        	}
        	System.out.println(result);
        }
    }
}