import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static StringBuilder sb;
	static ArrayList<Integer>[] arr;
	static int N;
	static int M;
	static boolean check;
	static int[] num;
	static int[] check2;
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		sb = new StringBuilder();

		String[] split = in.readLine().split(" ");

		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		arr = new ArrayList[N];
		num = new int[2000];
		check2 = new int[2000];
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			split = in.readLine().split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);

			arr[a].add(b);
			arr[b].add(a);
			if(check2[a] == 0) {
				list.add(a);
				check2[a] = 1;
			}
			if(check2[b] == 0) {
				list.add(b);
				check2[b] = 1;
			}
		}
		check = false;

		for (int i = 0; i < list.size(); i++) {
			num[list.get(i)] = 1;
			dfs(list.get(i), 1);
			num[list.get(i)] = 0;
		}

		if(check) {
			sb.append(1);
		}
		else {
			sb.append(0);
		}
		sb.append("\n");

		System.out.println(sb);
	}


	static void dfs(int i, int cnt) {

		if (cnt == 5) {
			check = true;

			return;
		}
		if(check) {
			return;
		}
		for (int j : arr[i]) {
			if(num[j] == 0) {
				num[j] = 1;
				dfs(j, cnt + 1);
				num[j] = 0;
			}
		}
	}
}