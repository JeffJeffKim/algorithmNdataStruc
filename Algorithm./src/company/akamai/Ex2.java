package company.akamai;

import java.util.List;

public class Ex2 {
	
	public static void main(String[] args) {
		List<Integer> list = List.of(1,1,1);
//		List<Integer> list = List.of(2, 0, 0, 0);
		System.out.println(fountainActivation(list));
	}
	
    static int result;

    public static int fountainActivation(List<Integer> locations) {
    // Write your code here
        result = Integer.MAX_VALUE;
        int size = locations.size();
        boolean[] covered = new boolean[size+1];
        getCount(0, covered, locations, 1);
        return result;
    }
    
    static void getCount(int cnt, boolean[] covered, List<Integer> locations, int depth){
        if(depth >= locations.size()+1){
            if(isCoveredAll(covered))
                if(result > cnt && cnt > 0)
                    result = cnt;
            return;
        }
        
        // apply
        boolean[] updatedCovered = getCoverage(covered, locations, depth);
        getCount(cnt+1, updatedCovered, locations, depth+1);
        // no-apply
        getCount(cnt, covered, locations, depth+1);
    }
    
    static boolean[] getCoverage(boolean[] covered, List<Integer> locations, int curLoc) {
        boolean[] result = new boolean[covered.length];
        for(int i=0; i<covered.length; i++)
        	result[i] = covered[i];
    	
    	int range = locations.get(curLoc-1);
        int start = Math.max(1, curLoc-range);
        int end = Math.min(locations.size(), curLoc+range);
        for(int i=start; i<=end; i++) {
        	result[i] = true;
        }
        return result;
    }
    
    static boolean isCoveredAll(boolean[] covered) {
        boolean result = true;
        for(int i=1; i<covered.length; i++)
            if(!covered[i]){
                result = false;
                break;
            }
        return result;
    }

}
