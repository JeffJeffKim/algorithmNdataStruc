package practice;

public class Fibo {
	
	public static void main(String[] args) {
		// index: 1 2 3 4 5 6 7  8
		// result:1 1 2 3 5 8 13 21
		System.out.println(fibo(5));
	}
	
	private static int fibo(int idx) {
		if(idx == 1)	return 1;
		if(idx == 2)	return 1;
		
		return fibo(idx-1) + fibo(idx-2);
	}

}
