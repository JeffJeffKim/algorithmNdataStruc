package company.city;

import java.util.Arrays;

public class citiDemo {
	public static void main(String[] args) {
		int[] A = new int[] {0, 0, 1};
		System.out.println(solution(A));
	}
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;
        Arrays.sort(A);
        if(A[A.length-1] > 0) {
            for(int num : A){
                if(num <= result)
                    continue;
                    
                if(result+1 != num)
                    return ++result;
                
                result++;
            }
            
            result++;
        }else
            result++;
        
        
        return result;
    }
}
