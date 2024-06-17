import java.util.*;
import java.io.*;

// 브론즈 2. 거스름돈 
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, res;
	static int[] unit = {500, 100, 50, 10, 5, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int change = 1000 - N;
		for (int i=0; i<6; i++) {
			if (change >= unit[i]) {
				res += change / unit[i];
				change %= unit[i];
			}
		}
		System.out.println(res);
		br.close();
	}
}