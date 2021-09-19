package company.igt;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution20210907 {

    /*...
    new line git test purpose tears
    Given a 2D array, return the number with longest cluster.
    A cluster of the same number adjacent horizontally, vertically, or diagonally.
    If the chain is identical return the lower number.
    Content of the cells are guaranteed to be positive.

    Input:
    [[1,4,2,2],
     [1,2,4,4],
     [3,4,1,1],
     [3,4,3,3]]
    Output: 4
    4: 5, 2: 3

    1 == 100
    [1, 1, 1]
    [2, 2, 2, 2]
    [3, 3, 3, 3, 3]
    10 > 1 > 4 > 3

    [[1,4,2,2],
     [1,2,4,4],
     [2,4,1,1],
     [2,4,3,3]]
     4: 5, 2: 5  => 2 lower num

    Input:
    [[1,4,2,2],
     [1,2,4,4],
     [1,4,1,1],
     [3,3,3,3]]
    Output: 3
     */

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,4,2,2},
                {1,2,4,4},
                {1,4,1,1},
                {3,3,3,3}};

        System.out.println(getNumber(arr));

    }

    public static int getNumber(int[][] arr) {
        int result = 0;
        int maxRepeatedCnt = 0;

        // 8-dir arr
        // check oo bounce
        // updated to 0, -1
        // queue (row, col)
        // same number exist -> keep going
        // check maximum count and compare privous result

        final int[][] DIRECTION = new int[][]{{1, 0}, {1, -1}, {1, 1}, {0, -1}, {0, 1}, {-1, 0}, {-1, -1}, {-1, 1}};

        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }

                q.add(new int[]{i, j});
                int num = arr[i][j];

                int repeatedCnt = 0;

                while (!q.isEmpty()) {

                    int[] loc = q.poll();
                    int row = loc[0];
                    int col = loc[1];

                    for (int d = 0; d < DIRECTION.length; d++) {
                        int yy = row + DIRECTION[d][0];
                        int xx = col + DIRECTION[d][1];

                        // oo bounce
                        if (xx < 0 || yy < 0 || yy >= arr.length || xx >= arr[0].length) {
                            continue;
                        }

                        if (num != arr[yy][xx]) {
                            continue;
                        }

                        repeatedCnt++;

                        // updated to 0, -1
                        arr[yy][xx] = 0;
                        // add q
                        q.add(new int[]{yy, xx});
                    }
                }
                    // same number exist -> keep going
                    // check maximum count and compare privous result

                if (repeatedCnt > maxRepeatedCnt) {
                    // update
                    result = num;
                    maxRepeatedCnt = repeatedCnt;
                } else if (repeatedCnt == maxRepeatedCnt) {
                    if (num < result) {
                        // update
                        result = num;
                        maxRepeatedCnt = repeatedCnt;
                    }
                }
            }
        }

        return result;
    }


}
