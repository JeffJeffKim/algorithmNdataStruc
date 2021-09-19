package company.programmers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DevMatching3 {
	
	
	static public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		//enroll ������, referral ����, 
        int[] answer = new int[enroll.length];
        final int mul = 100;
        Map<String, Node> map = new HashMap<String, Node>();
        
        for(int i=0; i<enroll.length; i++) {
        	String name = enroll[i];
        	String boss = referral[i];
        	Node node = new Node();
//        	node.name = name;
        	node.idx = i;
        	node.boss = boss;
        	map.put(name, node);
        }
        
        for(int i=0; i<seller.length; i++) {
        	Node node = map.get(seller[i]);
        	int tAmount = amount[i]*mul;
        	int bossAmount = 0;
        	if(tAmount < 10) {
        		node.amount = tAmount;
        		continue;
        	} 
        	
    		node.amount = (tAmount/10)*9;
    		bossAmount = tAmount - (tAmount/10)*9;
        	
        	while(node.boss != "-") {
        		node = map.get(node.boss);
        		tAmount = bossAmount;
        		if(tAmount < 10) {
            		node.amount = tAmount;
            		break;
            	} 
        		
            	node.amount += (tAmount/10)*9;
            	bossAmount = tAmount - (tAmount/10)*9;
        	}
        }
        
        Iterator<String> keys = map.keySet().iterator();
        while(keys.hasNext()){
        	String key = keys.next();
        	Node node = map.get(key);
        	answer[node.idx] = node.amount;
        }
        
        
        return answer;
    }
	
	static class Node {
//		public String name;
		public int idx;
		public String boss;
		public int amount;
		public int result;
	}
	
	public static void main(String[] args) {
		String[] enroll, referral, seller;
		int[] amount;
		enroll = new String[] {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		referral = new String[] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		seller = new String[] {"young", "john", "tod", "emily", "mary"};
		amount = new int[] {12, 4, 2, 5, 10};
		solution(enroll, referral, seller, amount);
		
		seller = new String[] {"sam", "emily", "jaimie", "edward"};
		amount = new int[] {2, 3, 5, 4};
		solution(enroll, referral, seller, amount);
	}
	
}
