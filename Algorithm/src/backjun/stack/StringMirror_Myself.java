package backjun.stack;

import java.util.Stack;

public class StringMirror_Myself {
	
	public static void main(String[] args) {
		String[] arr = {"aba", "abcdcba", "abcddcba", "abcbaa", "abcdb", "abba", "abbba", "ababbaba"};
		// t, t, t, f, f, t, t, t
		for(String str: arr)
			System.out.println(stack(str));
	}
	
	static boolean stack(String str) {
		if(str.length() == 1)	return true;
		int len = str.length()%2 == 0 ? str.length()/2: str.length()/2 + 1;
		var s = new Stack<Character>();
		for(int i=0; i<len; i++) 
			s.push(str.charAt(i));
		return recur(s, str.substring(len));
	}
	
	static boolean recur(Stack<Character> s, String str) {
		boolean result = false;
		int idx = 0;
		char c = s.pop();
		if(s.size() == str.length()-1) {
			if(str.charAt(idx++) != c)	return result;
		} else if(s.size() < str.length()-1)
			return result;
		
		for(; idx<str.length(); idx++) 
			if(str.charAt(idx) != s.pop())	return result;
		
		return true;
	}

}
