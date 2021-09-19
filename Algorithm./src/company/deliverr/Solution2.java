package company.deliverr;

import java.util.*;

public class Solution2 {
    public static void main(String args[] ) {
        // Use either of these methods for input

        //BufferedReader
        Scanner s = new Scanner(System.in);
        String name1 = s.nextLine();
//        N,M,K: friends
        String[] firstLine = name1.split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        int friendsCnt = Integer.parseInt(firstLine[2]);

        int cakeCnt = N*M;
        boolean isTaken[] = new boolean[cakeCnt + 1];
        Queue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparing(l -> l.size()));

        for (int i = 0; i < friendsCnt; i++) {
            List<Integer> list = new ArrayList<>();
            String line = s.nextLine();
            String[] fav = line.split(" ");
            for (int j = 1; j < fav.length; j++) {
                list.add(Integer.parseInt(fav[j]));
            }
            pq.add(list);
        }

        int result = 0;

        while (!pq.isEmpty()) {
            List<Integer> list = pq.poll();
            for (int num : list) {
                if (!isTaken[num]) {
                    result++;
                    isTaken[num] = true;
                    break;
                }
            }
        }

        System.out.println(result);    // Write output to STDOUT

    }
}
