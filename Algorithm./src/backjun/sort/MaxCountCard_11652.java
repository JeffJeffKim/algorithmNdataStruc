package backjun.sort;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MaxCountCard_11652 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
//        System.out.println(Long.MAX_VALUE);
//        System.out.println(Long.MIN_VALUE);
//        System.out.println(Math.pow(2, 62));

        long result = 0;
        int maxCnt = 0;
        int tc = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();

        while (tc-- > 0) {
            long num = Long.parseLong(br.readLine());
            int cnt = 0 ;

            if (map.containsKey(num)) {
                cnt = map.get(num) + 1;
            } else {
                cnt = 1;
            }

            map.put(num, cnt);
            if (cnt >= maxCnt) {
                if (cnt == maxCnt && num < result) {
                    result = num;
                } else if (cnt > maxCnt) {
                    result = num;
                    maxCnt = cnt;
                }
            }
        }

        bw.write(result+"");
        br.close();
        bw.close();

    }
}
