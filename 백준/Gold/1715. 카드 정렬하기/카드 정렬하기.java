import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			q.offer(Integer.parseInt(br.readLine()));
		}
		int total = 0;
		while (true) {
			int a = q.poll();
			if (q.isEmpty()) {
				break;
			}
			int b = q.poll();
			total += (a+b);
			q.offer((a+b));
			if (q.size() == 1) {
				break;
			}
		}
		sb.append(total);
		System.out.println(sb);
	}
	
}