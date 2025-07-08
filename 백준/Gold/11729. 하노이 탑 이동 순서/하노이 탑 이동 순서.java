import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int result;
	static void dfs(int n, int from, int to, int via) {
		result++;
		if (n == 1) {
			sb.append(from).append(" ").append(to).append("\n");
			return;
		}
		
		dfs(n - 1, from, via, to);
		sb.append(from).append(" ").append(to).append("\n");
		dfs(n - 1, via, to, from);
	}
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	sb = new StringBuilder();
    	result = 0;
    	int N = Integer.parseInt(br.readLine());
    	
    	dfs(N, 1, 3, 2);
    	System.out.println(result);
    	System.out.println(sb);
	}
}
