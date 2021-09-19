package company.trendMicroCodity;
public class Ex3 {
	public static void main(String[] args) {
//		System.out.println(1_000_000_000 > Integer.MAX_VALUE);
		System.out.println(solution(new int[] {1,5,3,3,7}));
		System.out.println(solution(new int[] {1,3,5,3,4}));
		System.out.println(solution(new int[] {1,3,2,3,5,4}));
		System.out.println(solution(new int[] {1,3,5}));
	}
	
	static public boolean solution(int[] A) {
//		boolean result = true;
		int i = 0;
		for(; i<A.length-1; i++) {
			if(A[i] <= A[i+1])
				continue;
			break;
		}
//		result = sol(A, i);
		return sol(A, i);
    }
	
	static boolean sol(int[] A, int idx) {
		boolean result = true;
		for(int i=idx+1; i<A.length-1; i++) {
			result = true;
			swap(A, idx, i);
			
			for(int j=idx; j<A.length-1; j++) {
				if(A[j] <= A[j+1])
					continue;
				result = false;
				break;
			}
			
			if(result)
				break;
			swap(A, i, idx);
		}
		return result;
	}
	
	static void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}

}
