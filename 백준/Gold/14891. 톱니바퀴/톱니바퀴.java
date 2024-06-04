import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] num1 = new int[8];
	static int[] num2 = new int[8];
	static int[] num3 = new int[8];
	static int[] num4 = new int[8];

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String[] spilt = in.readLine().split("");
		for (int i = 0; i < 8; i++) {
			num1[i] = Integer.parseInt(spilt[i]);
		}
		spilt = in.readLine().split("");
		for (int i = 0; i < 8; i++) {
			num2[i] = Integer.parseInt(spilt[i]);
		}
		spilt = in.readLine().split("");
		for (int i = 0; i < 8; i++) {
			num3[i] = Integer.parseInt(spilt[i]);
		}
		spilt = in.readLine().split("");
		for (int i = 0; i < 8; i++) {
			num4[i] = Integer.parseInt(spilt[i]);
		}
		int K = Integer.parseInt(in.readLine());
		for (int i = 0; i < K; i++) {
			spilt = in.readLine().split(" ");
			int num = Integer.parseInt(spilt[0]);
			int R = Integer.parseInt(spilt[1]);

			boolean check12 = false;
			boolean check23 = false;
			boolean check34 = false;
			switch(num) {
			
			case 1:
				if (num1[2] != num2[6]) {
					check12 = true;
				}
				if (num2[2] != num3[6] && check12) {
					check23 = true;
				}
				if (num3[2] != num4[6] && check23) {
					check34 = true;
				}
				r(R, num1);
				if (check12) {
					r(-R, num2);
				}
				if (check23) {
					r(R, num3);
				}
				if (check34) {
					r(-R, num4);
				}
				break;

			case 2:
				if (num1[2] != num2[6]) {
					check12 = true;
				}
				if (num2[2] != num3[6]) {
					check23 = true;
				}
				if (num3[2] != num4[6] && check23) {
					check34 = true;
				}
				r(R, num2);
				if (check12) {
					r(-R, num1);
				}
				if (check23) {
					r(-R, num3);
				}
				if (check34) {
					r(R, num4);
				}
				break;

			case 3:
				if (num2[2] != num3[6]) {
					check23 = true;
				}
				if (num1[2] != num2[6] && check23) {
					check12 = true;
				}
				if (num3[2] != num4[6]) {
					check34 = true;
				}
				r(R, num3);
				if (check12) {
					r(R, num1);
				}
				if (check23) {
					r(-R, num2);
				}
				if (check34) {
					r(-R, num4);
				}
				break;


			case 4:
				if (num3[2] != num4[6]) {
					check34 = true;
				}
				if (num2[2] != num3[6] && check34) {
					check23 = true;
				}
				if (num1[2] != num2[6] && check23) {
					check12 = true;
				}
				r(R, num4);
				if (check12) {
					r(-R, num1);
				}
				if (check23) {
					r(R, num2);
				}
				if (check34) {
					r(-R, num3);
				}
				break;
			}
		}
		int sum = 0;
		if (num1[0] == 1) {
			sum += 1;
		}
		if (num2[0] == 1) {
			sum += 2;
		}
		if (num3[0] == 1) {
			sum += 4;
		}
		if (num4[0] == 1) {
			sum += 8;
		}
		
		sb.append(sum);
		System.out.println(sb);
	}
	static void r(int R, int[] num) {
		if (R == 1) {
			int temp = num[7];
			for (int i = 7; i > 0; i--) {
				num[i] = num[i - 1];
			}
			num[0] = temp;
		}
		if (R == -1) {
			int temp = num[0];
			for (int i = 0; i < 7; i++) {
				num[i] = num[i + 1];
			}
			num[7] = temp;
		}
	}
}