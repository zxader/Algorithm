import java.util.*;
import java.io.*;

public class Main {
	static int T;
	static int N;
	static int M;
	static int[] word;
	static int[] answerWord;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	// 수첩 1
	    	N = Integer.parseInt(br.readLine());
	        word = new int[N];
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        for (int i = 0; i < N; i++) {
	        	word[i] = Integer.parseInt(st.nextToken());
	        }
	        Arrays.sort(word);
	        
	        // 수첩 2
	        M = Integer.parseInt(br.readLine());
	        answerWord = new int[M];
	        st = new StringTokenizer(br.readLine());
	        for (int i = 0; i < M; i++) {
	        	answerWord[i] = Integer.parseInt(st.nextToken());
	        	sb.append(binarySearch(answerWord[i])).append("\n");
	        }
        }
        
        System.out.println(sb);
    }
    
    // 이분탐색으로 숫자 찾는 메서드
    static int binarySearch(int num) {
    	int start = 0;
    	int end = N - 1;
    	
    	while (start <= end) {
    		int mid = (start + end) / 2;
    		
    		if (word[mid] == num) {
    			return 1;
    		}
    		
    		if (word[mid] < num) {
    			start = mid + 1;
    		}
    		else {
    			end = mid - 1;
    		}
    	}
    	
    	return 0;
    }
}