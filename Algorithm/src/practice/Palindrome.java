package practice;

import java.util.Arrays;

public class Palindrome {

	public static void main(String[] args) {
		// 12321
		// 10401
		// 1234321
//		var input = Arrays.asList(12321, 10401, 1234321, 12331);
		var input = Arrays.asList("test", "madam", "pop");
		for(var cur : input)
			System.out.println(palindrome(cur));
	}
	
	static String palindrome(int num) {
		int org = num, r=0, sum=0;
		while(num>0) {
			r  = num%10;
			sum = sum*10 +r;
			num /= 10;
		}
		
		if(sum == org) 
			return "TRUE";
		else
			return "FALSE";
	}
	
	static String palindrome(String str) {
		String reverse = "";
		for(int i=str.length()-1; i>=0; i--) 
			reverse += str.charAt(i);

		if(str.equals(reverse))
			return "TRUE";
		else
			return "FALSE";
	}
}
