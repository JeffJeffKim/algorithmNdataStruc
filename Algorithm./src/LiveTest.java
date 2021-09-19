
public class LiveTest {

	public static void main(String[] args) {
//		F(n) = F(n-2) + F(n-3), 단, n은 자연수이고 F(1) = F(2) = F(3) = 1
		int first = 1;
		int sec = 1;
		int third = 1;
		int n = 10;
		
		/*
		 * f(4) = f(2) + f(1)
		 * f(5) = f(3) + f(2)
		 * f(n) = f(n-2) - f(n-3)
		 * 
		 * {1,1,1,  1+1=2, 1+1=2, 2+1=3, 2+2=4, 3+2=5, 4+3=7, 5+4=9, 5+7=12....j}
		 *  1 2 3       4      5      6     7     8     9     10     11
		 */
		
		int[] arr = new int[n];
		arr[0] = first;
		arr[1] = sec;
		arr[2] = third;
		
		if(n >= 3) {
			for(int i=3; i<n; i++) {
				arr[i] = arr[i-3] + arr[i-2];
			}
		}
		
		System.out.println(arr[n-1]);
		
	}

}
