

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution{
	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			sb.append("#" + test_case + " ");
			
			ArrayList<Integer> list = new ArrayList<>();
			
			int N = Integer.parseInt(in.readLine());
			String[] read = in.readLine().split(" ");
			
			for(int i = 0; i < N; i++) {
				list.add(Integer.parseInt(read[i]));
			}
			
			int C = Integer.parseInt(in.readLine());
			String[] readc = in.readLine().split(" ");
			for(int i = 0; i < readc.length; i++) {
				if(readc[i].equals("I")) {
					for(int j = 0; j < Integer.parseInt(readc[i+2]); j++) {
						list.add(Integer.parseInt(readc[i+1])+j,Integer.parseInt(readc[i+3+j]));
					}
				}
			}
			
			for(int i = 0; i < 10; i++) {
				sb.append(list.get(i) + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
