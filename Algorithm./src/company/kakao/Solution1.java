package company.kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution1 {
	
	public static void main(String[] args) {
		ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
		arr.add(new ArrayList<>());
		arr.get(0).add("Frodo");
		arr.get(0).add("Apeach");
		arr.get(0).add("7");
		arr.add(new ArrayList<>());
		arr.get(1).add("Frodo");
		arr.get(1).add("Apeach");
		arr.get(1).add("3");
		arr.add(new ArrayList<>());
		arr.get(2).add("Apeach");
		arr.get(2).add("Frodo");
		arr.get(2).add("4");
		arr.add(new ArrayList<>());
		arr.get(3).add("Frodo");
		arr.get(3).add("Apeach");
		arr.get(3).add("1");
		arr.add(new ArrayList<>());
		arr.get(4).add("Apeach");
		arr.get(4).add("Frodo");
		arr.get(4).add("7");
		System.out.println(solution(arr));
		
		arr = new ArrayList<ArrayList<String>>();
		arr.add(new ArrayList<>());
		arr.get(0).add("Apeach");
		arr.get(0).add("Frodo");
		arr.get(0).add("5");
		arr.add(new ArrayList<>());
		arr.get(1).add("Frodo");
		arr.get(1).add("Apeach");
		arr.get(1).add("3");
		arr.add(new ArrayList<>());
		arr.get(2).add("Tube");
		arr.get(2).add("Apeach");
		arr.get(2).add("7");
		arr.add(new ArrayList<>());
		arr.get(3).add("Tube");
		arr.get(3).add("Apeach");
		arr.get(3).add("4");
		arr.add(new ArrayList<>());
		arr.get(4).add("Tube");
		arr.get(4).add("Apeach");
		arr.get(4).add("2");
		System.out.println(solution(arr));
		
		arr = new ArrayList<ArrayList<String>>();
		arr.add(new ArrayList<>());
		arr.get(0).add("Apeach");
		arr.get(0).add("Frodo");
		arr.get(0).add("5");
		System.out.println(solution(arr));
		
		System.out.println(200000000);
		System.out.println(Integer.MAX_VALUE);
	}
	
	public static List<String> solution(ArrayList<ArrayList<String>> arr) {
		
    // Write your code here
        List<String> result = new ArrayList<>();
        Map<String, Integer> record = new HashMap<>();
//        int min = Integer.MAX_VALUE;
        int min = 0;
        for(List<String> cur : arr) {
        	String renter = cur.get(0);
            String giver = cur.get(1);
            int amount = Integer.parseInt(cur.get(2));
            if (record.containsKey(giver)) {
                record.put(giver, record.get(giver) + amount);
            } else {
                record.put(giver, amount);
            }
            
            if(record.containsKey(renter)) {
                record.put(renter, record.get(renter) - amount);
            } else {
                record.put(renter, amount*-1);
            }
        }
//        List<String> curMin = new ArrayList<String>();
        Iterator<String> keys = record.keySet().iterator();
        while(keys.hasNext()) {
        	String name = keys.next();
        	int amount = record.get(name);
        	if(amount < 0) {
        		if(min > amount) {
        			result = new ArrayList<String>();
        			result.add(name);
        			min = amount;
        		} else if (min == amount) {
        			result.add(name);
        		}
        		
        	}
        }
        
        if(min >= 0) {
            result.add("None");
        } 
        
        Collections.sort(result);
        
        return result;
    }

}
