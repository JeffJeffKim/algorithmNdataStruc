package backjun.mathmetic;

import java.io.*;
import java.util.StringTokenizer;

public class AbsoluteDifference_2420 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long num1 = Integer.parseInt(st.nextToken());
        long num2 = Integer.parseInt(st.nextToken());
        bw.write((long)Math.abs(num1 - num2)+"");

        br.close();
        bw.close();
    }
}
