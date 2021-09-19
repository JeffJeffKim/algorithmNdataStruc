package practice;

public class ReversedLinkedList_2 {

    static class Node {
        int n;
        Node next;

        public Node(int n) {
            this.n = n;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);

        printNode(root);
        root = reverse(root);
        printNode(root);
    }

    static Node reverse(Node node) {
        Node prev = null;
        Node cur = node;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    static void printNode(Node node) {
        Node next = node;
        while (next != null) {
            System.out.print(next.n + " ");
            next = next.next;
        }
        System.out.println();
    }
}
