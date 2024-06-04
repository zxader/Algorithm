import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int i = 1;
		while(true) {
			String str = br.readLine();
			if(str.equals("0")) {
				break;
			}
			sb.append("Case "+ i +": Sorting... done!").append("\n");
			i++;
		}
		System.out.println(sb);
	}
	
}