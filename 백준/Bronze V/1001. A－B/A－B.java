import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		String[] split = in.readLine().split(" ");
		int A = Integer.parseInt(split[0]);
		int B = Integer.parseInt(split[1]);
		sb.append(A - B);
		System.out.println(sb);
	}
}