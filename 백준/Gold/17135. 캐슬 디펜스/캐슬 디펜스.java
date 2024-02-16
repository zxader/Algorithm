import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int M;
	static int D;
	static int[][] map;
	static boolean check;
	static int[] num;
	static int max = Integer.MIN_VALUE;
	static boolean[] check2;
	static boolean check3;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String[] split = in.readLine().split(" ");

		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		D = Integer.parseInt(split[2]);
		map = new int[N + 1][M];

		num = new int[3];

		// map입력
		for (int r = 0; r < N; r++) {
			split = in.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(split[c]);
			}
		}

		cmb(0, 0);
		sb.append(max);
		System.out.println(sb);
	}

	static int move(int[][] map, int[] num) {
		int count = 0;
		check2 = new boolean[3];
		check3 = false;
		check = false;
		int rdx1 = -1;
		int rdx2 = -1;
		int rdx3 = -1;
		int cdx1 = -1;
		int cdx2 = -1;
		int cdx3 = -1;
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		int min3 = Integer.MAX_VALUE;
		for (int c = 0; c < M; c++) {
		for (int r = N - 1; r >= 0; r--) {
				if(min1 > (Math.abs(num[0] - c) + Math.abs(N - r)) && (Math.abs(num[0] - c) + Math.abs(N - r) ) <= D  && map[r][c] == 1) {
					min1 = (Math.abs(num[0] - c) + Math.abs(N - r));
					check2[0] = true;
					rdx1 = r;
					cdx1 = c;
				}
				if(min2 > (Math.abs(num[1] - c) + Math.abs(N - r)) &&(Math.abs(num[1] - c) + Math.abs(N - r) ) <= D  && map[r][c] == 1) {
					min2 = (Math.abs(num[1] - c) + Math.abs(N - r));
					check2[1] = true;
					rdx2 = r;
					cdx2 = c;
				}
				if(min3 > (Math.abs(num[2] - c) + Math.abs(N - r)) &&(Math.abs(num[2] - c) + Math.abs(N - r) ) <= D && map[r][c] == 1) {
					min3 = (Math.abs(num[2] - c) + Math.abs(N - r));
					check2[2] = true;
					rdx3 = r;
					cdx3 = c;
				}
			}
		}
		if(check2[0]) {
			if(map[rdx1][cdx1] == 1) {
				map[rdx1][cdx1] = 0;
				count++;
			}
		}
		if(check2[1]) {
			if(map[rdx2][cdx2] == 1) {
				map[rdx2][cdx2] = 0;
				count++;
			}
		}
		if(check2[2]) {
			if(map[rdx3][cdx3] == 1) {
				map[rdx3][cdx3] = 0;
				count++;
			}
		}
		for (int r = N - 1; r > 0; r--) {
			for (int c = 0; c < M; c++) {
				map[r][c] = map[r - 1][c];
				map[r - 1][c] = 0;
				
			}
		}
		for (int r = N - 1; r >= 0; r--) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 1) {
					check3 = true;
				}
			}
		}
		return count;
	}

	static void cmb(int cnt, int start) {
		if (cnt == 3) {
			check = false;
			int[][] copy = new int[N][M];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					copy[r][c] = map[r][c];
				}
			}
			int sum = 0;
			while (true) {
				sum += move(copy, num);
				if (!check3) {
					break;
				}
			}
			if(sum > max) {
				max = sum;
			}
			return;
		}

		for (int i = start; i < M; i++) {
			num[cnt] = i;
			cmb(cnt + 1, i + 1);
		}
	}
}