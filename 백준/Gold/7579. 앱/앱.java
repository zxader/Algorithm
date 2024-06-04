
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int N;
	static int C;
	static int[][] arr;
	static int[][] list;

	public static void main(String[] args) throws Exception{
		sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][10000 + 1];
		list = new int[N + 1][2];


		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			int v = Integer.parseInt(st.nextToken());
			list[i][0] = v;
		}
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			int w = Integer.parseInt(st.nextToken());
			list[i][1] = w;
		}

		for (int i = 1; i <= N; i++) {
			for (int w = 0; w <= 10000; w++) {
				if(list[i][1] > w) {
					arr[i][w] = arr[i - 1][w];
				}
				else {
					arr[i][w] = Math.max(list[i][0] + arr[i - 1][w - list[i][1]], arr[i-1][w]);
				}
			}
		}
		int result = 0;
		loop :
			for (int w = 0; w <= 10000; w++) {
				for (int i = 1; i <= N; i++) {
					if (arr[i][w] >= C) {
						result = w;
						break loop;
					}
				}
			}
		if (C == 0) {
			
		}
		sb.append(result);
		System.out.println(sb);

	}
}
