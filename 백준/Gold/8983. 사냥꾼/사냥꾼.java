import java.util.*;
import java.io.*;

public class Main {
	static int M;
	static int N;
	static int L;
	static int[] people;
	static int[][] animal;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        people = new int[M];
        animal = new int[N][2];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < M; i++) {
        	people[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(people);
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	animal[i][0] = Integer.parseInt(st.nextToken());
        	animal[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int result = 0;
        
        for (int i = 0; i < N; i++) {
        	int start = 0;
        	int end = M - 1;
        	
        	while (start <= end) { 
        		int mid = (start + end) / 2;
        		
        		if ((Math.abs(people[mid] - animal[i][0]) + animal[i][1]) <= L) {
        			result++;
        			break;
        		}
        		else {
        			if (people[mid] - animal[i][0] < 0) {
        				start = mid + 1;
        			}
        			else {
        				end = mid - 1;
        			}
        		}
        	}
        }
        
        System.out.println(result);
    }  
}