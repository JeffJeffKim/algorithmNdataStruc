package practice;

// https://www.geeksforgeeks.org/amazon-interview-set-89/
// https://stackoverrun.com/ko/q/7121389
// https://www.acmicpc.net/problem/1572
public class ReverseTree {
	
	static class Tree {
		String data;
		Tree left, right;
		public Tree(String data) {
			this.data = data;
		}
	}
	static Tree root;
	static Tree mirror;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) {
		
		String arr[] = "a b c d e f g h i j k l m n o".split(" ");
		makeGivenTree();
		preOrder(root);
	}
	
	static void reverse(Tree node, int h) {
		if(node == null)	return;

		sb.append(node.data);
		if(h%2 == 0) {
			reverse(node.left, h+1);
			reverse(node.right, h+1);	
		}else {
			reverse(node.right, h+1);
			reverse(node.left, h+1);
		}
	}
	
	static void preOrder(Tree node) {
		System.out.println(node.data);
		if(node.left != null)
			preOrder(node.left);
		if(node.right != null)
			preOrder(node.right);
	}
	
	static void makeGivenTree() {
		root = new Tree("a");
		root.left = new Tree("b");
		root.right = new Tree("c");
		
		root.left.left = new Tree("d");
		root.left.right = new Tree("e");
		
		root.right.left = new Tree("f");
		root.right.right = new Tree("g");
		
		root.left.left.left = new Tree("h");
		root.left.left.right = new Tree("i");
		root.left.right.left = new Tree("j");
		root.left.right.right = new Tree("k");
		
		root.right.left.left = new Tree("l");
		root.right.left.right = new Tree("m");
		root.right.right.left = new Tree("n");
		root.right.right.right = new Tree("o");
	}

}
