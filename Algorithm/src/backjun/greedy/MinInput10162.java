package backjun.greedy;

import java.io.*;

public class MinInput10162 {

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        // 300, 60, 10
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        if (num % 10 != 0) {
            bw.write("-1");
            bw.close();
            return;
        }

        int[] divider = {300, 60, 10};
        int[] ans = new int[3];
        int idx = 0;
        while (num != 0) {
            if (divider[idx] <= num) {
                num -= divider[idx];
                ans[idx]++;
            } else {
                idx++;
            }
        }

        for (int n : ans) {
            bw.write(n + " ");
        }
        br.close();
        bw.close();
    }
}
