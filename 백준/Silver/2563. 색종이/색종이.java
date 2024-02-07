

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[100][100];
		
		int N = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < N; i++) {
			String[] read = in.readLine().split(" ");
			int dc = Integer.parseInt(read[0]);
			int dr = Integer.parseInt(read[1]);
			for (int r = 99 - dr ; r > 99 - dr - 10; r --) {
				for (int c = dc; c < dc + 10; c++) {
					if (0 <= r && r < 100 && 0 <= c && c <= 100) {
						map[r][c] = 1;
					}						
				}
			}
		}
		
		int count = 0;
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				if (map[r][c] == 1) {
					count++;
				}
			}
		}
		sb.append(count);
		System.out.println(sb);
	}
}
