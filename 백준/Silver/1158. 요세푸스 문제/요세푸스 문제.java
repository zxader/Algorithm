

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] read = in.readLine().split(" ");

		int N = Integer.parseInt(read[0]);
		int K = Integer.parseInt(read[1]);

		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}

		int count = 1;

		sb.append("<");

		while(!q.isEmpty()) {
			if(count == K) {

				if(q.size() == 1) {
					sb.append(q.poll());
					break;
				}else {
					sb.append(q.poll()+ ", ");
					if(K==1) {
						continue;
					}
					count = 1;
				}

				if(q.isEmpty()) {
					break;
				}
			}
			q.offer(q.poll());
			count++;
		}

		sb.append(">");

		System.out.println(sb);
	}
}
