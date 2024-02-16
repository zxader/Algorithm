import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int sum = 0;
		String[] split = in.readLine().split("");
		for (int i = 0; i < N; i++) {
			sum += Integer.parseInt(split[i]);
		}
		sb.append(sum);
		System.out.println(sb);
	}
}