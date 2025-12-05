import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][M + 1];
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            rotation(arr, x, d, k, N, M);
            List<int[]> list = check(arr, N, M);
            if (list.size() > 0) {
                remove(list, arr);
            }
            else {
                average(arr, N, M);
            }
        }
        
        System.out.println(sum(arr, N, M));
	}
	
	static void rotation(int[][] arr, int x, int d, int k, int N, int M) {
	    for (int i = x; i <= N; i += x) {
            move(arr[i], d, k, N, M);	        
	    }
	}
	
	static void move(int[] arr, int d, int k, int N, int M) {
	    int[] temp = new int[M + 1];
	    
	    for (int i = 1; i <= M; i++) {
	        int idx = i;
	        
	        if (d == 0) idx += k;
	        if (d == 1) idx -= k;
	        if (idx > M) idx -= M;
	        if (idx < 1) idx += M;
	        
	        temp[idx] = arr[i];
	    }
	    
	    for (int i = 1; i <= M; i++) {
	        arr[i] = temp[i];
	    }
	}
	
	static List<int[]> check(int[][] arr, int N, int M) {
	    List<int[]> list = new ArrayList<>();
	    
	    for (int i = 1; i <= N; i++) {
	        for (int j = 1; j <= M; j++) {
	            if (arr[i][j] == 0) continue;
	            int v = arr[i][j];
	            int a = j - 1;
	            int b = j + 1;
	            if (a == 0) a = M;
	            if (b == M + 1) b = 1;
	            if (v == arr[i][a] || v == arr[i][b]) {
	                list.add(new int[] {i , j});
	                continue;
	            }
	            
	            int c = i - 1;
	            int d = i + 1;
	            if (c != 0 && arr[c][j] == v) {
	               list.add(new int[] {i, j});
	               continue;
	            }
	            if (d != N + 1 && arr[d][j] == v) {
	               list.add(new int[] {i, j});
	               continue;
	            }
	        }
	    }
	    
	    return list;
	}
	
	static void remove(List<int[]> list, int[][] arr) {
	    for (int[] i : list) {
	        arr[i[0]][i[1]] = 0;
	    }
	}
	
	static void average(int[][] arr, int N, int M) {
	    double avg = 0;
	    int cnt = 0;
	    for (int i = 1; i <= N; i++) {
	        for (int j = 1; j <= M; j++) {
	            if (arr[i][j] == 0) continue;
	            avg += arr[i][j];
	            cnt++;
	        }
	    }
	    
	    avg /= cnt;

	    for (int i = 1; i <= N; i++) {
	        for (int j = 1; j <= M; j++) {
	            if (arr[i][j] == 0) continue;
	            if ((double)arr[i][j] > avg) {
	                arr[i][j]--;
	            }
	            else if ((double)arr[i][j] < avg) {
	                arr[i][j]++;
	            }
	        }
	    }
	}
	
	static int sum(int[][] arr, int N, int M) {
	    int temp = 0;
	    for (int i = 1; i <= N; i++) {
	        for (int j = 1; j <= M; j++) {
	            temp += arr[i][j];
	        }
	    }
	    
	    return temp;
	}
	
}