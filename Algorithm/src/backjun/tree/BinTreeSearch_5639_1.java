// https://www.acmicpc.net/problem/5639
package backjun.tree;

public class BinTreeSearch_5639_1 {

	public static void main(String[] args) {
		Node root = null;
		int arr[] = {50, 30, 24, 5, 28, 45, 98, 52, 60};
		for (int num : arr) {
			if (root == null) {
				root = new Node(num);
			} else {
				init(root, num);
			}
		}
		System.out.println("post");
		postS(root);

		System.out.println("prev");
		prevS(root);

		System.out.println("mid");
		midS(root);
	}

	static void midS(Node node) {
		if (node.prev != null) {
			midS(node.prev);
		}

		System.out.println(node.n);

		if (node.next != null) {
			midS(node.next);
		}
	}

	static void prevS(Node node) {
		System.out.println(node.n);
		if (node.prev != null) {
			prevS(node.prev);
		}
		if (node.next != null) {
			prevS(node.next);
		}

	}

	static void postS(Node node) {
		if (node.prev != null) {
			postS(node.prev);
		}

		if (node.next != null) {
			postS(node.next);
		}

		System.out.println(node.n);
	}

	static void init(Node node, int num) {

		if (num > node.n) {
			if (node.next == null) {
				node.next = new Node(num);
			} else {
				init(node.next, num);
			}
		} else {
			if (node.prev == null) {
				node.prev = new Node(num);
			} else {
				init(node.prev, num);
			}
		}
	}
	
	static class Node {
		int n;
		Node prev;
		Node next;

		public Node(int n) {
			this.n = n;
		}
	}
}
