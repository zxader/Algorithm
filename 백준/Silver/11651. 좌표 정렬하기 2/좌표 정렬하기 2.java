import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
    		@Override
    		public int compare(int[] a, int[] b) {
    			if (a[1] == b[1]) {
    				return a[0] - b[0];
    			}
    			return a[1] - b[1];
    		}
    	});
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		int[] arr = {x, y};
    		
    		q.offer(arr);
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	while (!q.isEmpty()) {
    		int[] p = q.poll();
    		sb.append(p[0] + " " + p[1]).append("\n");
    	}
    	
    	System.out.println(sb);
    }
}