import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input > 0) {
                list1.add(input);
            }
            else {
                list2.add(input);
            }
        }
        
        Collections.sort(list1);
        Collections.sort(list2);
        
        int sum = 0;
        for (int i = list1.size() - 1; i >= 0; i--) {
            int a = list1.get(i);
            
            if (i == 0) {
                sum += a;
                break;
            }
            
            int b = list1.get(i - 1);
            
            if (a + b > a*b) {
                sum += a;
            }
            else {
                sum += (a * b);
                i--;
            }
        }
        
        for (int i = 0; i < list2.size() - 1; i += 2) {
            int a = list2.get(i);
            int b = list2.get(i + 1);
            
            sum += (a*b);
        }        
        
        if (list2.size() % 2 != 0) sum += list2.get(list2.size() - 1);
        
        System.out.println(sum);
	}
}