package company.stepPay;

import java.util.ArrayList;

public class StepPay1 {

    public static int solution(int n, int m) {
        int answer = 0;
        int preLen = 0, curLen = 0;
        int preFirst = 0, curFirst = 0;
        preLen = String.valueOf(n).length();
        for(int t = n; t<m; t++) {
        	int num = t;
        	ArrayList<Integer> arr = new ArrayList<>();
        	while(num/10 != 0) {
        		arr.add(num%10);
        		num /= 10;
        	}
        	arr.add(num%10);
        	
        	boolean mirror = true;
        	for(int i=0, j=arr.size()-1; i<=(arr.size()-1)/2; i++, j--) {
        		if(arr.get(i) == arr.get(j))
        			continue;
        		
        		mirror = false;
        		break;
        	}
        	
        	if(mirror)
        		answer++;
        }

        return answer;
    }
    
	public static void main(String[] args) {
		System.out.println(solution(1, 100));
		System.out.println(solution(100, 300));
		
	}

}
