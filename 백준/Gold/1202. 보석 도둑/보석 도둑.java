import java.util.*;
import java.io.*;

public class Main {
	static class Jewel implements Comparable<Jewel> {
		int weigh;
		int price;
		
		public Jewel(int weigh, int price) {
			this.weigh = weigh;
			this.price = price;
		}
		
		@Override
		public int compareTo(Jewel o) {
			return this.weigh - o.weigh;
		}
	}
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] bags = new int[K];
        Jewel[] jewels = new Jewel[N];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int weigh = Integer.parseInt(st.nextToken());
        	int price = Integer.parseInt(st.nextToken());
        	jewels[i] = new Jewel(weigh, price);
        }
        
        for (int i = 0; i < K; i++) {
        	bags[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(bags);
        Arrays.sort(jewels);
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        int idx = 0;
        
        for (int i : bags) {
        	
        	while (idx < N && jewels[idx].weigh <= i) {
        		q.offer(jewels[idx].price);
        		idx++;
        	}
        	
        	if (!q.isEmpty()) {
        		sum += q.poll();
        	}
        }
        
        System.out.println(sum);
	}
}