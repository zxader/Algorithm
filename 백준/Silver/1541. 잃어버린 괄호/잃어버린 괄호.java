import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");
        int[] temp = new int[input.length];
        
        for (int i = 0; i < input.length; i++) {
    		String[] sum = input[i].split("\\+");
    		for (int j = 0; j < sum.length; j++) {
    			temp[i] += Integer.parseInt(sum[j]);
    		}
        }
        
        int result = temp[0];
        
        for (int i = 1; i < temp.length; i++) {
        	result -= temp[i];
        }
        
        System.out.println(result);
	}
}