// https://www.acmicpc.net/problem/2217

package backjun.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class RopeMaxWeight_2217 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i=0; i<N; i++) 
			arr[i] = sc.nextInt();
		sc.close();
		
		int max = 0;
		Arrays.sort(arr);
		
		for(int i=0; i<N; i++) {
			int cur = arr[i] * (N-i);
			if(cur > max)
				max = cur;
		}
		
		System.out.println(max);
	}
}
