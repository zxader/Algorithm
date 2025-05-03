import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] A = new int[N];
    	int[] B = new int[N];
    	int[] C = new int[N];
    	int[] D = new int[N];
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		int d = Integer.parseInt(st.nextToken());
    		
    		A[i] = a;
    		B[i] = b;
    		C[i] = c;
    		D[i] = d;
    	}
    	
    	int[] AB = new int[N*N];
    	int idx = 0 ;
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			int sum = A[i] + B[j];
    			AB[idx++] = sum;
    		}
    	}
    	
    	int[] CD = new int[N*N];
    	idx = 0 ;
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			int sum = C[i] + D[j];
    			CD[idx++] = sum;
    		}
    	}
    	Arrays.sort(AB);
    	Arrays.sort(CD);
    	
    	int left = 0;
    	int right = N * N - 1;
    	long result = 0;
    	
    	while (left <= N * N - 1 && right >= 0) {
    		int sum = AB[left] + CD[right];
    		
    		if (sum == 0) {
    			int tempAB = AB[left];
    			int cntAB = 0;
    			while (left <= N * N - 1 && AB[left] == tempAB) {
    				left++;
    				cntAB++;
    			}
    			
    			int tempCD = CD[right];
    			int cntCD = 0;
    			while (right >= 0 && CD[right] == tempCD) {
    				right--;
    				cntCD++;
    			}
    			
    			result += (long) cntAB * cntCD;
    		}
    		else if (sum > 0) {
    			right--;
    		}
    		else {
    			left++;
    		}
    		
    	}
    	
    	System.out.println(result);
	}
}
