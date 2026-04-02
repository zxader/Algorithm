import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[] dp = new int[D + 1];
        for (int i = 0; i <= D; i++) {
            dp[i] = i;
        }
        
        List<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            
            
            list.add(new int[] {start, end, l});    
        }
        
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        
        for (int i = 0; i < N; i++) {
            int start = list.get(i)[0];
            int end = list.get(i)[1];
            int l = list.get(i)[2];
            
            if (end > D) continue;
            if (dp[end] > dp[start] + l) {
                dp[end] = dp[start] + l;
                
                for (int j = end + 1; j <= D; j++) {
                    dp[j] = Math.min(dp[j], dp[end] + j - end);
                }
            }
            
        }
        
        System.out.println(dp[D]);
	}
}