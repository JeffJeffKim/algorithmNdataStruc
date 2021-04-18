package company.stepPay;

import java.util.Arrays;

public class StepPay3 {

    static  public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0, j=0; i<A.length && j<A.length; ) {
        	if(A[i] < B[j]) {
        		i++;
        		j++;
        		answer++;
        	} else {
        		j++;
        	}
        }
        return answer;
    }
    
	public static void main(String[] args) {
		int[] A = {5,1,3,7};
		int[] B = {2,2,6,8};
		System.out.println(solution(A, B));
		
		A = new int[]{2,2,2,2};
		B = new int[]{1,1,1,1};
		System.out.println(solution(A, B));

	}

}
