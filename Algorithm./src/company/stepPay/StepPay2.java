package company.stepPay;

import java.util.Arrays;

public class StepPay2 {

    static public int solution(int no, int[] works) {
        int result = 0;
        Arrays.sort(works);
        for(int i=0; i<no; i++) {
        	int last = works[works.length-1];
        	if(last > 0)
        		works[works.length-1] = --last;
        	
        	if(works.length > 1) {
        		for(int j=works.length-1; j>=1; j--) {
        			if(works[j] < works[j-1]) {
        				int temp = works[j];
        				works[j] = works[j-1];
        				works[j-1] = temp;
        			} else {
        				break;
        			}
        		}
        	}
        }
        
        for(int i=0; i<works.length; i++) {
        	result += works[i] * works[i];
        }

        return result;
    }
    
	public static void main(String[] args) {
		System.out.println(solution(4, new int[] {4,3,3}));
		System.out.println(solution(2, new int[] {3,3,3}));
	}

}
