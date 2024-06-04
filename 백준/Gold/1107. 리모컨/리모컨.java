import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static String N; 
	static int M;
	static int[] arr;
	static int count;
	static int min;
	static int[] result;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =  new StringBuilder();
		N = in.readLine();
		M = Integer.parseInt(in.readLine());
		arr = new int[10];
		count = 0;
		min = Integer.MAX_VALUE;
		if(M !=0) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < M; i++) {
				int num = Integer.parseInt(st.nextToken());
				arr[num]++;
			}
		}
		updown(100, 0);
		for (int i = 1; i <= 7; i++) {
			result = new int[i];
			Perm(0,i);
		}
		sb.append(min);
		System.out.println(sb);
	}

	static void Perm(int cnt,int l) {
		if(cnt == l) {
			StringBuilder r = new StringBuilder();
			for (int i = 0; i < l; i++) {
				r.append(result[i]);
			}
			int num = Integer.parseInt(r.toString());
			updown(num, l);
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (arr[i] > 0) continue;
			result[cnt] = i;
			Perm(cnt + 1, l);
		}

	}

	static void updown(int c, int count) {
		int num = Integer.parseInt(N);

		count += (Math.abs(num - c));
		min = Math.min(count, min);
	}
}
