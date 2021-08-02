package pro;

import java.io.*;
import java.util.StringTokenizer;

public class SectionSum_2042_3 {

    static int[] tree;
    static int[] arrInput;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int updateCnt = Integer.parseInt(st.nextToken());
        int renderCnt = Integer.parseInt(st.nextToken());
        int cnt = updateCnt + renderCnt;

        arrInput = new int[numCnt + 1];
        for (int i = 1; i <= numCnt; i++) {
            arrInput[i] = Integer.parseInt(br.readLine());
        }

        int pow = (int) Math.ceil(Math.log(numCnt) / Math.log(2)) +1;
        int size = (int) Math.pow(2, pow);
        tree = new int[size];

        init(1, 1, numCnt);

        while (cnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int formular = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            if (formular == 1) {
                int diff = val - arrInput[idx];
                arrInput[idx] = val;
                update(1, 1, numCnt, idx, diff);
            } else {
                int sum = sum(1, 1, numCnt, idx, val);
                bw.write(sum+"\n");
            }
        }

        br.close();
        bw.close();

    }

    static int init(int idx, int s, int e) {
        if (s >= e) {
            return tree[idx] = arrInput[s];
        }

        int mid = (s + e) / 2;
        return tree[idx] = init(idx * 2, s, mid) + init(idx * 2 + 1, mid + 1, e);
    }

    static void update(int idx, int s, int e, int loc, int diff) {
        if (loc < s || e < loc) {
            return;
        }

        if (s <= loc && loc <= e) {
            tree[idx] += diff;
        }

        if (s >= e) {
            return;
        }

        int mid = (s + e) / 2;
        update(idx * 2, s, mid, loc, diff);
        update(idx * 2 + 1, mid + 1, e, loc, diff);
    }

    static int sum(int idx, int s, int e, int l, int r) {
        if (l <= s && e <= r) {
            return tree[idx];
        }

        if (l > e || r < s) {
            return 0;
        }

        if (s >= e) {
            return 0;
        }

        int mid = (s + e) / 2;
        return sum(idx * 2, s, mid, l, r) + sum(idx * 2 + 1, mid + 1, e, l, r);
    }

}
