package backjun.greedy;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SickKnight_1783 {

    static int dir[][] = new int[][]{{2, 1}, {-2, 1}, {1, 2}, {-1, 2}}, N, M, result;

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // y
        M = sc.nextInt(); // x
        sc.close();

        boolean[][] map = new boolean[N][M];
        map[0][0] = true;

//        Queue<int[]> q = new ArrayDeque<>();
//        q.add(new int[]{0, 0, 1});
//
//        while (!q.isEmpty()) {
//            int[] cur = q.poll();
//            int y = cur[0];
//            int x = cur[1];
//            int move = cur[2];
//            for (int i = 0; i < dir.length; i++) {
//                int yy = y + dir[i][0];
//                int xx = x + dir[i][1];
//
//                if (yy < 0 || xx < 0 || yy >= N || xx >= M)
//                    continue;
//
//                if (map[yy][xx])
//                    continue;
//
//                if(++move > result)
//                    result = move;
//                q.add(new int[]{yy, xx, move});
//                move--;
//            }
//        }
        boolean[] way = new boolean[4];

        goNext(map, 0, 0, 1, way);
        System.out.println(result);
    }

    static void goNext(boolean[][] map, int x, int y, int move, boolean[] way){
        if (move > result)
            result = move;

        for (int i = 0; i < dir.length; i++) {
            int yy = y + dir[i][0];
            int xx = x + dir[i][1];

            if (yy < 0 || xx < 0 || yy >= N || xx >= M)
                continue;

            if (map[yy][xx])
                continue;

            way[i] = true;
            if (move > 3) {
                boolean possible = true;
                for (int j = 0; j < way.length; j++) {
                    if (!way[j]) {
                        possible = false;
                        break;
                    }
                }
                if (!possible){
                    way[i] = false;
                    continue;
                }
            }

            map[yy][xx] = true;
//            if(++move > result)
//                result = move;

            goNext(map, xx, yy, move+1, way);
            way[i] = false;
//            move--;
        }
    }
}
