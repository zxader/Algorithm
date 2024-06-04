import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		// 입력
		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);

		// 그래프 입력
		List<List<Integer>> list1 = new ArrayList<>(); 
		for (int i = 1; i <= N +1 ; i++) {
			list1.add(new ArrayList<>());
		}
		
		List<List<Integer>> list2 = new ArrayList<>(); 
		for (int i = 1; i <= N +1 ; i++) {
			list2.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			split = in.readLine().split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			list1.get(a).add(b);
			list2.get(b).add(a);
		}
		Queue<Integer> q = new ArrayDeque<>();
		int result = 0;
		for (int i = 1; i <= N; i++) {
			
			boolean[] check = new  boolean[N + 1];
			q.offer(i);
			check[i] = true;
			int count = 0;
			while(!q.isEmpty()) {
				int a = q.poll();
				check[a] = true;
				for (int lists : list1.get(a)) {
					if(!check[lists]) {
						q.offer(lists);
						check[lists] = true;
						count++;
					}
				}
			}
			check = new  boolean[N + 1];
			q.offer(i);
			while(!q.isEmpty()) {
				int a = q.poll();
				check[a] = true;
				for (int lists : list2.get(a)) {
					if(!check[lists]) {
						q.offer(lists);
						check[lists] = true;
						count++;
					}
				}
			}
			if (count == N - 1) {
				result++;
			}
		}
		// 결과
		sb.append(result);
		System.out.println(sb);

	}
}