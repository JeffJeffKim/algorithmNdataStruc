package practice;

import java.util.Arrays;

public class Synopsys_Practice {
	
	public static void main(String[] args) {
		System.out.println(5 +" "+ solution(new int[] {1,3,6,4,1,2}));
		System.out.println(1 +" "+ solution(new int[] {-1,-3}));
		System.out.println(2 +" "+ solution(new int[] {-1,-3,1,5}));
		System.out.println(3 +" "+ solution(new int[] {-1,-3,1,2,4,5}));
		System.out.println(4 +" "+ solution(new int[] {-1,-3,1,2,3,5}));
		System.out.println(6 +" "+ solution(new int[] {-1,-3,1,2,3,4,5}));
		System.out.println(6 +" "+ solution(new int[] {-1,-3,1,2,3,4,5,5}));
		System.out.println(4 +" "+ solution(new int[] {-1,-3,1,2,3,3,5}));
		System.out.println(1 +" "+ solution(new int[] {-1,-3,2,3,4,5}));
		System.out.println(1 +" "+ solution(new int[] {-1,-3,0}));
		System.out.println(1 +" "+ solution(new int[] {-1,-3,0,2}));
		System.out.println(3 +" "+ solution(new int[] {-1,-3,0,1,2}));
		System.out.println(1 +" "+ solution(new int[] {-1}));
		System.out.println(2 +" "+ solution(new int[] {1}));
		System.out.println(1 +" "+ solution(new int[] {7}));
	}
	
	public static int solution(int[] A) {
		if(A.length == 1)
			if(A[0] == 1)
				return 2;
			else
				return 1;
		
		Arrays.sort(A);
		if(A[A.length-1]<2)	return 1;
		
		int min = 0;
		for(int i=0; i<A.length; i++) {
			if(A[i] < 1) 
				continue;
			if(min == A[i])	
				continue;
			else if(min == A[i]-1)
				min++;
			else
				return ++min;
		}
		
		return ++min;
	}

}
