package backjun.tree;

import java.util.Scanner;

public class Traversal_1991_1 {
	
	static class Node {
		public Node left, right;
		public String value;
		public Node(String value) {
			this.value = value;
		}
	}
	
	static Node root;
	
	public static void main(String[] args) {
		getIn();
		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		postOrder(root);
	}
	
	static void preOrder(Node node) {
		if(node == null)	return;
		System.out.print(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	static void inOrder(Node node) {
		if(node == null)	return;
		inOrder(node.left);
		System.out.print(node.value);
		inOrder(node.right);
	}
	
	static void postOrder(Node node) {
		if(node == null)	return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value);
	}
	
	static void makeTree(String str) {
		String[] arr = str.split(" ");
		if(root == null) {
			root = new Node(arr[0]);
			setNode(root, arr);
		}
		else 
			findLoc(root, arr);
	}
	
	static boolean findLoc(Node node, String[] arr) {
		if(node == null)	return false;
		
		if(node.value.equals(arr[0])) {
			setNode(node, arr);
			return true;
		}
		
		if(!findLoc(node.left, arr))
			findLoc(node.right, arr);
		
		return false;
	}
	
	static void setNode(Node node, String[] arr) {
		if(!arr[1].equals("."))
			node.left = new Node(arr[1]);
		if(!arr[2].equals("."))
			node.right = new Node(arr[2]);
	}
	
	static void getIn() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<N; i++)
			makeTree(sc.nextLine());
		sc.close();
	}

}
