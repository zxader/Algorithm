import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] list = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    	
    	String input = br.readLine();
    	
    	for (String str : list) {
    		input = input.replace(str, "*");
    	}
    	
    	System.out.println(input.length());
    }
}