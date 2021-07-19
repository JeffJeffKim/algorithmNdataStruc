package backjun.stack;

import java.io.*;
import java.util.Stack;

public class Zero10773 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int tc = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack();
        int sum = 0;
        while (tc-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                sum -= stack.pop();
            } else {
                stack.push(num);
                sum += num;
            }
        }
        bw.write(sum+"");

        br.close();
        bw.close();

    }
}
