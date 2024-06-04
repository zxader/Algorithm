import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class SCV {
		int hp1;
		int hp2;
		int hp3;
		int time;

		public SCV(int hp1, int hp2, int hp3, int time) {
			super();
			this.hp1 = hp1;
			this.hp2 = hp2;
			this.hp3 = hp3;
			this.time = time;
		}


		@Override
		public String toString() {
			return "SCV [hp1=" + hp1 + ", hp2=" + hp2 + ", hp3=" + hp3 + ", time=" + time + "]";
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		boolean[][][] check = new boolean[61][61][61];

		Queue<SCV> q = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		if (N == 3) {
			q.offer(new SCV(Integer.parseInt( st.nextToken()),Integer.parseInt( st.nextToken()),Integer.parseInt( st.nextToken()),0));
		}
		else if (N == 2) {
			q.offer(new SCV(Integer.parseInt( st.nextToken()),Integer.parseInt( st.nextToken()),0,0));
		}
		else {
			q.offer(new SCV(Integer.parseInt( st.nextToken()),0, 0,0));

		}
		int[][] deltas = { {9,3,1},{9,1,3},{3,9,1},{1,9,3},{1,3,9},{3,1,9} };
		int cnt = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			SCV scv = q.poll();
			if (scv.hp1 <= 0 && scv.hp2 <= 0 && scv.hp3 <= 0) {
				cnt =  scv.time;
				break;
			}
			for (int d = 0; d < 6; d++) {
				int h1 = scv.hp1 - deltas[d][0];
				int h2 = scv.hp2 - deltas[d][1];
				int h3 = scv.hp3 - deltas[d][2];
				if (h1 < 0) {
					h1 = 0;
				}
				if (h2 < 0) {
					h2 = 0;
				}
				if (h3 < 0) {
					h3 = 0;
				}
				if (!check[h1][h2][h3]) {
					check[h1][h2][h3] = true;
					q.offer(new SCV(h1, h2, h3, scv.time + 1));
				}
			}
		}
		sb.append(cnt);
		System.out.println(sb);
	}
}