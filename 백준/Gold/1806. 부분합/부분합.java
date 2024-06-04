import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] dp = new int[N];
		st = new StringTokenizer(in.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i==0) {
				dp[i] = arr[i];
			}
			else {
				dp[i] = dp[i - 1] + arr[i];
			}
		}
		int min = Integer.MAX_VALUE;
		int l = 0;
		for(int i = 0; i < N;) {
			int sum = 0;
			if(i == 0) {
				sum = dp[l];
			}
			else {
				sum = dp[l] - dp[i - 1];
			}					
			if(sum >= S ) {
				if(min > l - i + 1) {
					min = l - i + 1;
				}
				i++;
			}else {
				if(l < N - 1) {
					l++;
				}
				else {
					i++;
				}
			}
		}
		if(min==Integer.MAX_VALUE) {
			min = 0;
		}
		sb.append(min);
		System.out.println(sb);
	}
}