import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int L;
	static List<Integer> list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		list.add(0);
		list.add(L);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		
		int start = 1;
		int end = L;
		
		while(start <= end) { 
			int mid = (start + end) / 2;
			int count = 0;
			
			for (int i = 0; i < list.size() - 1; i++) {
				count += (list.get(i + 1) - list.get(i) - 1) / mid;
			}
			
			if (count > M) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		
		sb.append(start);
		System.out.print(sb);
	}
}