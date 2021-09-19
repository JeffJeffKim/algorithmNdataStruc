// https://www.acmicpc.net/problem/10814

package backjun.sort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class OrderAgeEnroll_10814 {
	
	static TreeMap<Integer, LinkedList<String>> tmap = new TreeMap<Integer, LinkedList<String>>(); 
	
	public static void main(String[] args) {
		getIn();
		
		Iterator<Integer> keys = tmap.keySet().iterator();
		
		while(keys.hasNext()) {
			int key = keys.next();
			var list = tmap.get(key);
			for(String name : list) 
				System.out.println(key + " " + name);
		}
	}
	
	static void getIn() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			int age = sc.nextInt();
			String name = sc.next();
			sc.nextLine();
			
			if(tmap.containsKey(age)) {
				tmap.get(age).add(name);
			}else {
				LinkedList<String> list = new LinkedList<String>();
				list.add(name);
				tmap.put(age, list);
			}
		}
		
		sc.close();
	}

}
