package company.programmers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Hash1 {
	    public String solution(String[] participant, String[] completion) {
	        String answer = "";
	        Map<String, Integer> mapP = new HashMap<>();
	        Map<String, Integer> mapC = new HashMap<>();
	        for(String str : participant) {
	            if(mapP.containsKey(str))
	                mapP.put(str, mapP.get(str)+1);
	            else
	                mapP.put(str, 1);
	        }
	        
	        for(String str : completion) {
	            if(mapC.containsKey(str))
	                mapC.put(str, mapC.get(str)+1);
	            else
	                mapC.put(str, 1);
	        }
	        
	        Iterator<String> keys = mapP.keySet().iterator();
	        while(keys.hasNext()) {
	            String key = keys.next();
	            int pCnt = mapP.get(key);
	            if(mapC.containsKey(key)) {
	                int cCnt = mapC.get(key);
	                if(pCnt == cCnt)
	                    continue;
	                answer = key;
	                break;
	            } else {
	                answer = key;
	                break;
	            }
	        }
	        return answer;
	    }
}
