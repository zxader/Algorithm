import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static class Box implements Comparable<Box>{
		int no, l, h, w;

		public Box(int no, int l, int h, int w) {
			super();
			this.no = no;
			this.l = l;
			this.h = h;
			this.w = w;
		}

		@Override
		public int compareTo(Box o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}

		@Override
		public String toString() {
			return "Box [no=" + no + ", l=" + l + ", h=" + h + ", w=" + w + "]";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Box[] box = new Box[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			box[i] = new Box(i + 1, l, h, w);
		}
		Arrays.sort(box);
		List<Integer>[] list = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			list[i].add(box[i - 1].no);
		}
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dp[i] = box[i - 1].h;
			for (int j = 1; j <= i - 1; j++) {
				if (box[i - 1].l > box[j - 1].l && dp[i] < dp[j] + box[i - 1].h) {
					dp[i] = dp[j] + box[i - 1].h;
					list[i] = new ArrayList<>();
					list[i].add(box[i - 1].no);
					for (int k : list[j]) {
						list[i].add(k);
					}
				}
			}
		}
		
		int max = 0;
		int idx = -1;
		for (int i = 1; i <= N; i++) {
			if (max < dp[i]) {
				max = dp[i];
				idx = i;
			}
		}
		
		sb.append(list[idx].size()).append("\n");
		for (int i = list[idx].size() - 1; i >= 0; i--) {
			sb.append(list[idx].get(i)).append("\n");
		}
		System.out.println(sb);
	}
}