package backjun.graph;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class IslandCount_4963 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dir = {{-1,0}, {-1,1}, {-1, -1}, {1,0}, {1, 1}, {1,-1}, {0,1}, {0,-1}};

    public static void main(String[] args) throws IOException {
        while (true) {
            int result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            int[][] map = new int[h][w];
            for (int y = 0; y < h; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < w; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    if (map[y][x] == 0) {
                        continue;
                    }

                    naighborSearch(map, y, x);
                    result++;
                }
            }

            bw.write(result+"\n");
        }

        br.close();
        bw.close();
    }

    static void naighborSearch(int[][] map, int y, int x) {
        map[y][x] = 0;
        Queue<int[]> q = new ArrayDeque();
        q.add(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            y = cur[0];
            x = cur[1];

            for (int i = 0; i < dir.length; i++) {
                int yy = y + dir[i][0];
                int xx = x + dir[i][1];

                if (yy < 0 || xx < 0 || yy >= map.length || xx >= map[0].length) {
                    continue;
                }

                if (map[yy][xx] == 0) {
                    continue;
                }

                map[yy][xx] = 0;
                q.add(new int[]{yy, xx});
            }
        }
    }
}
