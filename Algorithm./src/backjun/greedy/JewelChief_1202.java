package backjun.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class JewelChief_1202 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cntJewel = Integer.parseInt(st.nextToken());
        int cntBag = Integer.parseInt(st.nextToken());

        Node[] jewels = new Node[cntJewel];

        for (int i = 0; i < cntJewel; i++) {
            st = new StringTokenizer(br.readLine());
            int weigh = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels[i] = new Node(weigh, value);
        }

        Arrays.sort(jewels);

        LinkedList<Integer> bags = new LinkedList<>();
        boolean[] isUsed = new boolean[cntBag];
        for (int i = 0; i < cntBag; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(bags);


        long result = 0;
        for (Node jewel : jewels) {
            int val = jewel.value;
            int weight = jewel.weigh;
            if (weight > bags.get(bags.size() - 1)) {
                continue;
            }
            int idx = devideQunquer(bags, weight, isUsed);
            if (idx != -1) {
                bags.remove(idx);
                result += val;
            }
            if (bags.size() == 0) {
                break;
            }
        }

        bw.write(result+"");

        br.close();
        bw.close();
    }

    static int devideQunquer(LinkedList<Integer> bags, int val, boolean[] isUsed) {
        int s = 0;
        int e = bags.size() -1;
        int prev = -1;

        while (val <= bags.get(e)) {
            if (s > e) {
                break;
            }

            prev = e;
            int mid = (s + e) / 2;

            if (s == e) {
                if (prev > s && prev <bags.size()) {
                    s++;
                    e = prev;
                    continue;
                } else {
                    break;
                }
            }

            if (bags.get(mid) >= val) {
                e = mid;
            } else {
                s = mid+1;
            }
        }

        return prev;
    }

    static class Node implements Comparable<Node> {
        int weigh;
        int value;

        public Node(int weigh, int value) {
            this.weigh = weigh;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if (o.value > this.value)
                return 1;
            else if (o.value < this.value)
                return -1;
            else if (o.weigh < this.weigh)
                return 1;
            else if (o.weigh > this.weigh)
                return -1;
            else
                return 0;
        }
    }
}
