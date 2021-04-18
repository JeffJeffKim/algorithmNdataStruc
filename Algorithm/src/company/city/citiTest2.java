package company.city;

import java.util.Arrays;

public class citiTest2 {
	
	public static void main(String[] args) {
//		int[] A = new int[] {2,1,3,5,4}; //3
//		int[] A = new int[] {2,3,4,1,5}; //2
		int[] A = new int[] {1,3,4,2,5}; //3
		System.out.println(solution(A));
	}
	
    public static int solution(int[] A) {
        // write your code in Java SE 8
    	int result = 0;
    	int curSum = 0;
    	int expectedSum = 0;
    	int length = A.length;
    	for(int i=0; i<length; i++) {
    		curSum += A[i];
    		expectedSum += i+1;
    		if(curSum == expectedSum)
    			result++;
    	}
    	return result;
    }

}
