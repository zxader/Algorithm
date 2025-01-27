import java.util.*;
import java.io.*;

public class Main {
	static int[] students;
    static boolean[] visited;
    static boolean[] finished;
    static int count;
    
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        	int N = Integer.parseInt(br.readLine());
        	students = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            count = 0;
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int i = 1; i <= N; i++) {
        		students[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
        	
        	sb.append(N - count).append("\n");
        }
        
        System.out.println(sb);
	}
	
	static void dfs(int student) {
        visited[student] = true; 
        int next = students[student]; 

        if (!visited[next]) { 
            dfs(next);
        } else if (!finished[next]) { 
            int current = next;
            do {
                count++;
                current = students[current];
            } while (current != next);
        }

      
        finished[student] = true;
    }
}