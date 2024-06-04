import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static StringBuilder sb;
	static char[][] map;
	static int[][] deltas = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	static Position[] result;
	static int sum;
	
	static class Position{
		int r;
		int c;
		public Position(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Position [r=" + r + ", c=" + c + "]";
		}
	}
	static Position[] p;
	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		p = new Position[25];
		result = new Position[7];
		int idx = 0;
		sum = 0;
		for (int i = 0; i < 5; i++) {
			String str = in.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = str.charAt(j);
				p[idx++] = new Position(i,j);
			}
		}
		comb(0,0);
		sb.append(sum);
		System.out.println(sum);
	}

	// 조합으로 7명 뽑기
	static void comb(int cnt, int start) {
		if(cnt == 7) {
			
			// 인접 여부 확인
			Queue<Position> q = new ArrayDeque<>();
			boolean[] used = new boolean[7];
			q.offer(result[0]);
			used[0] = true;
			int count = 1;
			int cY = 0;
			while(!q.isEmpty()) {
				Position p = q.poll();
				if(map[p.r][p.c] == 'Y') {
					cY++;
				}
				for (int i = 1; i < result.length; i++) {
					if (used[i]) continue;
					int r = result[i].r;
					int c = result[i].c;
					for (int d = 0; d < 4; d++) {
						int dr = p.r + deltas[d][0];
						int dc = p.c + deltas[d][1];
						if(dr == r && dc == c) {
							used[i] = true;
							count++;
							q.offer(result[i]);
							break;
						}
					}
				}
			}
			
			// Y가 4개이상이면 조건 불만족하여 리턴
			if(cY > 3) return;
			
			// 조건 만족시 경우의 수 증가
			if(count == 7) {
				sum++;
			}
			return;
		}
		for (int i = start; i < 25; i++) {
			result[cnt] = p[i];
			comb(cnt + 1, i + 1);
		}
	}
	static boolean isIn(int r, int c) {
		return 0 <= r && r < 5 && 0 <= c && c < 5;
	}
}