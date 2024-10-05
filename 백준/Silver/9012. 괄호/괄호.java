import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			Stack st = new Stack();
			String str = br.readLine();
			String result = "YES";
			
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					st.add(str.charAt(i));
				}
				else
				{
					if (!st.empty()) {
						char c = (char)st.pop();
					}
					else {
						result = "NO";
					}
				}
			}
			if (!st.empty()) {
				result = "NO";
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	
		
	}
}