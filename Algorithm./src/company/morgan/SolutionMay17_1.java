package company.morgan;

import java.util.LinkedList;
import java.util.List;

public class SolutionMay17_1 {
	
	static final int SEARCH_NUM = 3;
	static int size = 0;
	
    public static class Node {
        Node nextPrt;
        int value;
       
        Node(Node nextPrt, int value) {
            this.nextPrt = nextPrt;
            this.value = value;
        }
    }
 
    public static void main(String [] args) {
 
        Node A = new Node(null, 0);
        Node B = new Node(A, 1);
        Node C = new Node(B, 2);
        Node D = new Node(C, 3);
        Node E = new Node(D, 4);
        Node HEAD = new Node(E, 5);
        
        findSize(HEAD);
        System.out.println(size);
        Node node = recursive(HEAD, size - SEARCH_NUM);
        System.out.println(node.value);
        
        
       
        //We want to write a function to find the THIRD element from the end a Linked List (see Node class above).
        //There's an example dataset provided in the main function but it could be of any depth so the function has to
        //handle N number of items in the list.
       
        //Requirements:
        // - Find third element from the end of the linked list.
        // - Do not iterate over the list more than twice and ideally we would iterate through it just once.
    }
    
//    static Node findLastThirdNode(Node node) {
//    	// iterate
//    }
    
    static Node recursive(Node node, int idx) {
    	// itr
    	int target = 0;
    	while(target != idx) {
    		target++;
    		node = node.nextPrt;
    	}

    	return node;
    }
    
    static void findSize(Node node) {
    	while(node.nextPrt != null) {
    		node = node.nextPrt;
    		size++;
    	}
    	size++;
    }

}
