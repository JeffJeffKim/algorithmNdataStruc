package AmaAudi;

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
