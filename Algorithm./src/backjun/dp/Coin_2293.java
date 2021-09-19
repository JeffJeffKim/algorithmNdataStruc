// https://www.acmicpc.net/problem/2293

package backjun.dp;

import java.util.Scanner;

public class Coin_2293 {
	
	static int target, sort[];
	
	public static void main(String[] args) {
		getIn();
		int[] result = new int[target+1];
		
		result[0] = 1;
		for(int coin : sort) 
			for(int i=1; i<target+1; i++) 
				if(coin <= i) 
					result[i] += result[i-coin];
		
		System.out.println(result[target]);
	}
	
	static void getIn() {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		target = sc.nextInt();
		sort = new int[N];
		for(int i=0; i<N; i++) 
			sort[i] = sc.nextInt();
		
		sc.close();
	}

}
