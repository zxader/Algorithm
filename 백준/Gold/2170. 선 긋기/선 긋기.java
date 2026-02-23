import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            list.add(new int[] {x, y});
        }
        
        Collections.sort(list, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        int start = list.get(0)[0];
        int end = list.get(0)[1];
        int sum = end - start;
        for (int i = 1; i < list.size(); i++) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            
            if (start <= x && x <= end && y <= end) continue;
            
            if (start <= x && x <= end && end < y) {
                sum += (y - end);
                end = y;
                continue;
            }
            
            start = x;
            end = y;
            sum +=  (end - start);
            
        }
        
        System.out.println(sum);
	}
}