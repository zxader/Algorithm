import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int L = Integer.parseInt(split[1]);
		
		split = in.readLine().split(" ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i< N; i++) {
			if (arr[i] <= L) {
				L++;
			}
		}
		sb.append(L);
		System.out.println(sb);
	}
}