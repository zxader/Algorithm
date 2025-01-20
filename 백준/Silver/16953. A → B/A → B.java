import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int cnt = 1;
        while(true) {
        	if (B <= A) {
        		break;
        	}
        	if (B % 10 == 1) {
        		B /= 10;
        	}
        	else if (B % 2 == 0) {
        		B /= 2;
        	}
        	else {
        		cnt = -1;
        		break;
        	}
        	cnt++;
        }
        
        if (B < A) {
        	cnt = -1;
        }
        
        System.out.println(cnt);
	}
}