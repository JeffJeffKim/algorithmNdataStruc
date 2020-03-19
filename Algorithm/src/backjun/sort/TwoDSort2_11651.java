// https://www.acmicpc.net/problem/11651
package backjun.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class TwoDSort2_11651 {
	
	static TreeMap<Integer, ArrayList<Integer>> tmap = new TreeMap<Integer, ArrayList<Integer>>(); 
	
	public static void main(String[] args) {
		getIn();
		
		Iterator<Integer> keys = tmap.keySet().iterator();
		while(keys.hasNext()) {
			int key = keys.next();
			var value = tmap.get(key);

			value.stream()
				.sorted(Comparator.naturalOrder())
				.forEach(x -> System.out.println(x + " " + key));
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
