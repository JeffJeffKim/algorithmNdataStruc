package backjun.greedy;

import java.io.*;

public class WordSearch_1543 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String whole = br.readLine();
        String key = br.readLine();

        int len = key.length();
        int result = 0;
        for (int i = 0; i < whole.length() - len + 1; ) {
            if (whole.substring(i, i+len).equals(key)) {
                result++;
                i += len;
            } else {
                i++;
            }
        }
        bw.write(result+"");

        br.close();
        bw.close();
    }
}
