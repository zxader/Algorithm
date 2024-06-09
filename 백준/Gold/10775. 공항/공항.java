import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int[] arr = new int[G + 1];
		int[] save = new int[P];
		int[] save1 = new int[G + 1];
		int count = 0;
		
		for (int i = 0; i < P; i++) {
			int g = Integer.parseInt(br.readLine());
			save[i] = g;
		}
		
		boolean check = false;
		for (int i = 0; i < P; i++) {
			int a = save[i];
			if (save1[a] != 0 ) {
				a = save1[a];
			}
			for (int j = a; j >= 1; j--) {
				if (arr[j] == 0) {
					arr[j] = i + 1;
					count++;
					save1[save[i]] = j;
					break;
				}
				if (j == 1) {
					check = true;
				}
			}
			if(check) {
				break;
			}
		}
		
		sb.append(count);
		System.out.println(sb);
	}

}