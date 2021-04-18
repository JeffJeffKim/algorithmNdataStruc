package proEdu.day3;

import java.util.ArrayList;

public class QuizHardcodingList {
	static ArrayList<Character> cList;
	static ArrayList<ArrayList<Integer>> aList;
	static int[] used = new int[10];
	
	public static void main(String[] args) {
		aList = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<5; i++) {
			aList.add(new ArrayList<Integer>());
		}
		aList.get(0).add(3);
		aList.get(0).add(2);
		aList.get(1).add(2);
		aList.get(2).add(0);
		aList.get(3).add(2);
		aList.get(3).add(4);
		aList.get(4).add(3);
		
		cList = new ArrayList<Character>();
		cList.add('R');
		cList.add('T');
		cList.add('T');
		cList.add('T');
		cList.add('V');
		
		for(ArrayList<Integer> list : aList) {
			for(int num : list) {
				System.out.print(cList.get(num) + " ");
			}
			System.out.println();
		}
		
		used[0] = 1;
		dfs(0);
	}
	
	static void dfs(int now) {
//		°­»ç´Ô
//		System.out.print(cList.get(now) + "");
//
//        for (int i = 0; i < aList.get(now).size(); i++) {
//            int next = aList.get(now).get(i);
//            if (used[next] == 1) continue;
//            used[next] = 1;
//            dfs(next);
//        }
		
		// ³»²¨
		System.out.print(cList.get(now));
		for(int num : aList.get(now)) {
			if(used[num] == 1)	continue;
			used[num] = 1;
			dfs(num);
		}
	}

}
