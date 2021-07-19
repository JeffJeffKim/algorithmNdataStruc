package backjun.stack;

import java.io.*;
import java.util.Stack;

public class SteelStick_10799 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        boolean preOpen = false;
        Stack<Character> stack = new Stack<>();
        long sum = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == ')') {
                if (preOpen) {
                    sum += stack.size()-1;
                } else {
                    sum++;
                }
                preOpen = false;
                stack.pop();
            } else {
                preOpen = true;
                stack.push('(');
            }
        }
        bw.write(sum+"");

        br.close();
        bw.close();
    }
}
