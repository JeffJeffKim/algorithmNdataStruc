package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PhoneList {
	
	public static void main(String[] args) {
		// f f f t t f f 
		String[] phone_book = new String[]{"119", "1195524421"};
		System.out.println(solution(phone_book));
		phone_book = new String[]{"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));
		phone_book = new String[]{"97674223", "1195524421", "119"};
		System.out.println(solution(phone_book));
		phone_book = new String[]{"1195524421", "1194"};
		System.out.println(solution(phone_book));
		phone_book = new String[]{"123", "456", "789"};
		System.out.println(solution(phone_book));
		phone_book = new String[]{"1", "12"};
		System.out.println(solution(phone_book));
		phone_book = new String[]{"123", "12"};
		System.out.println(solution(phone_book));
	}
	
	static public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Map<Character, Object> map = new HashMap<Character, Object>();
        loop: for(String phone : phone_book) {
        	int len = phone.length();
        	Map<Character, Object> cur = null;
        	boolean isExist = false;
        	for(int i=0; i<len; i++) {
        		if(i != 0) {
        			if(isExist && cur.isEmpty()) {
        				answer = false;
    					break loop;
        			}
        			if(cur.containsKey(phone.charAt(i))) {
        				if(i == len-1 && isExist) {
        					answer = false;
        					break loop;
        				}
        				cur = (Map<Character, Object>) cur.get(phone.charAt(i));
        			} else {
        				if(isExist && i < len-1) {
        					answer = false;
        					break loop;
//        					if(i == len -1) {
//        					} 
        				}
//        				isExist = false;
        				cur.put(phone.charAt(i), new HashMap<Character, Object>());
        				cur = (Map<Character, Object>) cur.get(phone.charAt(i));
        			}
        		}else if (i == 0 && map.containsKey(phone.charAt(i))) {
        			if(len == 0) {
        				answer = false;
    					break loop;
        			}
        			cur = (Map<Character, Object>) map.get(phone.charAt(i));
        			isExist = true;
        		}else{
        			cur = new HashMap<Character, Object>();
        			map.put(phone.charAt(i), cur);
        		}
        	}
        	
        }
        
//        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
//        for(String phone : phone_book) {
//        	String init = phone.substring(0, 1);
//        	if(map.containsKey(init)) {
//        		map.get(init).add(phone);
//        	} else {
//        		map.put(init, (ArrayList<String>) Arrays.asList(init));
//        	}
//        }
        
               
        
//        
//        Iterator<String> keys = map.keySet().iterator();
//        while(keys.hasNext()) {
//        	
//        }
        return answer;
    }
}

class Node {
	char c;
	Node node;
	boolean isEnd;
}