package company.amazonAudi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Audi1_getMinScore {
	
	public static int result1 = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
        List<Integer> list1 = Arrays.asList(1, 2, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(2, 4, 5, 5, 5, 6);
        System.out.println(getMinScore(6, list1, list2));
		
	}
	
	public static int getMinScore(int productsNodes, List<Integer> productsFrom, List<Integer> productsTo) {
        int result = Integer.MAX_VALUE;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0; i<productsFrom.size(); i++){
            int from = productsFrom.get(i);
            int to = productsTo.get(i);
            if(!map.containsKey(from))
                map.put(from, new ArrayList<Integer>());
            if(!map.containsKey(to))
                map.put(to, new ArrayList<Integer>());
            map.get(from).add(to);
            map.get(to).add(from);
        }

//        Iterator<Integer> keys = map.keySet().iterator();
//        while(keys.hasNext()){
//        	int key = keys.next();
//        	ArrayList<Integer> value = map.get(key);
//        	
//        	
//        }
        
        for(int i=0; i<productsNodes; i++) {
        	if(!map.containsKey(i))	continue;
        	List<Boolean> visit = new ArrayList<Boolean>(productsNodes);
        	result1 = Integer.MAX_VALUE;
        	result = getCurMin(map, 0, i, i, visit);
        	
        }

        if(result == Integer.MAX_VALUE)
            result = -1;
        return result;
    }
	
	public static int getCurMin(HashMap<Integer, ArrayList<Integer>> map, int size, int curAddr, int org, List<Boolean> visit) {
//		++size;
		if(org == curAddr)	return Integer.MAX_VALUE;
		if(size >= 2) {
			if(!map.containsKey(org))	return Integer.MAX_VALUE;
			int curResult = 0;
			ArrayList<Integer> arrResult = map.get(org);
			for(int cur : arrResult) {
				if(visit.get(cur))	continue;
				curResult++;
			}
			return curResult;
		}
		
		visit.set(curAddr, true);
		ArrayList<Integer> arrTo = map.get(curAddr);
		for(int curTo : arrTo) {
    		List<Integer> nextArrTo = map.get(curTo);
    		for(int nextTo : nextArrTo) {
    			int curResult = getCurMin(map, size++, nextTo, org, visit);
    			if(result1 > curResult)
    				result1 = curResult;
    			visit.set(curAddr, false);
    		}
    	}
		return result1;
	}

}
