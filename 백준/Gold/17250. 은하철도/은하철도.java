import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] value;
	static int N;
	static int M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		value = new int[N + 1];
		make();
		for (int i = 1; i <= N; i++) {
			value[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(union(a,b)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void make() {
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
	}
	
	static int find(int a) {
		if (arr[a] == a) {
			return a;
		}
		
		return arr[a] = find(arr[a]);
	}
	
	static int union(int a, int b) {
		int A = find(a);
		int B = find(b);
		
		if (A == B) {
			return value[A];
		}
		arr[A] = B;
		value[B] += value[A];
		return value[B];
	}
}