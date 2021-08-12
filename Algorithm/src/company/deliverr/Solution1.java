package company.deliverr;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution1 {
    public static int  maxDaysToWork(int[] countTown)
    {
        int  answer = 0;
        // Write your code here

        Queue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < countTown.length; i++) {
            q.add(new int[]{i, countTown[i]});
        }

        int prevTown = -1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (prevTown == cur[0]) {
                if (!q.isEmpty()) {
                    int[] nextCur = q.poll();
                    q.add(cur);
                    cur = nextCur;
                } else {
                    break;
                }
            }

            answer++;
            cur[1]--;
            prevTown = cur[0];
            if(cur[1] > 0)
                q.add(cur);
        }

        return answer;
    }

    public static void main(String[] args)
    {
        int countTown[] = {7,2,3};
        int result = maxDaysToWork(countTown);
        System.out.print(result);
//        Scanner in = new Scanner(System.in);
//        //input for countTown
//        int countTown_size = in.nextInt();
//        int countTown[] = new int[countTown_size];
//        for(int idx = 0; idx < countTown_size; idx++)
//        {
//            countTown[idx] = in.nextInt();
//        }


    }
}
