import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	
    	StringBuilder sb = new StringBuilder();
    	for (int t = 1; t <= T; t++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		
    		int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int dx = x2 - x1;
            int dy = y2 - y1;
            int d = dx * dx + dy * dy;
            int sumR = (r1 + r2) * (r1 + r2);
            int diffR = (r1 - r2) * (r1 - r2);
            
            if (sumR < d || diffR > d) {
            	sb.append(0);
            }
            else if (x1 == x2 && y1 == y2 && r1 == r2) {
            	sb.append(-1);
            }
            else if (sumR == d || diffR == d) {
            	sb.append(1);
            }
            else {
            	sb.append(2);
            }
            sb.append("\n");
    	}
    	
    	System.out.println(sb);
    }
}