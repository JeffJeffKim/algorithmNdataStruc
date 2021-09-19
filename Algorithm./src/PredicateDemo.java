import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class PredicateDemo {
	public static void main(String[] args) {
		Predicate<Integer> isDividableBy2 = i -> i%2==0;
		Predicate<Integer> isDividableBy3 = i -> i%3==0;
		for(int i=0; i<11; i++) {
//			if(isDividableBy2.test(i) && isDividableBy3.test(i))
//				System.out.println(i + " wow");
//			if(isDividable(i, new int[]{2,5}))
//				if(isDividable(i, 2) && isDividable(i, 5))
//				System.out.println(i + " it is..");
//			System.out.println(i +" "+ isDividableBy2.test(i));
			System.out.println(isDividable(i));
		}
	}
	
	static String isDividable(int num) {
		StringBuilder sb = new StringBuilder();

		//		final String[] arrStr = new String[] {"fizz", "buzz"};
//		final int[] arrInt = new int[] {2,3};
//		for(int i=0; i<arrInt.length; i++) {
//			if(num%arrInt[i] == 0)
//				sb.append(arrStr[i]);
//		}
		Map<Integer, String> map = new HashMap<>();
		map.put(2, "fizz");
		map.put(3, "buzz");
		
		for (Map.Entry<Integer, String> kv : map.entrySet()) 
			if(num % kv.getKey() == 0)
				sb.append(kv.getValue());

		if(sb.length() == 0)
			sb.append(num);
		return sb.toString();
	}
	
	static boolean isDividable(int numerator, int denorminator) {
		return numerator%denorminator == 0;
	}
	
	static boolean isDividable(int numerator, int[] denorminators) {
		for(int denorminator : denorminators)
			if(!isDividable(numerator, denorminator))
				return false;
		return true;
	}

}
