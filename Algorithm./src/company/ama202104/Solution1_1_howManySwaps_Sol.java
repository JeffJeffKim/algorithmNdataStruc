package company.ama202104;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1_1_howManySwaps_Sol {

	
	public static void main(String[] args) {
//		System.out.println(howManySwaps(Arrays.asList(7,1,3,2,4,5,6)));
//		System.out.println(howManySwaps(Arrays.asList(4,3,1,2)));
//		System.out.println(howManySwaps(Arrays.asList(2,3,4,1,5)));
//		System.out.println(howManySwaps(Arrays.asList(1,3,5,2,4,6,7)));
		System.out.println(howManySwaps(new int[]{7,1,3,2,4,5,6}));
		System.out.println(howManySwaps(new int[]{4,3,1,2}));
		System.out.println(howManySwaps(new int[]{2,3,4,1,5}));
		System.out.println(howManySwaps(new int[]{1,3,5,2,4,6,7}));
	}
	
	public static long howManySwaps(int[] arr) {
		long result = 0;

//		List<Integer> copyArr = arr.stream().collect(Collectors.toList());
//		List<Integer> copyArr = new ArrayList<>();
//		for (int i = 0; i < arr.size(); i++) {
//			copyArr.add(arr.get(i));
//		}
//		arr.sort(Comparator.comparing(i -> i));
//
//		for (int i = 0; i < arr.size(); i++) {
//			if (arr.get(i) != copyArr.get(i)) {
//				result++;
//			}
//		}

		for (int i = 0; i< arr.length; i++) {
			if (arr[i] != i + 1) {
				while (true) {
					int temp = arr[i];
					if (arr[temp-1] == temp) {
						break;
					}
					arr[i] = arr[temp - 1];
					arr[temp-1] = temp;
					result++;
				}
			}
		}

        return result;
    }
	

}
