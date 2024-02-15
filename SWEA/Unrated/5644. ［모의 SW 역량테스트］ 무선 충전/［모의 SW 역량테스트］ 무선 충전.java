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
			
			// A이동 입력
			split = in.readLine().split(" ");
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(split[i]);
			}
			
			// B이동 입력
			split = in.readLine().split(" ");
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(split[i]);
			}
			
			
			int[][][] charge = new int[11][11][A]; // 배터리 3차원 배열
			int[][] deltas = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 이동을 위한 배열
			int sum = 0;
			
			// 배터리 3차원 배열에 담기
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
			
			// 0초일 때 배터리있는지 확인하고 있으면 더하기
			for (int j = 0; j < A; j++) {
				if (max1 < charge[1][1][j]) {
					max1 = charge[1][1][j];
				}
				if (max2 < charge[10][10][j]) {
					max2 = charge[10][10][j];
				}
			}
			sum = max1 + max2;
			
			// M초 동안 이동
			for (int i = 0; i < M; i++) {
				ra = ra + deltas[moveA[i]][0];
				ca = ca + deltas[moveA[i]][1];
				rb = rb + deltas[moveB[i]][0];
				cb = cb + deltas[moveB[i]][1];
				max1 = 0; // A가 배터리 범위에 있을 때 최댓값 저장
				max2 = 0; // B가 배터리 범위에 있을 때 최댓값 저장
				int max3 = 0; // A, B가 같은 배터리 범위에 있을 때 최댓값 저장
				int idx1 = -2; // A의 위치에서 배터리가 있을 떄 인덱스값 저장
				int idx2 = -1; // B의 위치에서 배터리가 있을 떄 인덱스값 저장
				int save = 0; // max1, max2 중에 큰 값 저장
				boolean check = false; // 겹치는 배터리 있는지 확인을 위한 check
				
				// A,B가 겹치는 배터리 있는지 확인
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
				
				// A, B가 같은 배터리 범위에 있을 때
				if (check) {
					
					// 공유하는 배터리값이 아닌 최댓값 각각 저장
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

					// 공유하는 값이 공유하지않는 배터리값들보다 작을 때 체크
					boolean check2 = false; 
					if(max1 > max3 && max2 > max3) {
						check2 = true;
					}
					
					// max1, max2 중에 큰 값 저장
					if(max1 < max2) {
						save = max2;
					}
					else {
						save = max1;
					}
					
					// 공유하는 값이 공유하지않는 배터리값들보다 작을 때 
					if (check2) {
						sum += (max1 + max2);
					}else {
						sum += (max3 + save);
					}
				}
				// A, B가 같은 배터리 범위내에 없을 때
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