package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListDeepCopy {
	public static void main(String[] args) {
		//0 nofile, 1 file
		List<Integer> list1 = Arrays.asList(0,1,1,0,1);
		List<Integer> list2 = Arrays.asList(0,1,0,1,0);
		List<Integer> list3 = Arrays.asList(0,0,0,0,1);
		List<Integer> list4 = Arrays.asList(0,1,0,0,0);
		List<List<Integer>> list = Arrays.asList(list1, list2, list3, list4);
		printOut(list);
		deepCopy(list);
		printOut(list);
	}
	
	static void deepCopy(List<List<Integer>> list) {
		List<List<Integer>> newL = new ArrayList<List<Integer>>();
		for(int i=0; i<list.size(); i++) {
			newL.add(i, new ArrayList<Integer>());
			newL.get(i).addAll(list.get(i));
		}
		newL.get(0).set(0, 1);
		printOut(newL);
	}
	
	static void printOut(List<List<Integer>> list) {
		for(List<Integer> iList : list) {
			for(int num : iList)
				System.out.print(num);
			System.out.println();
		}
	}
	
	static List<Integer> getList(){
		return new ArrayList<Integer>();
	}
}
