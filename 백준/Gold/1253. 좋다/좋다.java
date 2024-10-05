import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		int result = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			int start = 0;
			int end = list.size() - 1;
			while(start < end) {
				if (start == i) {
					start++;
				}
				if (end == i) {
					end--;
				}
				if (start == end) break;
				if (list.get(start) + list.get(end) == list.get(i)) {
					result++;
					break;
				}
				if (list.get(start) + list.get(end) > list.get(i)) {
					end--;
				}
				else {
					start++;
				}
			}
		}
		sb.append(result);
		System.out.println(sb);
	}
}