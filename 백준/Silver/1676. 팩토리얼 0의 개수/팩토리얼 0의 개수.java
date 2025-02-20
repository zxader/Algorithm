import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
        int count = 0;
        for (int i = 5; i <= N; i *= 5) {
            count += N / i;
        }
        
        System.out.println(count);
    }
}