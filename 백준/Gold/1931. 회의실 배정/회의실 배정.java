import java.io.*;
import java.util.*;

public class Main {
	static class Time implements Comparable<Time>{
		int start;
		int end;
		
		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Time o) {
			if (this.end == o.end) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
	}
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	PriorityQueue<Time> q = new PriorityQueue<>();
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		q.offer(new Time(start, end));
    	}
    	int end = q.poll().end;
    	int result = 1;
    	
    	while (!q.isEmpty()) {
    		Time time = q.poll();
    		int start = time.start;
    		if (start >= end) {
    			result++;
    			end = time.end;
    		}
    	}
    	
    	System.out.println(result);
    }
}