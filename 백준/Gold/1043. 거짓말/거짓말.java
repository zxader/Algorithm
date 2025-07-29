import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	List<Integer>[] party = new List[M];
    	boolean[] visited = new boolean[M];
    	Set<Integer> checked = new HashSet<>();
    	
    	st = new StringTokenizer(br.readLine());
    	int K = Integer.parseInt(st.nextToken());
    	for (int i = 0; i < K; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		checked.add(num);
    	}
    	
    	for (int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		K = Integer.parseInt(st.nextToken());
    		party[i] = new ArrayList<>();
    		for (int j = 0; j < K; j++) {
    			party[i].add(Integer.parseInt(st.nextToken()));
    		}
    	}
    	
    	for (int i = 0; i < M; i++) {
    		if (visited[i]) continue;
    		
    		for (int j : party[i]) {
    			if (checked.contains(j)) {
    				for (int k : party[i]) {
    					checked.add(k);
    				}
    				visited[i] = true;
    				i = -1;
    				break;
    			}
    		}
    	}
    	
    	int result = 0;
    	for (int i = 0; i < M; i++) {
    		if (!visited[i]) result++;

    	}
    	
    	System.out.println(result);
	}
}
