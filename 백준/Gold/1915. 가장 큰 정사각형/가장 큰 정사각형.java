import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
		    String[] input = br.readLine().split("");
		    
		    for (int j = 0; j < m; j++) {
		        arr[i][j] = Integer.parseInt(input[j]);
		    }
		}

		// 세로 카운트 배열
		int[][] count = new int[n][m];
		
        for (int j = 0; j < m; j++) {
	        int cnt = 0;
	        for (int i = n - 1; i >= 0; i--) {
		        if (arr[i][j] == 0) {
		            cnt = 0;
		            continue;
		        }    
		        
		        cnt++;
		        count[i][j] = cnt;
		    }
		}
		// 가장 큰 정사각형 구하기
		int result = 0;
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < m; j++) {
		        if (arr[i][j] == 0) continue;
		        
		        int temp = count[i][j];
		        int last = Math.min(j + count[i][j], m);
		        int size = 1;
		        for (int k = j + 1; k < last; k++) {
		            if (k - j + 1 <= count[i][k]) {
		                temp = Math.min(count[i][k], temp);
		                size = k - j + 1;
		            }
		            else {
		                break;
		            }
		        }
		        size = Math.min(temp, size);
		        result = Math.max(size * size, result); 
		    }
		}
		
		System.out.println(result);
	}
}