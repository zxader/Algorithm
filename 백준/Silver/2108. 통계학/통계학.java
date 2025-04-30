import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int N = Integer.parseInt(br.readLine());
    	List<Integer> list = new ArrayList<>();
    	int[] cnt = new int[8001];
    	double sum = 0;
    	
    	for (int i = 0; i < N; i++) {
    		int input = Integer.parseInt(br.readLine());
    		list.add(input);
    		cnt[input + 4000]++;
    		sum += input;
    	}
    	
    	Collections.sort(list);
    	
    	int max = 0;
    	for (int i = 0; i < cnt.length; i++) {
    		max = Math.max(max, cnt[i]);
    	}
    	
    	int count = 0;
    	int result = 0;
    	for (int i = 0; i < cnt.length; i++) {
    		if (cnt[i] == max) {
    			result = i - 4000;
    			count++;
    		}
    		if (count == 2) break;
    	}
    	
    	sb.append(Math.round(sum/N)).append("\n");
    	sb.append(list.get(N/2)).append("\n");
    	sb.append(result).append("\n");
    	sb.append(list.get(N - 1) - list.get(0)).append("\n");
    	System.out.println(sb);
	}
}
