import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + k - 1];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for (int i = N; i < N + k -1; i++) {
            arr[i] = arr[i - N];    
        }
        
        int[] count = new int[d + 1];
        count[c] = 1;
        
        int result = 1;
        for (int i = 0; i < k; i++) {
            count[arr[i]]++;        
            if (count[arr[i]] == 1) result++;
        }        
        
        int max = result;
        int start = 0;
        for (int i = k; i < N + k - 1; i++) {
            count[arr[start]]--;
            if (count[arr[start]] == 0) result--;
            start++;
            
            count[arr[i]]++;
            if (count[arr[i]] == 1) result++;
            
            max = Math.max(max, result);
        }
        
        System.out.println(max);
	}
}