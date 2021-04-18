package programmers;

public class DevMatching1 {

    static public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        boolean[] dat = new boolean[46];
        int countZero = 0;
        int countMatch = 0;
        
        for (int num : win_nums)
        	dat[num] = true;
        
        for (int num : lottos) {
        	if(num == 0) {
        		countZero++;
        		continue;
        	}
        	if(dat[num]) {
        		countMatch++;
        	}
        }
        
        int countSum = countMatch + countZero;
        int rank[] = {6, 6, 5, 4, 3, 2, 1};
        answer[0] = rank[countSum];
        answer[1] = rank[countMatch];
        
        return answer;
    }
    
	public static void main(String[] args) {
		int[] win_nums = {31,10,45,1,6,19};
		int[] lottos = {44,1,0,0,31,25};
		System.out.println(solution(lottos, win_nums));
		
		win_nums = new int[]{38,10,45,1,6,19};
		lottos = new int[]{0,0,0,0,0,0};
		System.out.println(solution(lottos, win_nums));

		win_nums = new int[]{45,4,35,20,3,9};
		lottos = new int[]{20,9,3,45,4,35};
		System.out.println(solution(lottos, win_nums));
	}

}
