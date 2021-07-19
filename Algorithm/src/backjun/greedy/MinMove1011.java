package backjun.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class MinMove1011 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
//        getMove(1, 5);
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write(getMove(s, e)+"\n");
        }

        br.close();
        bw.close();
    }

    static int getMove(int s, int e) {
        int result = 0;
        int diff = e-s;
        int minus = 1;
        while (diff > 0) {
            diff -= minus;
            result++;
            if (diff > minus) {
                diff -= minus;
                result++;
            }

            if (diff > minus)
                minus++;
            else if (diff < minus)
                minus--;
        }

        return result;
    }
}
