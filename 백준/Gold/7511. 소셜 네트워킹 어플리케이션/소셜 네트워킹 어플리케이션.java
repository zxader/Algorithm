import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static int K;
	static int M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("Scenario " + t +":").append("\n");
			N = Integer.parseInt(br.readLine());
			K= Integer.parseInt(br.readLine());
			make();
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(union1(a, b)) {
					sb.append(0).append("\n");
				}
				else {
					sb.append(1).append("\n");
				}
			}
			sb.append("\n");
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

	static boolean union(int a, int b) {
		int A = find(a);
		int B = find(b);
		if(A == B) {
			return false;
		}
		arr[B] = A;
		return true;
	}
	static boolean union1(int a, int b) {
		int A = find(a);
		int B = find(b);
		if(A == B) {
			return false;
		}
		return true;
	}
}