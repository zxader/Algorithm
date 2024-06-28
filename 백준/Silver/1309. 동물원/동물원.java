import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[3][N];
		arr[0][0] = 1;
		arr[1][0] = 1;
		arr[2][0] = 1;
		
		for (int i = 1; i < N; i++) {
			arr[0][i] = (arr[0][i - 1] + arr[1][i - 1] + arr[2][i - 1])%9901;
			arr[1][i] = (arr[0][i - 1] + arr[2][i - 1])%9901;
			arr[2][i] = (arr[0][i - 1] + arr[1][i - 1])%9901;
		}
		long result = arr[0][N - 1] + arr[1][N - 1] + arr[2][N - 1];
		sb.append(result%9901);
		System.out.println(sb);
	}
}