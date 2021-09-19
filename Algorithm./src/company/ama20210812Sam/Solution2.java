package company.ama20210812Sam;

import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
//        System.out.println(maxEvents(Arrays.asList(1, 3, 3, 5, 7), Arrays.asList(2, 2, 1, 2, 1)));
//        System.out.println(maxEvents(Arrays.asList(1, 3, 5), Arrays.asList(2, 2, 2)));
//        System.out.println(maxEvents(Arrays.asList(1), Arrays.asList(1)));
        System.out.println(maxEvents(Arrays.asList(978,409,229,934,299,982,636,14 ,866,815,64 ,537,426,670,116,95 ,630), Arrays.asList(502,518,196,106,405,452,299,189,124,506,883,753,567,717,338,439,145)));
    }

    /*
     * Complete the 'maxEvents' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arrival
     *  2. INTEGER_ARRAY duration
     */

    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        int result = 0;

        Node[] arr = new Node[arrival.size()];
        for (int i = 0; i < arrival.size(); i++) {
            arr[i] = new Node(arrival.get(i), arrival.get(i) + duration.get(i));
        }
        Arrays.sort(arr);

        int end = 0;
        for (Node cur : arr) {
            if (end > cur.s)
                continue;

            end = cur.e;
            result++;
        }

        return result;
    }

    static class Node implements Comparable<Node> {
        int s;
        int e;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Node tar) {
            if (tar.e > this.e)
                return -1;
            if (tar.e < this.e)
                return 1;
            if (tar.s > this.s)
                return -1;
            if (tar.s < this.s)
                return 1;
            return 0;
        }
    }
}
