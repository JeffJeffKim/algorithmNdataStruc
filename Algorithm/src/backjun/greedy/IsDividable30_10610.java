// https://www.acmicpc.net/problem/10610
// not solved yet
package backjun.greedy;

import java.util.Scanner;

public class IsDividable30_10610 {
	
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String strNum = sc.nextLine(); 
		sc.close();
//		String strNum = "80875542";
		int[] numbers = new int[10];
		int total = 0;
		for(int i=0; i<strNum.length(); i++) {
			int cur = Integer.parseInt(strNum.substring(i, i+1));
			numbers[cur]++;
			total += cur;
		}
		
		if(!strNum.contains("0") || total%3 != 0) {
			System.out.println(-1);
		}else {
			StringBuffer sb = new StringBuffer();
			for(int i=9; i>=0; i--) {
				int cnt = numbers[i];
				while(cnt > 0) {
					sb.append(i);
					cnt--;
				}
			}
			System.out.println(sb.toString());
		}
	}

}
