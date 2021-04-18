package company.guidewire;

public class Question2 {
	
	public static void main(String[] args) {
//		System.out.println(Math.pow(2, 400_000)-1);
		System.out.println(solution("011100"));
		System.out.println(solution("111"));
		System.out.println(solution("1111010101111"));
		StringBuilder s = new StringBuilder();
		for(int i=0; i<400_000; i++)
			s.append("1");
		System.out.println(solution(s.toString()));
		System.out.println(solution("000001"));
		System.out.println(solution("000000"));
	}
	
	static public int solution(String S) {
		int result = 0;
		int firstOne = S.indexOf("1");
		if(firstOne == -1)
			return result;
		String str = S.substring(firstOne);
		
		for(int i=str.length()-1; i>=0; i--) {
			if(i == 0)
				result++;
			else {
				if(str.charAt(i) == '0')
					result += 1;
				else
					result += 2;
			}
		}
		
		return result;
	}

}


//static public int solution(String S) {
//	int result = 0;
//	long num = 0;
//	for(int i=S.length()-1, j=0; i>=0; i--, j++) {
//		if(S.charAt(j) == '0')
//			continue;
//		else
//			num += Math.pow(2, i);
//	}
//	
//	while(num != 0) {
//		if(num%2 == 0) {
//			num = num>>1;
//		} else {
//			num--;
//		}
//		result++;
//	}
//	return result;
//}
