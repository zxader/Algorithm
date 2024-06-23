import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int y = Integer.parseInt(br.readLine());
		int result = 0;
		if (y%4 == 0 && y%100 != 0) {
			result = 1;
		}
		else if (y%400 == 0){
			result = 1;
		}
		sb.append(result);
		System.out.println(sb);
	}
}