package company.amazonAudi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Audi2 {
	
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(5, 3, 2, 4, 1, 2);
		List<Integer> list2 = Arrays.asList(5, 7, 5, 6, 2);
		List<Integer> list3 = Arrays.asList(4, 2, 5, 1, 6);
//        List<Integer> list2 = Arrays.asList(0, 0, 1, 0, 0);
//        List<Integer> list3 = Arrays.asList(0, 0, 0, 0, 0);
//        List<Integer> list4 = Arrays.asList(1, 0, 1, 1, 0);
//        List<Integer> list5 = Arrays.asList(1, 1, 1, 1, 0);
//        List<Integer> list6 = Arrays.asList(1, 1, 1, 1, 0);
		List<Integer> result = minimalHeaviestSetA(list3);
		ArrayList<ArrayList<Integer>> addr = new ArrayList<ArrayList<Integer>>();
		for(int a : result)
			System.out.print(a + " ");
	}
	
    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
    	List<Integer> arrA = new ArrayList<Integer>();
    	
    	Collections.sort(arr);
    	int sumA = 0, sumB = 0;
    	for(int cur : arr)
    		sumB += cur;
    	for(int i=arr.size()-1; i>=0; i--) {
    		int cur = arr.get(i);
    		sumA += cur;
    		sumB -= cur;
    		arrA.add(cur);
    		if(sumA > sumB)
    			break;
    	}
    	
    	Collections.sort(arrA);
    	return arrA;
    }

}

/*
Optimizing box weights,Given an integer array of the item weights(arr) to be packed,
divide the item weights into two subsets, A and B ,
for packing into the associated boxes while respecting below conditions between A and B.
e.g. n =5 and arr= [3,7,5,6,2]
then return the subset A in increasing order where the sum of A's > sum of B's.
if more than one pair exist return the one with the max total weight.
rules :-
the intersections of A and B is null
The union A and B is equal to the original array
the number of elements in subset A is minimal
The sum of A's weight is greater than the sum of B's weight

Return the subset of A in increasing order where the sum of A' weights is greater than the sum of B's weights
if more than one subSet A exists, return the one with maximum total weight
 */