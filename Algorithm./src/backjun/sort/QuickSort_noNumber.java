package backjun.sort;

import java.util.Scanner;

public class QuickSort_noNumber {
	
	public static void main(String[] args) {
		int arr[] = getIn();
		quickSort(arr, 0, arr.length-1);
		for(int i : arr)
			System.out.print(i+" ");
	}
	
	static void quickSort(int[] arr, int start, int end) {
		if(start < end) {
			int pivot = partition(arr, start, end);
			quickSort(arr, start, pivot-1);
			quickSort(arr, pivot+1, end);
		}
	}
	
	static int partition(int[] arr, int start, int end) {
		int cnt = start-1;
		for(int i=start; i<end; i++) {
			if(arr[i] < arr[end]) {
				swap(arr, i, ++cnt);
			}
		}
		swap(arr, end, ++cnt);
		return cnt;
	}
	
	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
//	9
//	5 3 8 4 9 1 6 2 7
	static int[] getIn() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int[] arr = new int[N];
		for(int i=0; i<N; i++) 
			arr[i] = sc.nextInt();
		sc.close();
		return arr;
	}

}
