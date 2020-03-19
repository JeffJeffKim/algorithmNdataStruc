package backjun.sort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class OrderAgeEnroll_10814 {
	
	static int N;
	static TreeMap<Integer, LinkedList<String>> tmap = new TreeMap<Integer, LinkedList<String>>(); 
	
	public static void main(String[] args) {
		getIn();
		Set set = tmap.entrySet();
		Iterator itr = set.iterator();
		while(itr.hasNext()) {
			Map.Entry me = (Entry) itr.next();
			LinkedList<String> list = (LinkedList) me.getValue();
			for(String name : list)
				System.out.println(me.getKey() + " " + name);
		}
	}
	
	static void getIn() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
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
