import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }
        
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        int current = 1; 
        boolean possible = true;

        for (int num : sequence) {
            while (current <= num) {
                stack.push(current);
                sb.append("+\n");
                current++;
            }
            
            if (stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            } else {
                possible = false;
                break;
            }
        }
        
        if (possible) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}