import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<int[]> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < input.length(); i++) {
        	if (input.charAt(i) == '(') {
                stack.push(i);
            } else if (input.charAt(i) == ')') {
                list.add(new int[]{stack.pop(), i});
            }
        }
        
        Set<String> result = new HashSet<>();
        int n = list.size();
        int size = 1 << n;
        
        for (int mask = 1; mask < size; mask++) {
        	boolean[] remove  = new boolean[input.length()];
        	
        	for (int i = 0; i < n; i++) {
        		if ((mask & (1 << i)) != 0) {
        			 remove[list.get(i)[0]] = true; 
                     remove[list.get(i)[1]] = true;
        		}
        	}
        	
        	StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                if (!remove[i]) {
                    sb.append(input.charAt(i));
                }
            }
            result.add(sb.toString());
        }
        
        List<String> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult);
        
        for (String s : sortedResult) {
            System.out.println(s);
        }
	}
}