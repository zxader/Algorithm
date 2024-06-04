import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Main {
	static int R;
	static int C;
	static int[][] map;
	static boolean[][] check;
	static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String[] split = in.readLine().split(" ");
		R = Integer.parseInt(split[0]);
		C= Integer.parseInt(split[1]);
		map = new int[R][C];
		Queue<Position> q = new ArrayDeque<>();
		int count = 0;
		for (int r = 0; r < R; r++) {
			split =in.readLine().split(" ");
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(split[c]);
				if(map[r][c] == 1) {
					count++;
				}
			}
		}
		int result = 0;
		int startr = 0;
		int startc = 0;
		int count2 = 0;
		while(true) {
			check = new boolean[R][C];
			q.offer(new Position(startr, startc));
			check[startr][startc] = true;
			count2 = count;
			while(!q.isEmpty()) {
				Position p = q.poll();

				for (int d = 0; d < 4; d++) {
					int dr = p.r + deltas[d][0];
					int dc = p.c + deltas[d][1];
					if(isIn(dr, dc) && !check[dr][dc]) {
						if(map[dr][dc] == 1) {
							map[dr][dc] = 0;
							startr = dr;
							startc = dc;
							check[dr][dc] = true;
							count--;
						}
						else {
							q.offer(new Position(dr, dc));
							check[dr][dc] = true;
						}
					}
				}
			}
			result++;
			if(count == 0) {
				break;
			}
			
		}
		sb.append(result).append("\n").append(count2).append("\n");
		System.out.println(sb);
		

	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}
}

class Position{
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