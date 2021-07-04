package company.morgan;

import java.util.List;

public class Solution1 {
	
	public static void main(String[] args) {
		String str = "Hello world";
		System.out.println(getResult(str));
		str = "abcaaabbc"; //aaaabbbcc
		System.out.println(getResult(str));
		str = "Hello hworld";
		System.out.println(getResult(str));
	}
	
	
	
	public static String getResult(String str) {
		// input = "Hello world"
		/*
		  Hellloo wrd
		 */
		// 0. before iterate, make group(dat or map) and count
		
		int[] dat = new int[200];
		for(int i=0; i<str.length(); i++) {
			dat[str.charAt(i)]++;
		}
		
		
		StringBuilder sb = new StringBuilder();
		// 1. check the char is first or not
		boolean[] isFirst = new boolean[200];
		for(int i=0; i<str.length(); i++) {
			if(isFirst[str.charAt(i)])
				continue;
			isFirst[str.charAt(i)] = true;
			
			// 2. if first, check other same values are exist
			int count = dat[str.charAt(i)];
			
			while(count-- > 0) {
				sb.append(str.substring(i, i+1));
			}
		}
		
		// output "Hellloo wrd" 
		return sb.toString();
	}
	

}
