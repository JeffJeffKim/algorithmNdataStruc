package company.gm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution1 {

	public static void main(String[] args) {
		final String[] MONEY_UNIT = {"PENNY", "NICKEL", "DIME", "QUARTER", "HALF DOLLAR", "ONE", "TWO", "FIVE", "TEN", "TWENTY", "FIFTY", "ONE HUNDRED"};
	    final double[] MONEY_AMOUNT = {0.01, 0.05, 0.1, 0.25, 0.5, 1.0, 2.0, 5.0, 10.0, 20.0, 50.0, 100.0};
	    Map<Double, String> map = new TreeMap<>((d1, d2) -> d2.compareTo(d1));
	    for(int i=0; i<MONEY_UNIT.length; i++) {
	      map.put(MONEY_AMOUNT[i], MONEY_UNIT[i]);
	    }
	    Collections.reverseOrder();
	    
	    String line = "15.94;16.00";
        String[] input = line.split(";");
        double pp = Double.parseDouble(input[0]);
        double ch = Double.parseDouble(input[1]);
        double diff = ch-pp;
        
        if(diff < 0) {
          System.out.println("ERROR");
        } else if (diff == 0) {
          System.out.println("ZERO");
        } else {
        	List<String> result = new ArrayList<>();
          Iterator<Double> itr = map.keySet().iterator();
          while(itr.hasNext()) {
            double key = itr.next();
            boolean isFirst = true;
            while(diff - key > 0) {
            	diff -= key;
            	if(isFirst)
            		result.add(map.get(key));
            }
            Collections.sort(result);
            String addResult = "";
            for(String cur : result) {
            	addResult += cur+",";
            }
            System.out.println(addResult.substring(0, addResult.length()-2));
          }
        }
	}

}
