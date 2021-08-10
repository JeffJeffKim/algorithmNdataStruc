package company.resMed;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution2 {
	
	public static void main(String[] args) {
		String line = "70.920 -38.797 14.354 99.323 90.374 7.581";
		String[] arrStr = line.split(" ");
		Arrays.sort(arrStr, Comparator.comparing(s -> Double.parseDouble(s)));
//		Arrays.sort(arrStr, (o1, o2) -> (int) (Double.parseDouble(o1) - Double.parseDouble(o2)));
		String  result = "";
		for(int i=0; i<arrStr.length; i++) {
			result += arrStr[i] + " "; 
		}
		System.out.println(result.trim());
	}

}

//public static void main(String[] args) throws IOException {
//    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//    BufferedReader in = new BufferedReader(reader);
//    String line;
//    while ((line = in.readLine()) != null) {
//      String[] arrStr = line.split(" ");
//      Arrays.sort(arrStr, Comparator.comparing(s -> Double.parseDouble(s)));
//      
//      String  result = "";
//      for(String cur : arrStr) 
//        result += cur + " "; 
//      
//      System.out.println(result.trim());
//    }
//  }

//double[] arrDouble = new double[arrStr.length];
//for(int i=0; i<arrStr.length; i++) {
//	arrDouble[i] = Double.parseDouble(arrStr[i]);
//}
//Arrays.sort(arrDouble);
//String  result = "";
//for(int i=0; i<arrStr.length; i++) {
////	System.out.println(arrDouble[i]);
//	result += arrDouble[i] + " "; 
//}
//System.out.println(result.trim());