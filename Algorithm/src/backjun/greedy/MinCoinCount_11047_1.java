// https://www.acmicpc.net/problem/11047

package backjun.greedy;

import java.util.Scanner;

public class MinCoinCount_11047_1 {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int target = sc.nextInt();
		int arr[] = new int[N];

		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
//			if (arr[i] > target) {
//				N = i-1;
//				break;
//			}
		}
		sc.close();

		int result = 0;
//		for (int i = N-1; i >= 0; ) {
//			if (target == 0) {
//				break;
//			} else if (target >= arr[i]) {
//				target -= arr[i];
//				result++;
//			} else {
//				i--;
//			}
//		}
		int idx = N-1;
		while (target > 0) {
			while (target >= arr[idx]) {
				target -= arr[idx];
				result++;
			}
			idx--;
		}
		System.out.println(result);
	}
	

	
}
