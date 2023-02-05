// https://www.acmicpc.net/problem/11399

package backjun.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MinimumWaitingTime_11399_2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i=0; i<N; i++) 
			arr[i] = sc.nextInt();
		sc.close();

		Arrays.sort(arr);
		int sum = 0;
		for (int cur : arr) {
			sum += cur*N--;
		}

		System.out.println(sum);
	}
}
