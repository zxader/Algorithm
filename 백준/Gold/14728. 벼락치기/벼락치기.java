import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[] K = new int[N + 1];
		int[] S = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			K[i] = Integer.parseInt(st.nextToken());
			S[i] = Integer.parseInt(st.nextToken());
		}
		int[][] D = new int[N + 1][T + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int k = 1; k <= T; k++) {
				
				if (K[i] <= k) {
					D[i][k] = Math.max(D[i - 1][k], S[i] + D[i - 1][k - K[i]]);
				}
				else {
					D[i][k] = D[i - 1][k];
				}
			}
		}
		sb.append(D[N][T]);
		System.out.println(sb);
	}
}