//https://www.acmicpc.net/problem/1012
package backjun.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BjDfs1012 {

    static int[] dx = new int[]{0,0,-1,1}, dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int tIdx = 0; tIdx < tc; tIdx++) {
            int lx = sc.nextInt();
            int ly = sc.nextInt();
            int cnt = sc.nextInt();

            List<List<Integer>> map = getTcIn(sc, lx, ly, cnt);
            int result = 0;
            for (int sy = 0; sy < ly; sy++) {
                for (int sx = 0; sx < lx; sx++) {
                    if (map.get(sy).get(sx) == 1) {
                        map.get(sy).set(sx, 0);
                        dp(map, sx, sy, lx, ly);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
        sc.close();
    }

    static void dp(List<List<Integer>> map, int x, int y, int lx, int ly) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= lx || ny >= ly) continue;
            if (map.get(ny).get(nx) == 0) continue;
            map.get(ny).set(nx, 0);
            dp(map, nx, ny, lx, ly);
        }
    }

    static List<List<Integer>> getTcIn(Scanner sc, int lx, int ly, int cnt) {
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < ly; i++) {
            List<Integer> sub = new ArrayList<>();
            map.add(sub);
            for (int j = 0; j < lx; j++) {
                sub.add(0);
            }
        }

        for (int i = 0; i < cnt; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map.get(y).set(x, 1);
        }
        return map;
    }
}
