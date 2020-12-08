package practice;

import java.util.Stack;

public class BairesDev {
	
	public static void main(String[] args) {
		System.out.println(isPair("([)]"));
		System.out.println(isPair("([])"));
		System.out.println(isPair("(()[]{})"));
	}
	
	static boolean isPair(String sequence) {
		Stack<Character> st = new Stack<Character>();
		for(int i=0; i<sequence.length(); i++) {
			char cur = sequence.charAt(i);
			if(cur == '(' || cur == '[' || cur == '{')
				st.push(cur);
			else {
				try {
					if(cur == ')')
						if(st.pop() != '(') 
							return false;
					if(cur == ']')
						if(st.pop() != '[') 
							return false;
					if(cur == '}')
						if(st.pop() != '{')
							return false;
				}catch(Exception e) {
					return false;
				}
			}
		}
		if(st.isEmpty())
			return true;
		else
			return false;
	}

}
