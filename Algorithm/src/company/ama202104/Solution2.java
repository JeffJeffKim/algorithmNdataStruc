package company.ama202104;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution2 {
	
//	static int[] group;
	static int[] uArr;
//	static boolean[] bArr;
	static int groupedCnt = 0;
	static int unionCnt = 0;
	
	
	public static void main(String[] args) {
		System.out.println(countGroups(Arrays.asList("1100", "1110", "0110", "0001")));
	}
	
    public static int countGroups(List<String> related) {
    // Write your code here
    	int result = 0;
    	int size = related.size();
    	int[][] map = new int[size][size];
//    	group = new int[size];
    	uArr = new int[size];
//    	Arrays.fill(uArr, val);
//    	bArr = new boolean[size];
    	
    	int lineIdx = -1;
    	for(String line : related) {
    		lineIdx++;
    		for(int i=0; i<line.length(); i++) {
    			map[lineIdx][i] = Integer.parseInt(line.substring(i, i+1));
    		}
    	}
    	
    	for(int i=0; i<size; i++) {
    		for(int j=0; j<size; j++) {
    			if(i == j)
    				continue;
    			
    			if(map[i][j] == 0)
    				continue;
//    			uArr[i] = j;
    			union(i, j);
    		}
    	}
    	if(unionCnt > 0) {
    		result--;
    		
    		HashSet<Integer> set = new HashSet<>();
    		for(int num : uArr) {
    			if(num != 0)
    				set.add(num);
    			else
    				result++;
    		}
    		result += set.size();
    	} 
    	
    	return result;
    }
    
	static int find(int a) {
		if(uArr[a] == 0)
			return a;
		int ret = find(uArr[a]);
		uArr[a] = ret;
		return ret;
	}
	
	static void union (int t1, int t2) {
		int a = find(t1);
		int b = find(t2);
		if(a == b)
			return;
		uArr[b] = a;
//		if(!bArr[a]) {
//			bArr[a] = true;
//			groupedCnt++;
//		}
//		if(!bArr[b]) {
//			bArr[b] = true;
//			groupedCnt++;
//		}
		unionCnt++;
	}

}
