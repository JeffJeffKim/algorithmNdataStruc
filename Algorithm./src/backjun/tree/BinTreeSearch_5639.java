// https://www.acmicpc.net/problem/5639
package backjun.tree;

import java.util.Scanner;

public class BinTreeSearch_5639 {
	
	static class Node {
		int num;
		Node left, right;
		public Node (int num) {
			this.num = num;
		}
	}
	
	static Node root;
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		while(sc.hasNextLine()) {
//			newIn(sc.nextInt());
//		}
//		sc.close();
		
		//input
		int arr[] = {50, 30,24,5,28,45,98,52,60};
		for(int num : arr)
			newIn(num);
		
		postOrder(root);
	}
	
	static void postOrder(Node node) {
		if(node.left != null)
			postOrder(node.left);
		if(node.right != null)
			postOrder(node.right);
		System.out.println(node.num);
	}
	
	static void newIn(int num) {
		if(root == null) {
			root = new Node(num);
		}else {
			defineNode(root, num);
		}
	}
	
	static void defineNode(Node node, int num) {
		if(node.num > num) {
			if(node.left == null)
				node.left = new Node(num);
			else
				defineNode(node.left, num);
		}else {
			if(node.right == null)
				node.right = new Node(num);
			else
				defineNode(node.right, num);
		}
	}

}
