package backjun.greedy;

import java.io.*;

public class UpsideDown_1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String inStr = br.readLine();

        int countZeroGroup = 0;
        int countOneGroup = 0;

        char prev = ' ';

        for (int i = 0; i < inStr.length(); i++) {
            char cur = inStr.charAt(i);
            if (prev != cur) {
                prev = cur;
                if (cur == '0')
                    countZeroGroup++;
                else
                    countOneGroup++;
            }
        }

        int result = countOneGroup > countZeroGroup ? countZeroGroup : countOneGroup;
        bw.write(result+"");
        br.close();
        bw.close();
    }
}
