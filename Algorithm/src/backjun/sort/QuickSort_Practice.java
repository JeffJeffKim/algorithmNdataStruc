package backjun.sort;

public class QuickSort_Practice {
	
	public static void main(String[] args) {
		int arr[] = new int[]{6, 1, 2, 8, 7, 3, 4, 9, 5};
		quickSort(arr, 0, arr.length-1);
		for(int n : arr)
			System.out.print(n);
	}
	
	static void quickSort(int[] arr, int s, int e) {
		if(s >= e)	return;
		int pivot = partition(arr, s, e);
		quickSort(arr, s, pivot-1);
		quickSort(arr, pivot+1, e);
	}
	
	static int partition(int[] arr, int s, int e) {
		int move = s-1;
		for(int i=s; i<e; i++) {
			if(arr[e] >= arr[i])
				swap(arr, i, ++move);
		}
		swap(arr, e, ++move);
		return move;
	}
	
	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
