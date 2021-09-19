package practice;

public class ReverseLinkedList {

    static class Node {
        int n;
        Node next;

        public Node(int n) {
            this.n = n;
            this.next = null;
        }
    }

    static void printNode(Node node) {
        while (node != null) {
            System.out.print(node.n + " ");
            node = node.next;
        }
        System.out.println();
    }

    static Node reverse(Node node) {

        Node prev = null;
        Node next = null;
        Node cur = node;
        while (cur != null) {
            // c: 1,2,3,4 : 2,3,4 : 3,4 :  4
            next = cur.next; // 2,3,4 : 3,4 : 4 : null
            cur.next = prev; // null : 1,null : 2,1,null : 3,2,1,null
            prev = cur; // 1,null : 2,1,null : 3,2,1,null : 4
            cur = next; // 2,3,4 : 3,4 : 4 : null
        }
//        node = prev;
        return prev;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);

        printNode(root);
//        reverse(root);
        root = reverse(root);
        printNode(root);

    }
}
