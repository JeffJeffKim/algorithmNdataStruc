package company.ama202104;

import java.util.Arrays;
import java.util.List;

public class Solution1 {
	static long result = 0;
	
	public static void main(String[] args) {
		System.out.println(howManySwaps(Arrays.asList(5, 1, 4, 2)));
		result = 0;
		System.out.println(howManySwaps(Arrays.asList(7,12)));
		result = 0;
		System.out.println(howManySwaps(Arrays.asList(7,12,13)));
//		System.out.println(quickSort(Arrays.asList(5, 1, 4, 2)));
//		System.out.println(quickSort(Arrays.asList(7,12)));
	}
	
	public static long howManySwaps(List<Integer> arr) {
//        long result = 0;
//		for(int i=0; i<arr.size()-1; i++) {
//			for(int j=i+1; j<arr.size(); j++) {
//				if(arr.get(i) > arr.get(j)) {
//					int temp = arr.get(i);
//					arr.set(i, arr.get(j));
//					arr.set(j, temp);
//					result++;
//				}
//			}
//		}
//		if (arr.size() == 2) {
//			if(arr.get(0) < arr.get(1))
//				return 0;
//			else
//				return 1;
//		}
		quickSort(arr, 0, arr.size()-1);
        return result;
    }
	
	static void quickSort(List<Integer> arr, int s, int e) {
		if(s >= e)	return;
		int pivot = partition(arr, s, e);
		quickSort(arr, s, pivot-1);
		quickSort(arr, pivot+1, e);
	}
	
	static int partition(List<Integer> arr, int s, int e) {
		int move = s-1;
		for(int i=s; i<e; i++) {
			if(arr.get(e) > arr.get(i)) {
				swap(arr, i, ++move);
				if (i != move)
					result++;
			}
		}
		swap(arr, e, ++move);
		if (e != move)
			result++;
		return move;
	}
	
	static void swap(List<Integer> arr, int a, int b) {
		int temp = arr.get(a);
		arr.set(a, arr.get(b));
		arr.set(b, temp);
//		arr[a] = arr[b];
//		arr[b] = temp;
	}

}
