import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int N;
	static int M;
	static char[][] map;
	static int[][] deltas = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
	static boolean[][][] check;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String[] split = in.readLine().split(" ");

		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		map = new char[N][M];
		check = new boolean[N][M][64];
		Queue<Pos> q = new ArrayDeque<>();

		for (int r = 0; r < N; r++) {
			split = in.readLine().split("");
			for (int c = 0; c < M; c++) {
				map[r][c] = split[c].charAt(0);
				if(map[r][c] == '0') {
					q.offer(new Pos(r, c, 0, 0));
					check[r][c][0] = true;
				}
			}
		}

		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int dr = p.r + deltas[d][0];
				int dc = p.c + deltas[d][1];

				if(isIn(dr, dc) && !check[dr][dc][p.key]){
					if(map[dr][dc] == '.' || map[dr][dc] == '0' || map[dr][dc] == '1'|| "abcdef".indexOf(map[dr][dc]) >= 0  ){
						if (map[dr][dc] == 'a') {
							q.offer(new Pos(dr, dc, (p.key | 1 << 5), p.count + 1));
							check[dr][dc][(p.key | 1 << 5)] = true;
						}
						else if(map[dr][dc] == 'b') {
							q.offer(new Pos(dr, dc, (p.key | 1 << 4), p.count + 1));
							check[dr][dc][(p.key | 1 << 4)] = true;
						}
						else if(map[dr][dc] == 'c') {
							q.offer(new Pos(dr, dc, (p.key | 1 << 3), p.count + 1));
							check[dr][dc][(p.key | 1 << 3)] = true;
						}
						else if(map[dr][dc] == 'd') {
							q.offer(new Pos(dr, dc, (p.key | 1 << 2), p.count + 1));
							check[dr][dc][(p.key | 1 << 2)] = true;
						}
						else if(map[dr][dc] == 'e') {
							q.offer(new Pos(dr, dc, (p.key | 1 << 1), p.count + 1));
							check[dr][dc][(p.key | 1 << 1)] = true;
						}
						else if(map[dr][dc] == 'f') {
							q.offer(new Pos(dr, dc,(p.key | 1 << 0), p.count + 1));
							check[dr][dc][(p.key | 1 << 0)] = true;
						}
						else if(map[dr][dc] == '1') {
							if(min > p.count + 1) {
								min = p.count + 1;
							}
						}
						else {
							q.offer(new Pos(dr, dc, p.key, p.count + 1));
							check[dr][dc][p.key] = true;
						}
						
					}
					else {
						if ((map[dr][dc] == 'A' && (p.key & 1 << 5) != 0) 
								|| (map[dr][dc] == 'B' && (p.key & 1 << 4) != 0)
								|| (map[dr][dc] == 'C' && (p.key & 1 << 3) != 0)
								|| (map[dr][dc] == 'D' && (p.key & 1 << 2) != 0)
								|| (map[dr][dc] == 'E' && (p.key & 1 << 1) != 0)
								|| (map[dr][dc] == 'F' && (p.key & 1 << 0) != 0)
								){
							q.offer(new Pos(dr, dc, p.key, p.count + 1));
							check[dr][dc][p.key] = true;
						}
					}

				}
			}
		}
		
		if(min == Integer.MAX_VALUE) {
			sb.append(-1);
		}else {
			sb.append(min);
		}
		System.out.println(sb);
	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}

}

class Pos {
	int r;
	int c;
	int key;
	int count;

	public Pos(int r, int c, int key, int count) {
		super();
		this.r = r;
		this.c = c;
		this.key = key;
		this.count = count;
	}

	@Override
	public String toString() {
		return "Pos [r=" + r + ", c=" + c + ", key=" + key + ", count=" + count + "]";
	}
}