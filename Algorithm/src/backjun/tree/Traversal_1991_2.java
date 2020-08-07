package backjun.tree;

import java.util.Scanner;

public class Traversal_1991_2 {
	
	static Node root;
	
	public static void main(String[] args) {
		getInput();
		preOrder(root);
		System.out.println();
		midOrder(root);
		System.out.println();
		postOrder(root);
	}
	
	static void postOrder(Node node) {
		if(node.left != null)
			postOrder(node.left);
		if(node.right != null)
			postOrder(node.right);
		System.out.print(node.body);
	}
	
	static void midOrder(Node node) {
		if(node.left != null)
			midOrder(node.left);
		System.out.print(node.body);
		if(node.right != null)
			midOrder(node.right);
	}
	
	static void preOrder(Node node) {
		if(node != null)
			System.out.print(node.body);
		if(node.left != null)
			preOrder(node.left);
		if(node.right != null)
			preOrder(node.right);
	}
	
	static void add(String str) {
		String arr[] = str.split(" ");
		Node node = null; 
		if(arr[0].equals("A")) {
			root = new Node(arr[0]);
			node = root;
		}else {
			node = searchChild(root, arr[0]);
		}
		setChild(node, arr);
	}
	
	static Node searchChild(Node node, String str) {
		Node result = null;
		if(node.body.equals(str))
			return node;
		else {
			if(node.left != null)
				result = searchChild(node.left, str);
			if(result == null && node.right != null)
				result = searchChild(node.right, str);
		}
			
		return result;
	}
	
	static void setChild(Node node, String[] arr) {
		if(!arr[1].equals("."))
			node.left = new Node(arr[1]);
		if(!arr[2].equals("."))
			node.right = new Node(arr[2]);
	}
	
	static void getInput() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<N; i++) {
			String str = sc.nextLine();
			add(str);
		}
		sc.close();
	}
	
	static class Node {
		public String body;
		public Node left;
		public Node right;
		
		public Node(String body) {
			this.body= body;
		}
	}

}
