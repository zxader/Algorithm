

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		int[] top = new int[N];

		String[] read = in.readLine().split(" ");
		int[] result = new int[N];
		Stack<Integer> q = new Stack<>();
		Stack<Integer> qidx = new Stack<>();

		for(int i = 0; i < N; i++) {
			top[i] = Integer.parseInt(read[i]);
		}
		result[0] = 0;

		q.add(top[N-1]);
		qidx.add(N-1);
		
		for(int i = N-2; i >= 0; i--) {
			while(!q.isEmpty() && q.peek() < top[i]) {
				result[qidx.pop()] = i + 1;
				q.pop();
			}
			q.add(top[i]);
			qidx.add(i);
		}
		while(!qidx.isEmpty()) {
			result[qidx.pop()] = 0;
		}

		for(int i = 0; i < N; i++) {
			sb.append(result[i] + " ");
		}

		System.out.println(sb);	
	}
}
