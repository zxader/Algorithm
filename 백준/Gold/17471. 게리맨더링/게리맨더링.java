import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
	
	static boolean[] isSelected;
	static int N;
	static int[] num;
	static List<List<Integer>> list;
	static int min;
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		
		num = new int[N + 1];
		
		String[] split = in.readLine().split(" ");
		
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(split[i - 1]);
		}
		
		list = new ArrayList<>(); 
		for (int i = 1; i <= N +1 ; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 1; i <= N; i++) {
			split = in.readLine().split(" ");
			for (int j = 1; j <= Integer.parseInt(split[0]); j++) {
				list.get(i).add(Integer.parseInt(split[j]));
			}
		}
		
		isSelected = new boolean[N + 1];
		min = Integer.MAX_VALUE;
		bfs(1);
		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		sb.append(min);
		System.out.println(sb);

	}

	static void bfs(int cnt) {
		if (cnt == N + 1) {
			int sum1 = 0;
			int sum2 = 0;
			int idx1 = 0;
			int idx2 = 0;
			int save = 0;
			Queue<Integer> q = new ArrayDeque<>();
			for (int i = 1; i <= N; i++) {
				if(isSelected[i]) {
					sum1 += num[i];
					idx1++;
					save = i;
				}
			}
			if (save == 0) {
				return;
			}
			q.offer(save);
			int count = 0;
			boolean[] check = new boolean[N + 1];
			while(!q.isEmpty()) {
				int a = q.poll();
				check[a] = true;
				for (int lists : list.get(a) ) {
					if(isSelected[lists] && !check[lists]) {
						q.offer(lists);
						check[lists] = true;
					}
				}
				count++;
			}
			if (count != idx1) {
				return;
			}
			for (int i = 1; i <= N; i++) {
				if(!isSelected[i]) {
					sum2 += num[i];
					idx2++;
					save= i;
				}
			}
			q.offer(save);
			count = 0;
			check = new boolean[N + 1];
			while(!q.isEmpty()) {
				int a = q.poll();
				check[a] = true;
				for (int lists : list.get(a) ) {
					if(!isSelected[lists] && !check[lists]) {
						q.offer(lists);
						check[lists] = true;
					}
				}
				count++;
			}
			if (count != idx2) {
				return;
			}
			int sum = Math.abs(sum1 - sum2);
			if (min > sum) {
				min = sum;
			}
			return;
		}
			isSelected[cnt] = true;
			bfs(cnt + 1);
			isSelected[cnt] = false;
			bfs(cnt + 1);
	}
}