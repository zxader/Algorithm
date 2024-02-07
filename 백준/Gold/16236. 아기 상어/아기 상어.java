import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int N;
	static int[][] map;
	static int jsize = 2;
	static int jr;
	static int jc;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	static int size;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());

		map = new int[N][N];

		for(int r = 0; r < N; r++) {
			String[] str = in.readLine().split(" "); 
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(str[c]);

				if(map[r][c] == 9) {
					jr = r;
					jc = c;
				}
			}
		}
		
		int sum = 0;
		
		while(true) {
			int r = bfs();
			
			if(r == Integer.MAX_VALUE) {
				break;
			}
			
			if(jsize == size) {
				jsize++;
				size = 0;
			}
			
			sum += r;
		}
		
		sb.append(sum);
		System.out.println(sb);

	}


	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}

	static int bfs() {

		Queue<int[]> q = new ArrayDeque<>();

		int min = Integer.MAX_VALUE;
		int[][] check = new int[N][N];
		int count = 1;
		check[jr][jc] = 1;
		
		q.offer(new int[]{jr,jc});
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			while(--size >= 0) {
				int[] arr = q.poll();
				
				for(int d = 0; d < 4; d++) {
					int dr = arr[0] + deltas[d][0];
					int dc = arr[1] + deltas[d][1];

					if(isIn(dr,dc) && map[dr][dc] <= jsize && check[dr][dc] == 0) {
						q.offer(new int[] {dr,dc});
						check[dr][dc] = count;
					}
				}
			}
			count++;
		}
		
		int checkr = -1;
		int checkc = -1;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				
				if(map[r][c] < jsize && map[r][c] != 0 && check[r][c] != 0) {
					
					if(check[r][c] < min) {
						min = check[r][c];
						checkr = r;
						checkc = c;
					}
				}
			}
		}
		
		if(checkr >=0) {
			map[checkr][checkc] = 0;
			map[jr][jc] = 0;
			jr = checkr;
			jc = checkc;
			size++;
		}
		
		return min;
	}
}