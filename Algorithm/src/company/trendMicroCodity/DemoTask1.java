package company.trendMicroCodity;

import java.util.Arrays;

public class DemoTask1 {
	
	public static void main(String[] args) {
		System.out.println(5+" "+solution(new int[] {1,3,6,4,1,2}));//5
		System.out.println(4+" "+solution(new int[] {1,2,3}));//4
		System.out.println(1+" "+solution(new int[] {-1,-3}));//1
		System.out.println(1+" "+solution(new int[] {-1,-3,0}));//1
		System.out.println(2+" "+solution(new int[] {-1,-3,1}));//2
		System.out.println(2+" "+solution(new int[] {-1,-3,1,3}));//2
		System.out.println(2+" "+solution(new int[] {0,1,3}));//2
		System.out.println(4+" "+solution(new int[] {0,1,2,3}));//4
		System.out.println(1+" "+solution(new int[] {-5,-4}));
		System.out.println(2+" "+solution(new int[] {0,0,1}));
		System.out.println(1+" "+solution(new int[] {0}));
		System.out.println(2+" "+solution(new int[] {1}));
		System.out.println(1+" "+solution(new int[] {2}));
		System.out.println(1+" "+solution(new int[] {0,2}));
		System.out.println(1+" "+solution(new int[] {-2,2}));
	}
	
    public static int solution(int[] A) {
    	int result = 0;
    	Arrays.sort(A);
    	for(int i=0; i<A.length; i++) {
    		if(A[i] <= result)
    			continue;
    		if(i == 0) {
    			if(A[i] > result)
    				result = A[i];
    			continue;
    		}
    		if(A[i] != result+1 && A[i-1] > 0) 
    			result = A[i-1]+1;
    	}
    	
    	if(result == 0) {
    		if(A.length == 1)
    			result = 1;
    		else if(A[A.length-1] > 0 && A[A.length-2] > 0)
    			result = A[A.length-1]+1;
    		else
    			result = 1;
    	}
    	
    	return result;
    }

}
