import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		List<Integer> arr = new ArrayList<>();
		int max = 0;
		long result = 0;
		
		for (int i = 0; i < N; i++) {
			int k = Integer.parseInt(st.nextToken());
			arr.add(k);
			if (max < k) max = k;
		}
		
		Collections.sort(arr);
		int start = 0;
		int end = max;
		
		while(start <= end) {
			int mid = (start + end)/2;
			long sum = 0;
			
			for (int j = arr.size() - 1; j >= 0; j--) {
				if (arr.get(j) - mid <= 0) break;
				sum += (arr.get(j) - mid);
			}
			
			if (sum < M) {
				end = mid - 1;
			}
			else {
				result = mid;
				start = mid + 1;
			}
		}
		
		sb.append(result);
		System.out.println(sb);
	}
}