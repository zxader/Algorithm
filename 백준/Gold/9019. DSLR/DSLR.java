import java.io.*;
import java.util.*;

public class Main {
	static class Register {
		int no;
		String c;
		
		public Register(int no, String c) {
			this.no = no;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int t = 1; t <= T; t++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int A = Integer.parseInt(st.nextToken());
    		int B = Integer.parseInt(st.nextToken());
    		boolean[] visited = new boolean[10000];
    		Queue<Register> q = new ArrayDeque<>();
    		q.add(new Register(A, ""));
    		visited[A] = true;
    		
    		while (!q.isEmpty()) {
    			Register r = q.poll();
    			
    			if(r.no == B) {
    				sb.append(r.c).append("\n");
    				break;
    			}
    			
    			for (int d = 0; d < 4; d++) {
    				int num = Command(d, r.no);
    				
    				if (!visited[num]) {
    					q.add(new Register(num, r.c + Command(d)));
    					visited[num] = true;
    				}
    			}
    			
    		}
    	}
    	
    	System.out.println(sb);
	}
	
	static int Command(int idx, int num) {
		if (idx == 0) {
			return dCommand(num);
		}
		else if (idx == 1) {
			return sCommand(num);
		}
		else if (idx == 2) {
			return lCommand(num);
		}
		else {
			return rCommand(num);
		}
	}
	
	static String Command(int idx) {
		if (idx == 0) {
			return "D";
		}
		else if (idx == 1) {
			return "S";
		}
		else if (idx == 2) {
			return "L";
		}
		else {
			return "R";
		}
	}
	
	static int dCommand(int num) {
		return 2 * num % 10000;
	}
	
	static int sCommand(int num) {
		if (num == 0) return 9999;
		return num - 1;
	}
	
	static int lCommand(int num) {
		int d1 = num / 1000;
		int d2 = num % 1000 / 100;
		int d3 = num % 1000 % 100 / 10;
		int d4 = num % 1000 % 100 % 10;
		
		return ((d2 * 10 + d3) * 10 + d4) * 10 + d1;
	}
	
	static int rCommand(int num) {
		int d1 = num / 1000;
		int d2 = num % 1000 / 100;
		int d3 = num % 1000 % 100 / 10;
		int d4 = num % 1000 % 100 % 10;
		
		return ((d4 * 10 + d1) * 10 + d2) * 10 + d3;
	}
}
