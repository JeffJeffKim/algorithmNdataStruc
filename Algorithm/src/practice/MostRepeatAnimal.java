package practice;

import java.util.HashMap;
import java.util.Iterator;

public class MostRepeatAnimal {
	
	public static void main(String[] args) {
		String[] arr = 
			{"dog", "cat", "dog", "horse"};
//			{"dog", "cat", "cat", "horse"};
//			{"dog", "cat", "dog", "horse", "horse"};
		var map = makeMap(arr);
		String result = getMostRepeat(map);
		System.out.println(result);
	}
	
	static HashMap<String, Integer> makeMap(String[] arr){
		var map = new HashMap<String, Integer>();
		for(String animal : arr) {
			int num = 0;
			if(map.containsKey(animal)) 
				num = map.get(animal);
			map.put(animal, num+1);
		}
		
		return map;
	}
	
	static String getMostRepeat(HashMap<String, Integer> map) {
		String result="";
		int max = 0;
		Iterator<String> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			int curNum = map.get(key);
			if(max < curNum) {
				max = curNum;
				result = key;
			}else if(max == curNum) {
				result = "Draw";
			}
		}
		
		return result;
	}
}
