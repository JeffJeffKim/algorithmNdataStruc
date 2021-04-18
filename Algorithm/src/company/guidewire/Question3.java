package company.guidewire;

public class Question3 {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1,1,2,3,3}, 3));
		System.out.println(solution(new int[]{1,1,3}, 2));
		System.out.println(solution(new int[]{1,1,3}, 3));
		System.out.println(solution(new int[]{2,1,3}, 3));
		System.out.println(solution(new int[]{3,1,2}, 4));
		System.out.println(solution(new int[]{1}, 1));
		System.out.println(solution(new int[]{2}, 2));
	}
	
	
    static public boolean solution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
//        	if (A[i] + 1 < A[i + 1])
    		if (A[i] + 1 < A[i + 1] || A[i] > A[i+1])
                return false;
        }
        if (A[0] != 1 || A[n - 1] != K)
            return false;
        else
            return true;
    }

}
