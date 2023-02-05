//https://www.acmicpc.net/problem/2178

package backjun.graph;

import java.util.*;

public class BjBfs2178_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tY = sc.nextInt();
        int tX = sc.nextInt();
        sc.nextLine();
        List<ArrayList<Integer>> map = new ArrayList<>();
        for (int i = 0; i < tY; i++) {
            map.add(new ArrayList());
            String cur = sc.nextLine();
            for (int j = 0; j < tX; j++) {
                map.get(i).add(j, Integer.parseInt(cur.substring(j, j+1)) * Integer.MAX_VALUE);
            }
        }
        sc.close();

        Queue<Spot> pq = new PriorityQueue<Spot>((s1, s2) -> s1.dist - s2.dist);
        pq.add(new Spot(0,0,1));
        int[] dx = new int[]{0,0,-1,1}, dy = new int[]{-1,1,0,0};

        while (!pq.isEmpty()) {
            Spot cSpot = pq.poll();
            if (cSpot.x == tX-1 && cSpot.y == tY-1)
                break;

            for (int i = 0; i < 4; i++) {
                int nX = cSpot.x + dx[i], nY = cSpot.y + dy[i];
                if (nX < 0 || nY < 0 || nX >= tX || nY >= tY) continue;
                if (map.get(nY).get(nX) == 0 || map.get(nY).get(nX) <= cSpot.dist + 1) continue;

                map.get(nY).set(nX, cSpot.dist + 1);
                pq.add(new Spot(nX, nY, cSpot.dist + 1));
            }

        }
        System.out.println(map.get(tY-1).get(tX-1));
    }

    static class Spot {
        int x,y,dist;

        public Spot(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

}
