
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

	private static StringBuilder sb = new StringBuilder();
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] read = in.readLine().split(" ");

		int N = Integer.parseInt(read[0]);
		int M = Integer.parseInt(read[1]);
		int R = Integer.parseInt(read[2]);

		int[][] map = new int[N][M];

		for (int r = 0; r < N; r++) {
			String[] readmap = in.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(readmap[c]);
			}
		}

		String[] readr = in.readLine().split(" ");

		for (int r = 0; r < R; r++) {

			int[][] result = new int[M][N];
			int[][] result1 = new int[N][M];
			int temp = N;
			int midN = N / 2;
			int midM = M / 2;
			int row = 0;
			
			switch (Integer.parseInt(readr[r])) {
			case 1:


				for (int i = 0; i < N; i++) {
					for (int j = 0; j <M; j++) {
						result1[N-1-i][j] = map[i][j];
					}
				}

				map = result1;
				break;
			case 2:

				for (int i = 0; i < N; i++) {
					for (int j = 0; j <M; j++) {
						result1[i][M-1-j] = map[i][j];
					}
				}

				map = result1;
				
				break;
			case 3:
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						result[j][N-1-i] = map[i][j];
					}
				}
				
				N = M;
				M = temp;
				
				map = result;
				break;
			case 4:
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						result[M-1-j][i] = map[i][j];
					}
				}
				
				N = M;
				M = temp;
				map = result;
				
				break;
			case 5:
				
				for (int i = 0; i < midN; i++) {
					for (int j = 0; j < midM; j++) {
						result1[i][midM + j] = map[i][j];
					}
				}
				
				for (int i = 0; i < midN; i++) {
					for (int j = midM; j < M; j++) {
						result1[midN + i][j] = map[i][j];
					}
				}
				
				for (int i = midN; i < N; i++) {
					int col = 0;
					for (int j = midM; j < M; j++, col++) {
						result1[i][col] = map[i][j];
					}
				}
				
				for (int i = midN; i < N; i++, row++) {
					for (int j = 0; j < midM; j++) {
						result1[row][j] = map[i][j];
					}
				}
				
				map = result1;
				break;
			case 6:
				for (int i = 0; i < midN; i++) {
					for (int j = 0; j < midM; j++) {
						result1[midN + i][j] = map[i][j];
					}
				}
				
				for (int i = midN; i < N; i++) {
					for (int j = 0; j < midM; j++) {
						result1[i][midM + j] = map[i][j];
					}
				}
				
				for (int i = midN; i < N; i++, row++) {
					for (int j =  midM; j < M; j++) {
						result1[row][j] = map[i][j];
					}
				}
				for (int i = 0; i < midN; i++) {
					int col = 0;
					for (int j = midM; j < M; j++, col++) {
						result1[i][col] = map[i][j];
					}
				}
				
				map = result1;
				break;
			}

		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				sb.append(map[r][c] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}



}
