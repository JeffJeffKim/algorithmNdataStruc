package company.trendMicroCodity;

public class Ex2 {
	
	public static void main(String[] args) {
		int[] A = null; 
		A = new int[] {1,1,2,3,3};
		System.out.println(solution(A, 3));
		A = new int[] {1,1,2,3,3,5};
		System.out.println(solution(A, 5));
		A = new int[] {2,3,4,5};
		System.out.println(solution(A, 5));
		A = new int[] {0,2,3,4,5};
		System.out.println(solution(A, 5));
		A = new int[] {0,1,2,3,4,5,5,5,5};
		System.out.println(solution(A, 4));
		A = new int[] {0,1,2,3,4,5,5,5,5};
		System.out.println(solution(A, 4));
		A = new int[] {0,1,2,3,4,5};
		System.out.println(solution(A, 5));
		A = new int[] {1,1,3};
		System.out.println(solution(A, 3));
	}
	
    static public boolean solution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] + 1 < A[i + 1])
                return false;
        }
//        if (A[0] != 1 && A[n - 1] == K)
        if (A[0] > 1 && A[n - 1] < K)
            return false;
        else
            return true;
    }

}
