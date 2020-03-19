package practice;

public class IsPoweredByTwo {
	
	public static void main(String[] args) {
		System.out.println(isPoweredBy2(8));
		System.out.println(isPoweredBy2(6));
		System.out.println(isPoweredBy2(4));
		System.out.println(isPoweredBy2(15));
		System.out.println(isPoweredBy2(16));
		System.out.println(isPoweredBy2(18));
		
		
	}
	
	static boolean isPoweredBy2 (int n) {
		boolean result;
		
		if(n == 0 || n == 2)	return true;
		if(n%2 == 0)
			result = isPoweredBy2(n/2);
		else 
			return false;
		
		return result;
	}

}
