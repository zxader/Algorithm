import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W];
        
        if (W == 1) {
            System.out.println(0);
            return;
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());    
        }
        
        int result = 0;
        for (int i = 0; i < W;) {
            int maxIdx = i;
            int max = -1;
            for (int j = i + 1; j < W; j++) {
                if (arr[i] <= arr[j]) {
                    max = arr[j];
                    maxIdx = j;
                    break;
                }
                
                if (max < arr[j]) {
                    max = arr[j];
                    maxIdx = j;
                }
            }
            
            int temp = Math.min(max, arr[i]);
            for (int j = i + 1; j < maxIdx; j++) {
                result += (temp - arr[j]);
            }
            
            if (i == maxIdx) {
                maxIdx++;
            }
            i = maxIdx;
        }        
        
        System.out.println(result);
	}
	
}