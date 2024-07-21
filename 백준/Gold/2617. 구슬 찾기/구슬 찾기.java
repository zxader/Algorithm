import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = -1;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) continue;
				for (int k = 1; k <= N; k++) {
					if (j == k) continue;
					if (map[j][i] == 0) continue;
					if (map[i][k] == 0) continue;
					if (map[j][i] == 1 && map[i][k] == 1) {
						map[j][k] = 1;
					}
					if (map[j][i] == -1 && map[i][k] == -1) {
						map[j][k] = -1;
					}
				}
			}
		}
		int result = 0;
		for (int i = 1; i <= N; i++) {
			int count1 = 0;
			int count2 = 0;
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 1) {
					count1++;
				}
				if (map[i][j] == -1) {
					count2++;
				}
			}
			if (count1 > N/2 || count2 > N/2) result++;
		}
		sb.append(result);
		System.out.println(sb);
	}
}