import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int T;
		T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			String[] split = in.readLine().split(" ");
			int M = Integer.parseInt(split[0]);
			int A = Integer.parseInt(split[1]);
			int[] moveA = new int[M];
			int[] moveB = new int[M];
			int ra = 1;
			int ca = 1;
			int rb = 10;
			int cb = 10;

			split = in.readLine().split(" ");
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(split[i]);
			}

			split = in.readLine().split(" ");
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(split[i]);
			}

			int[][][] charge = new int[11][11][A];
			int[][] deltas = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
			int sum = 0;

			for (int k = 0; k < A; k++) {
				split = in.readLine().split(" ");
				int c = Integer.parseInt(split[0]);
				int r = Integer.parseInt(split[1]);
				int range = Integer.parseInt(split[2]);
				int p = Integer.parseInt(split[3]);
				int w = 0;
				for (int i = r - range; i <= r + range; i++) {
					if (0 < i && i <= 10) {
						for (int j = 0; j <= w; j++) {
							if (0 < c - j) {
								charge[i][c - j][k] = p;
							}
							if (c + j <= 10) {
								charge[i][c + j][k] = p;
							}
						}
					}
					if(i<r) {
						w++;
					}else {
						w--;
					}
				}
			}
			int max1 = 0;
			int max2 = 0;
			for (int j = 0; j < A; j++) {
				if (max1 < charge[1][1][j]) {
					max1 = charge[1][1][j];
				}
				if (max2 < charge[10][10][j]) {
					max2 = charge[10][10][j];
				}
			}
			sum = max1 + max2;

			for (int i = 0; i < M; i++) {
				ra = ra + deltas[moveA[i]][0];
				ca = ca + deltas[moveA[i]][1];
				rb = rb + deltas[moveB[i]][0];
				cb = cb + deltas[moveB[i]][1];
				max1 = 0;
				max2 = 0;
				int max3 = 0;
				int idx1 = -2;
				int idx2 = -1;
				int save = 0;
				boolean check = false;
				
				for (int j = 0; j < A; j++) {
					if (charge[ra][ca][j] != 0) {
						idx1 = j;
					}
					if (charge[rb][cb][j] != 0) {
						idx2 = j;
					}
					if(idx1 == idx2) {
						check = true;
						if (max3 < charge[rb][cb][j]) {
							max3 = charge[rb][cb][j];
						}
						idx1 = -2;
						idx2 = -1;
					}
				}

				if (check) {
					for (int j = 0; j < A; j++) {
						if (charge[ra][ca][j] != max3) {
							if (charge[ra][ca][j] > max1) {
								max1 = charge[ra][ca][j];
							}
						}
						if (charge[rb][cb][j] != max3) {
							if (charge[rb][cb][j] > max2) {
								max2 = charge[rb][cb][j];
							}
						}

					}

					boolean check2 = false;
					if(max1 > max3 && max2 > max3) {
						check2 = true;
					}
					if(max1 < max2) {
						save = max2;
					}
					else {
						save = max1;
					}

					if (check2) {
						sum += (max1 + max2);
					}else {
						sum += (max3 + save);
					}
				}
				else {
					for (int j = 0; j < A; j++) {
						if (charge[ra][ca][j] > max1) {
							max1 = charge[ra][ca][j];
						}
						if (charge[rb][cb][j] > max2) {
							max2 = charge[rb][cb][j];
						}
					}

					sum += (max1 + max2);

				}

			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);


	}


}