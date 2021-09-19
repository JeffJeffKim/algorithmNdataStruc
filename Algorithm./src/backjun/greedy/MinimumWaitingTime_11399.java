// https://www.acmicpc.net/problem/11399

package backjun.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumWaitingTime_11399 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i=0; i<N; i++) 
			arr[i] = sc.nextInt();
		sc.close();
		
		Arrays.sort(arr);
		int accu[] = new int[N];
		accu[0] = arr[0];
		int sum = accu[0];
		for(int i=1; i<N; i++) {
			accu[i] = accu[i-1] + arr[i];
			sum += accu[i];
		}
		System.out.println(sum);
	}
}
