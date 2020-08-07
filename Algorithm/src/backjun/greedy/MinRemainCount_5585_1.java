package backjun.greedy;

import java.util.Scanner;

public class MinRemainCount_5585_1 {
	
	public static void main(String[] args) {
		System.out.println(getCount(getInput()));
	}
	
	static int getCount(int price) {
		final int[] COINS = new int[]{500, 100, 50, 10, 5, 1};
		int pay = 1000-price, count = 0, idx = 0;
		while(pay > 0) {
			while(pay >= COINS[idx]) {
				pay -= COINS[idx];
				count++;
			}
			idx++;
		}
		return count;
	}
	
	static int getInput() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		return N;
	}

}
