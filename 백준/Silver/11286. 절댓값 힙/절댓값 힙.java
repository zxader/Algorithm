import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) < Math.abs(o2)) {
					return -1;
				}else {
					if(Math.abs(o1) == Math.abs(o2)) {
						if(o1<o2) {
							return -1;
						}else {
							return 1;
						}
					}
					return 1;
				}
			}
		});
		
		
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(in.readLine());
			if(x != 0) {
					q.add(x);
			}else {
				if(q.isEmpty()) {
					sb.append(0).append("\n");
				}else {
					sb.append(q.remove()).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}

}