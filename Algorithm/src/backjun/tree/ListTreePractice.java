package backjun.tree;

import java.util.ArrayList;
import java.util.List;

public class ListTreePractice {

    static class Node {
        List<Integer> list;
        List<Node> subs;
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.subs = new ArrayList<>();
        root.subs.add(new Node());
        root.subs.add(new Node());
        root.subs.get(0).list = List.of(1, 2, 3);
        root.subs.get(1).list = List.of(4, 5);

//        root.list = new ArrayList<>();
//        root.list.addAll(root.subs.get(0).list);
//        root.list.addAll(root.subs.get(1).list);
//        for (int num : root.list) {
//            System.out.println(num);
//        }
        for (Node node : root.subs) {
            System.out.println(node.list);
        }
    }
}
