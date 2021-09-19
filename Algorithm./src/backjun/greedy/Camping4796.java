package backjun.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Camping4796 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String strLine;
        StringTokenizer st;
        int caseNum = 0;
        while (++caseNum > 0) {
            strLine = br.readLine();
            st = new StringTokenizer(strLine, " ");
            int available = Integer.parseInt(st.nextToken());
            int period = Integer.parseInt(st.nextToken());
            int vacation = Integer.parseInt(st.nextToken());
            int sum = 0;

            if (available == 0 && period == 0 && vacation == 0) {
                break;
            }

            sum = vacation / period * available;
            sum += vacation % period;

            bw.write("Case " + caseNum + ": " + sum+"\n");
        }

//        br.close();
        bw.close();

    }


}
