// https://www.acmicpc.net/problem/11399

package backjun.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumWaitingTime_11399_1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i=0; i<N; i++) 
			arr[i] = sc.nextInt();
		sc.close();

		Arrays.sort(arr);
		// 1 2 3 3 4
		int sum = 0;
		int accu = 0;
		for (int i = 0; i < N; i++) {
			accu += arr[i];
			sum += accu;
		}
		System.out.println(sum);
	}
}
