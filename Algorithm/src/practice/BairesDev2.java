package practice;

import java.util.Stack;

public class BairesDev2 {
	
	public static void main(String[] args) {
//		System.out.println('a'-97);
		System.out.println(stringsConstruction("abc", "ccccc"));
		System.out.println(stringsConstruction("abc", "abccba"));
		System.out.println(stringsConstruction("ab", "abcbcb"));
		System.out.println(stringsConstruction("hnccv", "hncvohcjhdfnhonxddcocjncchnvohchnjohcvnhjdhihsn")); //3
	}
	
	static int stringsConstruction(String a, String b) {
		int result = Integer.MAX_VALUE;
		int arrA[] = new int[26];
		int arrB[] = new int[26];
		for(int i=0; i<a.length(); i++) 
			arrA[a.charAt(i)-97]++;

		for(int i=0; i<b.length(); i++) 
			arrB[b.charAt(i)-97]++;
		
		for(int i=0; i<26; i++) {
			if(arrA[i] != 0) {
				if(arrB[i] < 1) {
					return 0;
				}else if(arrA[i] > 1) {
					int cur = arrB[i] / arrA[i];
					if(result > cur)
						result = cur;
				}else {
					if(result > arrB[i])
						result = arrB[i];
				}
			}
		}
		
		return result;
	}

}
