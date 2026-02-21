import java.util.*;
import java.io.*;

public class Main
{
    static class Room implements Comparable<Room> {
        int S, T;
        
        Room(int S, int T) {
            this.S = S;
            this.T = T;
        }
        
        @Override
        public int compareTo(Room o) {
            return this.S - o.S;
        }
    }
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Room> pq = new PriorityQueue<>();
        PriorityQueue<Integer> time = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            
            pq.offer(new Room(S, T));
        }
        
        
        int result = 1;
        while (!pq.isEmpty()) {
            Room r = pq.poll();
            
            if (time.isEmpty()) {
                time.offer(r.T);
                continue;
            }
            
            time.offer(r.T);
            int T = time.peek();
            
            if (T <= r.S) {
                time.poll();
            }
            else {
                result++;
            }
        }
        
        System.out.println(result);
	}
}