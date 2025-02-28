import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	double units = 0;
    	double grades = 0;
    	
    	for (int i = 0; i < 20; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		String name = st.nextToken();
    		double unit = Double.parseDouble(st.nextToken());
    		String grade = st.nextToken();
    		
    		switch (grade) {
    		case "A+":
    			grades += 4.5 * unit;
    			break;
    		case "A0":
    			grades += 4.0 * unit;
    			break;
    		case "B+":
    			grades += 3.5 * unit;
    			break;
    		case "B0":
    			grades += 3.0 * unit;
    			break;
    		case "C+":
    			grades += 2.5 * unit;
    			break;
    		case "C0":
    			grades += 2.0 * unit;
    			break;
    		case "D+":
    			grades += 1.5 * unit;
    			break;
    		case "D0":
    			grades += 1.0 * unit;
    			break;
    		case "F":
    			grades += 0.0 * unit;
    			break;
    		}
    		
    		if (!grade.equals("P")) {
    			units += unit;
    		}
    	}
    	
    	System.out.println(grades / units);
    }
}