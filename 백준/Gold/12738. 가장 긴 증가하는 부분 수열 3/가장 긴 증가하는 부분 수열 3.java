import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int size = 0;
		for (int i = 0; i < N; i++) {
			
			int idx = Arrays.binarySearch(dp, 0, size, arr[i]);
			if (idx >= 0) continue;
			
			idx = Math.abs(idx) - 1;
			dp[idx] = arr[i];
			
			if (idx == size) size++;
		}
		
		sb.append(size);
		System.out.println(sb);
	}
}