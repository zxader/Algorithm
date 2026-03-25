import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		
		for (int i = 2; i <= N; i++) {
		    boolean checked = false;
		    for (int j = 2; j <= Math.sqrt(i); j++) {
		        if (i % j == 0) {
		            checked = true;
		            break;
		        }
		    }
		    
		    if (!checked) list.add(i);
		}
		
		int sum = 0;
		int result = 0;
		int left = 0;
		int right = 0;
	    while (right < list.size()) {
	        
	        sum += list.get(right);
            right++;
            
	        while (sum > N) {
	            sum -= list.get(left);
	            left++;
	        }
	        
            if (sum == N) result++;
            
	    }
	    
	    System.out.println(result);
	}
}