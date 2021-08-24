package backjun.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TapeCount_1449 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // leaking count
        int L = Integer.parseInt(st.nextToken()); // tape length

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int prev = 0;
        int result = 0;
        for (int i = 0; i < N; i+=2) {
            int a = arr[i];
            int b = arr[i+1];

            if (prev >= a)
                continue;

            prev = a;
            int len = b - prev + 1;

            int count = len / L;
            if (len % L != 0)
                count++;
            result += count;

            prev = a + (count * L) - 1;
        }
        bw.write(result+"");

        br.close();
        bw.close();
    }
}

//for (int i = 0; i < N; i+=2) {
//        double a = Double.parseDouble(st.nextToken())-0.5;
//        double b = Double.parseDouble(st.nextToken())+0.5;
//
//        if (prev > a) {
//        a = prev;
//        }
//
//        if (prev > b) {
//        continue;
//        }
//        double len = b-a;
//
//        result += len / L;
//        if (len % L != 0)
//        result++;
//
//        prev = a + len * L;
//        if (len % L != 0)
//        prev += L;
//        }
