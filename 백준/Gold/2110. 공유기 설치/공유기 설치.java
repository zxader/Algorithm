import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		
		int max = list.get(N - 1) - list.get(0);
		
		int start = 1;
		int end = max;
		int result = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			int count = 2;
			int save = 0;
			
			for (int i = 1; i < list.size() - 1; i++) {
				if (list.get(i) - list.get(save) >= mid && list.get(N - 1) - list.get(i) >= mid) {
					save = i;
					count++;
				}
			}
			
			if (count >= C) {
				result = mid;
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		sb.append(result);
		
		
		System.out.println(sb);
	}
}