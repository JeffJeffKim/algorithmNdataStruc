// https://www.acmicpc.net/problem/11004
package backjun.sort;

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.List;
import java.util.Scanner;

public class SortSearch_11004 {
	
	static int N, K;
	
	public static void main(String[] args) {
		int arr[] = getIn();
		System.out.println(quickSort(arr, 0, N-1));
//		quickSort(arr, 0, N-1);
//		for(int i : arr)
//			System.out.println(i);
	}
	
//	static void quickSort(int[] arr, int start, int end) {
//		if(start < end) {
//			int t = partition(arr, start, end);
//			quickSort(arr, start, t-1);
//			quickSort(arr, t+1, end);
//		}
//	}
	
	static int quickSort(int[] arr, int start, int end) {
		int pivot = partition(arr, start, end);
		if(pivot == K)	
			return arr[pivot];
		else if(pivot > K)
			return quickSort(arr, start, pivot-1);
		else
			return quickSort(arr, pivot+1, end);
	}
	
	static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int move = start-1; // move = -1
		for(int i=start; i<=end; i++) {
//			System.out.println("i : "+i+", arr[i] : " + arr[i]);
			if(arr[i] < pivot) {
				swap(arr, ++move, i);
				for(int temp : arr) {
//					System.out.print(temp+" ");
				}
//				System.out.println();					
			}
		}
		swap(arr, ++move, end);
		return move;
	}
	
	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	static int[] getIn() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		K = sc.nextInt()-1;
		int[] arr = new int[N];
		for(int i=0; i<N; i++) 
			arr[i] = sc.nextInt();
		sc.close();
		return arr;
	}

}
