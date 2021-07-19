package backjun.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class OptimizeMeeting_1931 {

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Math.pow(2,31)-1);
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        ArrayList<Node> nodes = new ArrayList<>();
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            nodes.add(new Node(s, e));
        }

        Collections.sort(nodes);
        int ans = 0;
        int e = -1;
        for (Node node : nodes) {
            if (node.s >= e) {
                ans++;
                e = node.e;
            }
        }
        bw.write(ans+"");
        bw.close();
    }

    static class Node implements Comparable<Node> {
        int s;
        int e;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Node o) {
            if (this.e == o.e) {
                return this.s - o.s;
            }
            return this.e - o.e;
        }
    }
}
