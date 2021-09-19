package company.trendMicroCodity;

public class Ex1 {
	
	public static void main(String[] args) {
		solution(3, 7);
	}
	
	static public int solution(int A, int B) {
	        // write your code in Java SE 8
		int result = 0;
		int multi = A*B;
		String str = Integer.toBinaryString(multi);
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '1')
				result++;
		}
//		result = Integer.valueOf(str);
//		int num = Integer.bitCount(result);
		return result;
    }

}
