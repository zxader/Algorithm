import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int[] bag;
	static double max;
	static int maxNo;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		bag = new int[M + 1];
		int bagMax = 0;
		for (int i = 1; i <= M; i++) {
			bag[i] = Integer.parseInt(br.readLine());
			bagMax = Math.max(bagMax, bag[i]);
		}
		dp = new int[N + 1][bagMax + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= bagMax ; j++) {
				if (arr[i][0] > j) {
					dp[i][j] = dp[i - 1][j];
				}
				else {
					dp[i][j] = Math.max(arr[i][1] + dp[i - 1][j - arr[i][0]], dp[i - 1][j]);
				}
			}
		}
		max = 0.0;
		maxNo = 1;
		for (int i = 1; i <= M; i++) {
			result(i);
		}
		sb.append(maxNo);
		System.out.println(sb);
		
	}
	static void result(int no) {
		if (bag[no] == 0) {
			return;
		}
		double save = (double)dp[N][bag[no]]/(double)bag[no];
		if (save > max) {
			max = save;
			maxNo = no;
		}
	}
}