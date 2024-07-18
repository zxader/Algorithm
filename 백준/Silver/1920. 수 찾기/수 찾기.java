import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			sb.append(binary(Integer.parseInt(st.nextToken()), 0, N - 1)).append("\n");
		}

		System.out.println(sb);
	}

	static int binary(int m, int start, int end) {
		int mid = (start + end)/2;
		if (start > end) {
			return 0;
		}
		else {
			if (arr[mid] == m) {
				return 1;
			}
			else if (arr[mid] > m) {
				return binary(m, start, mid - 1);
			}
			else {
				return binary(m, mid + 1, end );
			}

		}
	}
}