// https://www.acmicpc.net/problem/9012

package backjun.stack;

import java.util.Scanner;
import java.util.Stack;

public class Parenthesis_9012 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<N; i++)
			isPair(sc.nextLine());
		sc.close();
	}
	
	static void isPair(String str) {
		Stack<Character> st = new Stack<Character>();
		for(int i=0; i<str.length(); i++) {
			char cur = str.charAt(i);
			if(cur == '(')
				st.push(cur);
			else {
				try {
					if(st.pop() != '(') {
						System.out.println("NO");
						return;
					}
				}catch(Exception e) {
					System.out.println("NO");
					return;
				}
			}
		}
		if(st.isEmpty())
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
