package company.ama202104;

import java.util.Arrays;
import java.util.List;

public class Solution1 {
	static long result = 0;
	
	public static void main(String[] args) {
//		System.out.println(howManySwaps(Arrays.asList(5, 1, 4, 2)));
		System.out.println(howManySwaps(Arrays.asList(7,12)));
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
		quickSort(arr, 0, arr.size()-1);
        return result;
    }
	
	static void quickSort(List<Integer> arr, int s, int e) {
		if(s >= e)	return;
		int pivot = partition(arr, s, e);
		partition(arr, s, pivot-1);
		partition(arr, pivot+1, e);
	}
	
	static int partition(List<Integer> arr, int s, int e) {
		int move = s-1;
		for(int i=s; i<e; i++) {
			if(arr.get(e) > arr.get(i)) {
				swap(arr, i, ++move);
				result++;
			}
		}
		swap(arr, e, ++move);
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
