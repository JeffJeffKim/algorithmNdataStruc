import java.util.ArrayList;
import java.util.List;

public class TripStackCodingTest {
	
	public static void main(String[] args) {
		Node node8 = new Node(8);
		Node node7 = new Node(7, node8);
		Node node6 = new Node(6, node7);
		Node node5 = new Node(5, node6);
		Node node4 = new Node(4, node5);
		Node node3 = new Node(3, node4);
		Node node2 = new Node(2, node3);
		Node node1 = new Node(1, node2);
		
		solution(node1);
	}
	
	static void solution(Node node) {
//		list : delete a node, 8
		// unique, last node dont have next
		
		int delNum = 6;
		
		List<Integer> list = new ArrayList<>();
		if(node.val != delNum)
			list.add(node.val);
		
		Node next = node.next;
		while(next != null) {
//			if() {
			list.add(next.val);
//		}
			
			next = node.next;
		}
		
		
	}
	
	static class Node {
		int val;
		Node next;
		public Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
		public Node(int val) {
			this.val = val;
		}
		public Node() {
		}
	}

}
