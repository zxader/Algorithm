import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();
	
	static int N, S, count;
	static int[] arr;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = in.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		S = Integer.parseInt(str[1]);
		arr = new int[N];
		isSelected = new boolean[N];
		
		String[] readnumber = in.readLine().split(" ");
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(readnumber[i]);
		}
		
		if(S == 0) {
			count--;
		}
		sumPowerSet(0, 0);
		sb.append(count).append("\n");
		
		System.out.println(sb);
	}
	
	static void sumPowerSet(int cnt, int sum) {
		if(cnt == N) {
			if(sum == S) {
				count++;
			}
			return;
		}
		
		isSelected[cnt] = true;
		sumPowerSet(cnt + 1, sum + arr[cnt]);
		isSelected[cnt] = false;
		sumPowerSet(cnt + 1, sum);
		
	}
	
}
