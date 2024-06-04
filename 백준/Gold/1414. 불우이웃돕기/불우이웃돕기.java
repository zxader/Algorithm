import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int total = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = str.charAt(j);
				if(c == '0') {
					map[i][j] = 0;
				}
				else if('a' <= c && c <= 'z') {
					map[i][j] = c - 'a' + 1;
					total += map[i][j];
				}
				else {
					map[i][j] = c - 'A' + 27;
					total += map[i][j];
				}
			}
		}
		int[] minDis = new int[N];
		boolean[] visited = new boolean[N];
		Arrays.fill(minDis, Integer.MAX_VALUE);
		minDis[0] = 0;
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			for (int j = 0; j < N; j++) {
				if (!visited[j] && min > minDis[j]) {
					min = minDis[j];
					idx = j;
				}
				
			}
			if (idx == -1) {
				continue;
			}
			visited[idx] = true;
			sum += min;
			if (++cnt == N) {
				break;
			}
			for (int j = 0; j < N; j++) {
				if (map[idx][j] != 0 && minDis[j] > map[idx][j]) {
					minDis[j] = map[idx][j];
				}
				if (map[j][idx] != 0 && minDis[j] > map[j][idx]) {
					minDis[j] = map[j][idx];
				}
			}
		}
		
		if (cnt == N) {
			sb.append(total - sum);
		}
		else {
			sb.append(-1);
		}
		System.out.println(sb);
	}
}