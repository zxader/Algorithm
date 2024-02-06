
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	private static StringBuilder sb = new StringBuilder();

	static int N;
	static int M;
	static int R;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] read = in.readLine().split(" ");

		N = Integer.parseInt(read[0]);
		M = Integer.parseInt(read[1]);
		R = Integer.parseInt(read[2]);

		int[][] map = new int[N][M];

		for(int r = 0; r < N; r++) {
			String[] readmap = in.readLine().split(" ");
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(readmap[c]);
			}
		}
		
		int count = Math.min(N, M) / 2;
		
		for(int i = 0; i < R; i++) {
			
			for(int j = 0; j < count; j++) {
				int startr = 0 + j;
				int startc = 0 + j;
				
				int endr = N - 1 - j;
				int endc = M - 1 - j;
				
				int temp = map[startr][startc];
				
				for(int k = startc; k < endc; k++) {
					map[startr][k] = map[startr][k + 1];
				}
				
				for(int k = startr; k < endr; k++) {
					map[k][endc] = map[k + 1][endc];
				}
				
				for(int k = endc; k > startr; k--) {
					map[endr][k] = map[endr][k - 1];
				}
				
				for(int k = endr; k > startr; k--) {
					map[k][startc] = map[k - 1][startc];
				}
				
				map[startr + 1][startc] = temp;
			}
		
		}

		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				sb.append(map[r][c] + " "); 
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
