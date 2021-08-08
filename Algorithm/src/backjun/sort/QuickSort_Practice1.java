package backjun.sort;

public class QuickSort_Practice1 {
	
	static int K = 7;
	
	public static void main(String[] args) {
		int arr[] = new int[]{6, 1, 2, 8, 7, 3, 4, 9, 5};
		System.out.println(quickSort(arr, 0, arr.length-1));
	}

	static int quickSort(int[] arr, int s, int e) {
		int pivot = partition(arr, s, e);
		if (pivot == K) {
			return arr[pivot];
		} else if (pivot > K) {
			return quickSort(arr, s, pivot - 1);
		} else {
			return quickSort(arr, pivot + 1, e);
		}
	}

	static int partition(int[] arr, int s, int e) {
		int pivot = s - 1;
		for (int i = s; i < e; i++) {
			if (arr[e] > arr[i]) {
				swap(arr, i, ++pivot);
			}
		}

		swap(arr, e, ++pivot);
		return pivot;
	}

	static void swap(int[] arr, int s, int e) {
		int temp = arr[s];
		arr[s] = arr[e];
		arr[e] = temp;
	}
	
}
