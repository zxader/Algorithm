
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int N;
	static int K;
	static int[][] arr;
	static int[][] list;
	public static void main(String[] args) throws Exception{
		sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][K + 1];
		list = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[i][0] = v;
			list[i][1] = w;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= K; w++) {
				if(list[i][1] > w) {
					arr[i][w] = arr[i - 1][w];
				}
				else {
					arr[i][w] = Math.max(list[i][0] + arr[i - 1][w - list[i][1]], arr[i-1][w]);
				}
			}
		}
		int result = arr[N][K];
		sb.append(result);
		System.out.println(sb);
	}
}
