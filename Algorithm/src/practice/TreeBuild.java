package practice;

import practice.ReverseTree.Tree;

public class TreeBuild {
	
	static class Tree {
		String data;
		Tree left, right;
		public Tree(String data) {
			this.data = data;
		}
	}
	static Tree root;
	static Tree newTree;
	static Tree reverse;
	static StringBuffer sb = new StringBuffer();
	static String str;
	static boolean visit[];
	static String[] arrData;
	
	public static void main(String[] args) {
		makeGivenTree();
//		preOrder(root);
		lastOrder(root);
		System.out.println(sb);
		int h = 4;
		int idx = (int)Math.pow(2, h)-1-1;
		visit = new boolean[(int)Math.pow(2, h)-1];
		str = sb.toString();
		newTree = new Tree(str.substring(idx, idx+1)); 
		buildTree(newTree, idx, h-1);
		sb=new StringBuffer();
		lastOrder(newTree);
		System.out.println(sb);
		
		
		arrData = new String[(int)Math.pow(2, h)-1];
	}
	
	static void collectArr(Tree node, int h) {
		boolean isFindH = false;
		int sIdx[];
		if(node.left != null)
			collectArr(node.left, h+1);
		if(!isFindH) {
			isFindH = true;
			sIdx = new int[h];
		}
		
	}
	
	
	
	
	
	
	
	
	
	static void buildTree(Tree node, int prev, int h) {
		int idx = prev - (int)Math.pow(2, h);
		if(idx < 0 || idx > str.length()-1)	return;
		
		if(visit[idx])	return;
		node.left = new Tree(str.substring(idx, idx+1));
		visit[idx] = true;
		buildTree(node.left, idx, h-1);
		
		idx = prev -1;
		node.right = new Tree(str.substring(idx, idx+1));
		visit[idx] = true;
		buildTree(node.right, idx, h-1);
	}
	
	static void lastOrder(Tree node) {
		if(node.left != null)
			lastOrder(node.left);
		if(node.right != null)
			lastOrder(node.right);
		sb.append(node.data);
	}
	
	static void preOrder(Tree node) {
//		System.out.println(node.data);
		sb.append(node.data);
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
