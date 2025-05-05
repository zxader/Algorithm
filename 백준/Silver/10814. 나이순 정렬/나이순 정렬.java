import java.io.*;
import java.util.*;

public class Main {
	static class Person implements Comparable<Person> {
		int age;
		String name;
		
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		@Override
		public int compareTo(Person o) {
			return Integer.compare(this.age, o.age);
		}
	}
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	List<Person> list = new ArrayList<>();
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int age = Integer.parseInt(st.nextToken());
    		String name = st.nextToken();
    		list.add(new Person(age, name));
    	}
    	
    	Collections.sort(list);
    	
    	StringBuilder sb = new StringBuilder();
    	for (Person p : list) {
    		sb.append(p.age + " " + p.name).append("\n");
    	}
    	
    	System.out.println(sb);
	}
}
