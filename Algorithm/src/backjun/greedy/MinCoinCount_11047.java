// https://www.acmicpc.net/problem/11047

package backjun.greedy;

import java.util.Scanner;

public class MinCoinCount_11047 {
	
	static int N, target, result, coinList[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		target = sc.nextInt();
		coinList = new int[N];
		for(int i=0; i<N; i++) 
			coinList[i] = sc.nextInt();
		sc.close();
		
		getResult();
		System.out.println(result);
	}
	
	static void getResult() {
		int remain = target;
		for(int i=N-1; i>=0;) {
			if(remain == 0)
				break;
			if(coinList[i] > remain) {
				i--;
				continue;
			}
			remain -= coinList[i];
			result++;
		}
	}
	
}
