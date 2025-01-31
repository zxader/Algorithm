import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i = 1; i <= N; i++) {
        	q.add(i);
        }
        
        int cnt = 1;
        sb.append("<");
        while (true) {
        	int num = q.poll();
        	
        	if (cnt == K) {
        		if (q.isEmpty()) {
        			sb.append(num);
        			break;
        		}
        		else {
        			sb.append(num + ", ");
        		}
        		cnt = 0;
        	}
        	else {
        		q.add(num);
        	}
        	
        	cnt++;
        }
        sb.append(">");
        System.out.println(sb);
	}
}