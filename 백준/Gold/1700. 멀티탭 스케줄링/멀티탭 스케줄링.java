import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	int[] arr = new int[K];
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < K; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int result = 0;
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	for (int i = 0; i < K; i++) {
    		if (!map.containsKey(arr[i]) && map.size() >= N) {
    			int temp = 0;
    			int key = -1;
    			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    				if (temp < entry.getValue()) {
    					temp = entry.getValue();
    					key = entry.getKey();
    				}
    			}
    			
    			map.remove(key);
    			result++;
    		}
    		
    		int temp = 101;
			for (int j = i + 1; j < K; j++) {
				if (arr[i] == arr[j]) {
					temp = j;
					break;
				}
			}
			
			map.put(arr[i], temp);
    	}
    	
    	System.out.println(result);
	}
	
}	
