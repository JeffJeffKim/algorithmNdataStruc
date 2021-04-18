package programmers;

public class DevMatching2 {
	
	static public int[] solution(int rows, int columns, int[][] queries) {
		int tc = queries.length;
        int[] answer = new int[tc];
        
        int[][] map = new int[rows][columns];
        for(int r=0; r<rows; r++) {
        	for(int c=0; c<columns; c++) {
        		map[r][c] = (c+1) + (r*columns);
        	}
        }
        
        for(int t=0; t<tc; t++) {
        	int[] movArr = queries[t];
        	int y1 = movArr[0]-1;
        	int x1 = movArr[1]-1;
        	int y2 = movArr[2]-1;
        	int x2 = movArr[3]-1;
        	int size = (x2-x1+1)*2 + (y2-y1-1)*2;
        	int[] nums = new int[size];
        	int min = Integer.MAX_VALUE;
        	int idx = 0;
        	// scan
        	for(int c=x1; c<=x2; c++) {
        		nums[idx++] = map[y1][c];
        		if(min > map[y1][c])
        			min = map[y1][c];
        	}
        	
        	for(int r=y1+1; r<=y2; r++) {
        		nums[idx++] = map[r][x2];
        		if(min > map[r][x2])
        			min = map[r][x2];
        	}
        	
        	for(int c=x2-1; c>=x1; c--) {
        		nums[idx++] = map[y2][c];
        		if(min > map[y2][c])
        			min = map[y2][c];
        	}
        	
        	for(int r=y2-1; r>=y1+1; r--) {
        		nums[idx++] = map[r][x1];
        		if(min > map[r][x1])
        			min = map[r][x1];
        	}
        	answer[t] = min;
        	
        	
        	//insert
        	map[y1][x1] = nums[nums.length-1];
        	idx = 0;
        	for(int c=x1+1; c<=x2; c++) {
        		map[y1][c] = nums[idx++];
        	}
        	
        	for(int r=y1+1; r<=y2; r++) {
        		map[r][x2] = nums[idx++];
        	}
        	
        	for(int c=x2-1; c>=x1; c--) {
        		map[y2][c] = nums[idx++];
        	}
        	
        	for(int r=y2-1; r>=y1+1; r--) {
        		map[r][x1] = nums[idx++];
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		int[][] arr;
		arr = new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		solution(6,6,arr);
		
		arr = new int[][]{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
		solution(3,3,arr);
		
		arr = new int[][]{{1,1,100,97}};
		solution(100,97,arr);
	}

}
