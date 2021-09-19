package company.morgan;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution2 {
	
	public static void main(String[] args) {
		System.out.println(solution("mary", "arm"));
		System.out.println(solution("mary", "army"));
		System.out.println(solution("mary", "armyy"));
		System.out.println(solution("maryi", "armyy"));
	}
	
	public static boolean solution(String str1, String str2) {
		/*
		 str1 : mary
		 str2 : army
		 result true
		 */
		boolean result = false;
		
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();
		
		if(str1.length() != str2.length())
			return result;
		
		for(int i=0; i<str1.length(); i++) {
			char c = str1.charAt(i);
			if(map1.containsKey(c))
				map1.put(c, map1.get(c)+1);
			else 
				map1.put(c, 1);
		}
		
		for(int i=0; i<str2.length(); i++) {
			char c = str2.charAt(i);
			if(map2.containsKey(c))
				map2.put(c, map1.get(c)+1);
			else 
				map2.put(c, 1);
		}

		Iterator<Character> itr = map1.keySet().iterator();
		while(itr.hasNext()) {
			char ch = itr.next();
			int count = map1.get(ch);
			if(count == map2.get(ch))
				continue;
			else 
				return result;
		}
		
		result = true;
		
		return result;
	}

}
