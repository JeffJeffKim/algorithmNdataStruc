package practice;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class GM3 {
	
	static TreeMap<BigDecimal, String> map;
	
	public static void main(String[] args) {
		String line = "15.94;16.00";
//		String line = "17;16";
//		String line = "35;35";
		String[] arrLine = line.split(";");
		BigDecimal cash = BigDecimal.valueOf(Double.parseDouble(arrLine[0]));
		BigDecimal price = BigDecimal.valueOf(Double.parseDouble(arrLine[1]));
		if(price.compareTo(cash) < 0) {
			System.out.println("ERROR");
		}else if(price.compareTo(cash) == 0) {
			System.out.println("ZERO");
		}else {
			setMap();
			cal(cash, price);
		}
		System.out.println(map);
	}
	
	static String cal(BigDecimal cash, BigDecimal price) {
		String result = "";
		BigDecimal remain = price.subtract(cash);
		while(remain.compareTo(cash) > 0) {
			Iterator<BigDecimal> keys = map.keySet().iterator();
			while(keys.hasNext()){
				BigDecimal key = keys.next();
				if(remain.compareTo(key) > 0) {
					remain = key.subtract(remain);
				}
				result += map.get(key)+",";
			}
		}
		result = result.substring(result.length()-2);
		return result;
	}
	
	static void setMap() {
		map = new TreeMap<BigDecimal, String>(Collections.reverseOrder());
		map.put(BigDecimal.valueOf(0.01), "PENNY");
		map.put(BigDecimal.valueOf(0.05), "NICKEL");
		map.put(BigDecimal.valueOf(0.10), "DIME");
		map.put(BigDecimal.valueOf(0.25), "QUARTER");
		map.put(BigDecimal.valueOf(0.50), "HALF DOLLAR");
		map.put(BigDecimal.valueOf(1.00), "ONE");
		map.put(BigDecimal.valueOf(2.00), "TWO");
		map.put(BigDecimal.valueOf(5.00), "FIVE");
		map.put(BigDecimal.valueOf(10.00), "TEN");
		map.put(BigDecimal.valueOf(20.00), "TWENTY");
		map.put(BigDecimal.valueOf(50.00), "FIFTY");
		map.put(BigDecimal.valueOf(100.00), "ONE HUNDRED");
//		map.comparator(Comparator.comparing(k -> k)).reversed();
	}

}
