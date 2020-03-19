package backjun.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class TwoDSort2_11651 {
	
	static TreeMap<Integer, ArrayList<Integer>> tmap = new TreeMap<Integer, ArrayList<Integer>>(); 
	
	public static void main(String[] args) {
		getIn();
		
		Set set = tmap.entrySet();
		Iterator itr = set.iterator();
		while(itr.hasNext()) {
			Map.Entry me = (Entry) itr.next();
			ArrayList<Integer> list = (ArrayList<Integer>) me.getValue();
//			Collections.sort(list);
//			list = (ArrayList<Integer>) list.stream().sorted(Comparator.naturalOrder());
			list.stream()
				.sorted(Comparator.naturalOrder())
				.forEach(x -> System.out.println(x+" "+me.getKey()));
//			for(int x : list) {
//				System.out.println(x+" "+me.getKey());
//			}
		}
	}
	
	static void getIn() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), x, y;
		for(int i=0; i<n; i++) {
			x = sc.nextInt();	y = sc.nextInt();
			if(tmap.containsKey(y)) {
				tmap.get(y).add(x);
			}else {
				ArrayList<Integer> arr = new ArrayList<Integer>();
				arr.add(x);
				tmap.put(y, arr);
			}
		}
		sc.close();
	}

}
