package company.amazonAudi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Audi22 {
	public static int result1 = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
//        List<Integer> list1 = Arrays.asList(1, 2, 2, 3, 4, 5);
//        List<Integer> list2 = Arrays.asList(2, 4, 5, 5, 5, 6);
//		System.out.println(getMinScore(6, list1, list2));
        List<Integer> list1 = Arrays.asList(1, 2, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(2, 4, 5, 5, 5, 6);
        System.out.println(getMinScore(6, list1, list2));
		
	}
	
	public static int getMinScore(int productsNodes, List<Integer> productsFrom, List<Integer> productsTo) {
        int result = Integer.MAX_VALUE;
        List<ArrayList<Integer>> listRelation = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<productsNodes; i++) {
        	listRelation.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<productsFrom.size(); i++) {
        	listRelation.get(productsFrom.get(i)-1).add(productsTo.get(i)-1);
        	listRelation.get(productsTo.get(i)-1).add(productsFrom.get(i)-1);
        }
        
        
        // first..
        for(int i=0; i<listRelation.size(); i++) {
        	
        	// second
        	for(int j=0; j<listRelation.get(i).size(); j++) {
        		int secElem = listRelation.get(i).get(j);
        		
        		// third
        		for(int k=0; k<listRelation.get(secElem).size(); k++) {
        			int third = listRelation.get(secElem).get(k);
        			
        			if(listRelation.get(third).contains(i)) {
        				List<Integer> trio = new ArrayList<Integer>();
        				trio.add(i);
        				trio.add(secElem);
        				trio.add(third);
        				
        				int count = cntTrio(trio, listRelation);
        				if(result > count)
        					result = count;
        			}
        		}// third
        		
        	}// second
        	
        }// first..
        
        if(result == Integer.MAX_VALUE)
        	result = -1;
        return result;
    }
	
	static int cntTrio(List<Integer> trio, List<ArrayList<Integer>> listRelation) {
		int result = 0;
		
		int first = trio.get(0);
		int second = trio.get(1);
		int third = trio.get(2);
		
		for(int cur : listRelation.get(first)) {
			if(cur != second && cur != third)
				result++;
		}
		
		for(int cur : listRelation.get(second)) {
			if(cur != first && cur != third)
				result++;
		}
		
		for(int cur : listRelation.get(third)) {
			if(cur != second && cur != first)
				result++;
		}
		
		return result;
	}
	
	
	

}
