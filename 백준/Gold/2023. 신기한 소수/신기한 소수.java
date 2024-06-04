import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(in.readLine());
		
		int[] prime = {2, 3, 5 ,7};
		
		for (int i = 0; i < prime.length; i++) {
			run(prime[i]);
		}
		System.out.println(sb);
	}
	
	static void run(int num) {
		if (String.valueOf(num).length() == N) {
			sb.append(num).append("\n");
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			int next = num * 10 + i;
			if(isPrime(next)) {
				run(next);
			}
		}
	}
	
	static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}