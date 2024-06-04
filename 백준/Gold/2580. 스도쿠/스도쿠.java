import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] check;
	static int[][] map;
	static StringBuilder sb;
	static boolean resultcheck;
	static ArrayList<Integer>[] list;
	static int length;
	static int[][] check1;
	static ArrayList<Position> p;
	static class Position{
		int r;
		int c;
		public Position(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		map = new int[9][9];
		list = new ArrayList[9];
		p = new ArrayList<>();
		length = 0;
		for (int i = 0 ; i < 9; i++) {
			list[i] = new ArrayList<>();
		}
		check1 = new int[9][10];

		for (int r = 0; r < 9; r++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int c = 0; c < 9; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				check1[r][map[r][c]]++;
				if(map[r][c] == 0) {
					length++;
					p.add(new Position(r, c));
				}
			}

			for(int i = 1; i < 10; i++) {
				if(check1[r][i] == 0) {
					list[r].add(i);
				}
			}
		}
		check = new boolean[9][10];
		resultcheck = false;
		Perm(0, 0, 0);

		System.out.println(sb);
	}

	static void Perm(int cnt, int l, int idx) {
		if (resultcheck) {
			return;
		}
		if (cnt == list[l].size()){
			if(idx == length) {
				resultcheck = true;
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						sb.append(map[i][j] + " ");
					}
					sb.append("\n");
				}
				return;
			}
			Perm(0, l + 1, idx);
			return;
		}

		for (int i = 0; i < list[l].size(); i++) {
			if(check[l][list[l].get(i)]) continue;
			map[p.get(idx).r][p.get(idx).c] = list[l].get(i);
			check[l][list[l].get(i)] = true;
			if(result(p.get(idx).r, p.get(idx).c)) {
				Perm(cnt + 1, l, idx + 1);
			}
			map[p.get(idx).r][p.get(idx).c] = 0;
			check[l][list[l].get(i)] = false;
		}
	}

	static boolean result(int x, int y) {
//		for (int r = x; r < 9; r++) {
			int[] arr1 = new int[10];
			int[] arr2 = new int[10];
			for (int c = 0; c < 9; c++) {
				arr1[map[x][c]]++;
				arr2[map[c][y]]++;
				if (arr1[map[x][c]] > 1 && map[x][c] != 0) {
					return false;
				}
				if (arr2[map[c][y]] > 1 && map[c][y] != 0) {
					return false;
				}
			}
//		}
		for (int r = 0; r <= 6; r += 3) {
			for (int c = 0; c <= 6; c += 3) {
				int[] arr3 = new int[10];
				for (int i = r; i < 3 + r; i++) {
					for (int j = c; j < 3 + c; j++) {
						arr3[map[i][j]]++;
						if(arr3[map[i][j]] > 1 && map[i][j] != 0) {
							return false;
						}
					}
				}

			}
		}
		return true;
	}
}