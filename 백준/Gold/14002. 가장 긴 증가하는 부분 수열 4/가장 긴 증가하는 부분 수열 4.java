import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dp = new int[N];
		int[] save = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> list = new ArrayList<>();
		int result = 1;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			save[i] = -1;
		}
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					save[i] = j;
				}
			}
			if(result < dp[i]) {
				idx = i;
				result = dp[i];
			}
		}
		while (true) {
			list.add(arr[idx]);
			idx = save[idx];
			if (idx == -1) break;
			if (save[idx] == -1) {
				list.add(arr[idx]);
				break;
			}
		}
		
		sb.append(result).append("\n");
		for (int i = list.size() - 1; i >= 0; i--) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);
	}
}