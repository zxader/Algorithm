import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		int value;
		Node left;
		Node right;

		public Node (int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int value = Integer.parseInt(br.readLine());
		Node tempNode = new Node(value, null, null);
		String str;
		while(true) {
			str = br.readLine();
			if (str == null || str.equals("")) {
				break;
			}
			value = Integer.parseInt(str);
			insert(tempNode, value);
		}
		dfs(tempNode);
	}
	
	static void insert(Node tempNode, int value) {
		if (value < tempNode.value) {
			if (tempNode.left == null) {
				tempNode.left = new Node(value, null, null);
			}
			else {
				insert(tempNode.left, value);
			}
		}
		else {
			if (tempNode.right == null) {
				tempNode.right = new Node(value, null, null);
			}
			else {
				insert(tempNode.right, value);
			}
		}
	}
	
	static void dfs(Node node) {
		if (node.left != null) {
			dfs(node.left);
		}
		if (node.right != null) {
			dfs(node.right);
		}
		System.out.println(node.value);
	}

}