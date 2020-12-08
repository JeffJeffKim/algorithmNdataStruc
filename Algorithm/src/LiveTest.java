import java.util.ArrayList;

public class LiveTest {

	// Write a function that returns true if the brackets in a given string are
	// balanced.
	// Balanced means that every parenthesis/bracket or brace that is opened must be
	// closed
	// And it must be closed in the right order (Always close the last symbol you
	// opened)
	// The function must handle parens (), square brackets [], and curly braces {}.
	public static void main(String[] args) {
		System.out.println("(a[0]+b[2c[6]])            passed:" + parensMatch("(a[0]+b[2c[6]])"));
		System.out.println("f(e(d))                    passed:" + parensMatch("f(e(d))"));
		System.out.println("[()]{}([])                 passed:" + parensMatch("[()]{}([])"));
		System.out.println("((b)                       passed:" + parensMatch("((b)"));
		System.out.println("(c]                        passed:" + parensMatch("(c]"));
		System.out.println("{(a[])                     passed:" + parensMatch("{(a[])"));
		System.out.println("([)]                       passed:" + parensMatch("([)]"));
		System.out.println("[({{}}])                   passed:" + parensMatch("[({{}}])"));
		System.out.println(")(                         passed:" + parensMatch(")("));
	}

	// t t t f ~~~
	public static boolean parensMatch(String sentence) {
		ArrayList<Character> q = new ArrayList<Character>();
		for (int i=0; i<sentence.length(); i++) {
			char cur = sentence.charAt(i);
			if(cur == '(' || cur =='[' || cur =='{') {
				q.add(cur);
			}else if(cur == ')' || cur ==']' || cur =='}') {
				if(q.size() < 1)
					return false;
				char prev = q.get(q.size()-1);
				q.remove(q.size()-1);
				
				if(cur == ')')
					if(prev != '(')
						return false;
					else
						continue;
				
				if(cur == ']')
					if(prev != '[')
						return false;
					else
						continue;

				if(cur == '}')
					if(prev != '{') 
						return false;
					else
						continue;
					
			}
		}
		if(q.size() > 0)
			return false;
		return true;
	}

}
