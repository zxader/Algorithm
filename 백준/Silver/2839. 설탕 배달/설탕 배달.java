
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int count = 0;
		
		while(true) {
			
			if (N%5 == 0) {
				N -= 5;
				count++;
			}else {
				N -= 3;
				count++;
			}
			
			if (N < 0) {
				count = -1;
				break;
			}
			if (N == 0) {
				break;
			}
		}
		
		sb.append(count);
		System.out.println(sb);
	}
}
