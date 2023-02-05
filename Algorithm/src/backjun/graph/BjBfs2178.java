//https://www.acmicpc.net/problem/2178

package backjun.graph;

import java.util.*;

public class BjBfs2178 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> map = new ArrayList<>();
        int sizeY = sc.nextInt();
        int sizeX = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < sizeY; i++) {
            List<Integer> curRow = new ArrayList<>();
            String strCurLine = sc.nextLine();
            for (int j = 0; j < sizeX; j++) {
                curRow.add(Integer.parseInt(String.valueOf(strCurLine.charAt(j)))*10000000);
            }
            map.add(curRow);
        }
        sc.close();

        int result = 0;

        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1,0,0};
        int curX = 0, curY = 0;
        Queue<Spot> pq = new PriorityQueue<Spot>((s1, s2) -> s1.dist - s2.dist);
        Spot start = new Spot(1, 0, 0);
        pq.add(start);
        while (!pq.isEmpty()) {
            Spot curSpot = pq.poll();
            if (curSpot.x == sizeX - 1 && curSpot.y == sizeY - 1)
                break;

            for (int i = 0; i < 4; i++) {
                int nextX = curSpot.x + dx[i];
                int nextY = curSpot.y + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= sizeX || nextY >= sizeY) continue;
                if (map.get(nextY).get(nextX) == 0) continue;
                if (map.get(nextY).get(nextX) <= curSpot.dist + 1) continue;

                map.get(nextY).set(nextX, curSpot.dist + 1);
                pq.add(new Spot(curSpot.dist + 1, nextX, nextY));
            }
        }

        System.out.println(map.get(sizeY-1).get(sizeX-1));
    }

    public static class Spot {
        int dist;
        int x,y;

        public Spot(int dist, int x, int y) {
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }
}
