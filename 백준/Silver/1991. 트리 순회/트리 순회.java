import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		char str;
		char left, right;
		
		public Node(char str, char left, char right) {
			this.str = str;
			this.left =left;
			this.right = right;
		}
	}
	
	static Node[] node;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	node = new Node[N];
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		char current = st.nextToken().charAt(0);;
    		char left = st.nextToken().charAt(0);
    		char right = st.nextToken().charAt(0);
    		
    		node[current - 'A'] = new Node(current, left, right);
    	}
    	
    	sb = new StringBuilder();
    	
    	pre(0);
    	sb.append("\n");
    	in(0);
    	sb.append("\n");
    	post(0);
    	System.out.println(sb);
	}
	
	static void pre(int i) {
		sb.append(node[i].str);
		if (node[i].left != '.') {
			pre(node[i].left - 'A');
		}
		if (node[i].right != '.') {
			pre(node[i].right - 'A');
		}
	}
	
	static void in(int i) {
		if (node[i].left != '.') {
			in(node[i].left - 'A');
		}
		sb.append(node[i].str);
		if (node[i].right != '.') {
			in(node[i].right - 'A');
		}
	}
	
	static void post(int i) {
		if (node[i].left != '.') {
			post(node[i].left - 'A');
		}
		if (node[i].right != '.') {
			post(node[i].right - 'A');
		}
		sb.append(node[i].str);
	}
}
