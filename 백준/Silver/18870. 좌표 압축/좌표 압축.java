import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] arr = new int[N];
    	Set<Integer> set = new TreeSet<>();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    		set.add(arr[i]);
    	}
    	
    	List<Integer> list = new ArrayList<>(set);
    	Map<Integer, Integer> map = new HashMap<>();
    	for (int i = 0; i < list.size(); i++) {
    		map.put(list.get(i), i);
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < N; i++) {
			sb.append(map.get(arr[i]));
    		sb.append(" ");
    	}
    	
    	System.out.println(sb);
	}
	
	
}
