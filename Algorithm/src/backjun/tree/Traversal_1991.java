package backjun.tree;

import java.util.Scanner;

public class Traversal_1991 {
	
	public static class Tree {
		String word;
		Tree left, right;
		public Tree (String word) {
			this.word = word;
		}
	}
	
	static Tree root;
	
	static void add(String str) {
		String words[] = str.split(" ");
		if(root == null) {
			root = new Tree(words[0]);
			if(!words[1].equals("."))
				root.left = new Tree(words[1]);
			if(!words[2].equals("."))
				root.right = new Tree(words[2]);
		}else {
			search(root, words);
		}
	}
	
	static boolean search(Tree node, String[] words) {
		if(node == null)	return false;
		
		if(node.word.equals(words[0])) {
			if(!words[1].equals("."))
				node.left = new Tree(words[1]);
			if(!words[2].equals("."))
				node.right = new Tree(words[2]);
			return true;
		}
		
		if(!search(node.left, words))
			search(node.right, words);
		return false;
	}
	
	static void preOrder(Tree node) {
		System.out.print(node.word);
		if(node.left != null)
			preOrder(node.left);
		if(node.right != null)
			preOrder(node.right);
	}
	
	static void inOrder(Tree node) {
		if(node.left != null)
			inOrder(node.left);
		System.out.print(node.word);
		if(node.right != null)
			inOrder(node.right);
	}
	
	static void postOrder(Tree node) {
		if(node.left != null)
			postOrder(node.left);
		if(node.right != null)
			postOrder(node.right);
		System.out.print(node.word);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<N; i++) {
			String str = sc.nextLine();
			add(str);
		}
		sc.close();
		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		postOrder(root);
	}
}
