import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	map = new char[N][M];

    	for (int i = 0; i < N; i++) {
    		String input = br.readLine();
    		for (int j = 0; j < M; j++) {
    			map[i][j] = input.charAt(j);
    		}
    	}
    	
    	int result = Integer.MAX_VALUE;
    	
    	for (int i = 0; i <= N - 8; i++) {
    		for (int j = 0; j <= M - 8; j++) {
    			result = Math.min(result, getCount(i, j));
    		}
    	}
    	
    	System.out.println(result);
    }
    
    static int getCount(int r, int c) {
    	int count1 = 0;
    	int count2 = 0;
    	
    	char[][] patterns = {{'W', 'B'}, {'B', 'W'}};
    	
    	for (int i = 0; i < 8; i++) {
    		for (int j = 0; j < 8; j++) {
    			char word1 = patterns[(i % 2)][(j % 2)];
    			char word2 = patterns[(i % 2 + 1) % 2][(j % 2)];
    			
    			if (map[r + i][c + j] != word1) count1++;
    			if (map[r + i][c + j] != word2) count2++;
    		}
    	}
    	
    	return Math.min(count1, count2);
    }
}