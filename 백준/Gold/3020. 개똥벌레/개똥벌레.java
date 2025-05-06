import java.io.*;
import java.util.*;

public class Main {
	static int N, H;
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	H = Integer.parseInt(st.nextToken());
    	List<Integer> list1 = new ArrayList<>();
    	List<Integer> list2 = new ArrayList<>();
    	
    	for (int i = 0; i < N; i++) {
    		int num = Integer.parseInt(br.readLine());
    		if (i % 2 == 0) {
    			list1.add(num);
    		}
    		else {
    			list2.add(num);
    		}
    	}
    	Collections.sort(list1);
    	Collections.sort(list2);
    	int result = Integer.MAX_VALUE;
    	int cnt = 0;
    	
    	for (int i = 1; i <= H; i++) {
    		int sum = search(i, list1) + search(H - i + 1, list2);
    		
    		if (result > sum) {
    			result = sum;
    			cnt = 1;
    		}
    		else if(result == sum) {
    			cnt++;
    		}
    	}
    	
    	System.out.println(result + " " + cnt);
	}
	
	static int search(int num, List<Integer> list) {
		int start = 0;
		int end = list.size() - 1;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			
			if (list.get(mid) < num) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		
		return list.size() - start;
	}
}
