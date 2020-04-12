// https://www.acmicpc.net/problem/5585

package backjun.greedy;

import java.util.Scanner;

public class MinRemainCount_5585 {
	
	static int pay = 1000;
	static int coin[] = new int[]{500, 100, 50, 10, 5, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int price = sc.nextInt();
		sc.close();
		
		int remain = pay - price;
		int count = 0;
		while(remain != 0) {
			for(int i=0; i<coin.length; ) {
				if(coin[i] > remain) {
					i++;
				}else {
					remain -= coin[i];
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
