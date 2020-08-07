package backjun.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ArrangeMeeting_1931_2 {
	
	public static void main(String[] args) {
		int[][] arr = getInput();
		sort(arr);
		System.out.println(getCount(arr));
	}
	
	static int getCount(int[][] arr) {
		int end=-1, count=0;
		for(int i=0; i<arr.length; i++) {
			if(end < arr[i][0]) {
				count++;
				end = arr[i][1];
			}
		}
		return count;
	}
	
	static void sort(int[][] arr) {
		Arrays.sort(arr, Comparator.comparing(i -> i[1]));
	}
	
	static int[][] getInput() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		sc.close();
		return arr;
	}

}
