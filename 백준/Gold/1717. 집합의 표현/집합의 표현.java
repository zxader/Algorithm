import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		make();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (num == 0) {
				union(a, b);
			}
			else {
				if (find(a) == find(b)) {
					sb.append("YES").append("\n");
				}
				else {
					sb.append("NO").append("\n");
				}
			}
		}
		System.out.println(sb);
	}
	
	public static void make() {
		arr = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			arr[i] = i;
		}
	}
	
	public static int find(int a) {
		if (arr[a] == a) {
			return a;
		}
		return arr[a] = find(arr[a]);
		
	}
	public static boolean union(int a, int b) {
		int A = find(a);
		int B = find(b);
		if (A == B) {
			return false;
		}
		arr[B] = A;
		return true;
	}
}