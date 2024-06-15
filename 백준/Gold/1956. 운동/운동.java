import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] arr = new int[V + 1][V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			arr[from][to] = value;
		}
		
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 10000001;
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				for (int k = 1; k <= V; k++) {
					if (arr[j][i] + arr[i][k] < arr[j][k]) {
						arr[j][k] = arr[j][i] + arr[i][k];
					}
				}
			}
		}
		int result = 10000001;
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i == j && arr[i][j] < result) {
					result = arr[i][j];
				}
			}
		}
		if (result == 10000001) {
			result = -1;
		}
		sb.append(result);
		System.out.println(sb);
	}
}