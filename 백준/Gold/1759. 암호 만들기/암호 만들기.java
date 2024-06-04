import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int L;
	static int C;
	static char[] pw;
	static boolean[] check;
	static StringBuilder sb;

	static void dfs(char[] arr, boolean[] check, int start, int c, int l) {

		if(l == 0) { // 다 고르면 리턴
			print(arr, check, c);
			return;
		}
		
		// 뽑기
		for(int i = start; i < c; i++) {
			check[i] = true;
			dfs(arr, check, i+1, c, l-1);
			check[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		sb = new StringBuilder();

		String[] str = in.readLine().split(" ");
		L = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);

		pw = new char[C];
		check = new boolean[C];

		String[] input = in.readLine().split(" ");

		for(int i = 0; i < input.length; i++) {
			pw[i] = input[i].charAt(0);
		}

		Arrays.sort(pw); // 정렬

		dfs(pw, check, 0, C, L);

		System.out.println(sb);
	}
	
	// check ture인거만 골라서 출력
	static void print(char[] arr, boolean[] check, int c) {
		char[] check2 = new char[c]; // 모음1개 자음 2개 이상아닌거 걸러내기 위한 배열
		int count1 = 0; // 모음 갯수
		int count2 = 0; // 자음 갯수
				
		for (int i = 0; i < c; i++) {
			if(check[i]) {
				if("aeiou".indexOf(arr[i])>=0) {
					count1++;
				}else {
					count2++;
				}
				check2[i] = arr[i];
			}
		}
		
		// 최소 모음 1개, 자음 2개이상이지 않으면 리턴
		if(!(count1 >= 1 && count2 >= 2)) {
			return;
		}else {
			// 공백인 경우 추가 x
			for (int i = 0; i < c; i++) {
				if(check2[i] != '\0') {
					sb.append(check2[i]);
				}
			}
			sb.append("\n");
		}
	}
}