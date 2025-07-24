import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] arr = new int[N];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int max = 0;
    	int[] fruit = new int[10];
    	int size = 0;
    	int total = 0;
    	
    	int start = 0;
    	int end = 0;
		while (start < N) {
			while (end < N && size <= 2) {
				if (fruit[arr[end]] == 0) {
					size++;
				}
				
				fruit[arr[end]]++;
				total++;
				end++;
				
				if (size > 2) break;
				
				max = Math.max(max, total);
			}
			
			fruit[arr[start]]--;
			if (fruit[arr[start]] == 0) {
				size--;
			}
			total--;
			start++;
		}
    	
		System.out.println(max);
	}
}
