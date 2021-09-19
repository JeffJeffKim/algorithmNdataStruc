package practice;

public class Article1 {
	
	public static void main(String[] args) {
		System.out.println(findMaxNum(8, 5, 3));
		System.out.println(findMaxNum(4, 4, 6));
		System.out.println(findMaxNum(5, 4, 5));
		System.out.println(findMaxNum(6, 4, 4));
		System.out.println(findMaxNum(2, -2, 6));
		System.out.println(findMaxNum(0, 0, 5));
	}
	
	public static int findMaxNum(int x, int y, int z) {
	    // Write your code here
		int a, b, diff, result=0;
		if(x > y) {
			a = x;
			b = y;
		}else {
			a = y;
			b = x;
		}
		diff = a-b;
		
		if((z-diff)%2 != 0)	return -1;
		if(diff == 0 && z > 0)
			result = a + z/2;
//		else if((z-diff)%2 != 0)	return -1;
		else if(z%2 == 0 && z <= diff)
			result = a;
		else {
			result = (z-diff)/2 + a;
		}
		
			
		return result;
    }

}
