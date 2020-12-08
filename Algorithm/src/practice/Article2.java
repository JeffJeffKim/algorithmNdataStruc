package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Article2 {

	public static void main(String[] args) {
		List<List<Integer>> samples = Arrays.asList(Arrays.asList(1,1,1), Arrays.asList(1,1,0), Arrays.asList(1,0,1));
		System.out.println(largestArea(samples));

	}
	
	
	public static int largestArea(List<List<Integer>> samples) {
		// Write your code here
		int result = 0;
		for(int i=0; i<samples.size(); i++) {
			List<Integer> row = samples.get(i);
			for(int j=0; j<row.size()-result; j++) {
				if(row.get(j) == 1) {
					int cur = 1;
					while(i+cur < row.size()-1 && j+cur < samples.size()-1)
						if(row.get(j+cur) == 1 && samples.get(i+cur).get(j) == 1 && samples.get(i+cur).get(j+cur) ==1)
							cur++;
					if(result < cur)
						result = cur;
				}
			}
		}
		return result;
	}
	

	public static int largestArea1(List<List<Integer>> samples) {
		// Write your code here
		int result = 0, limit = 501;
		for(int i=0; i<samples.size(); i++) {
			List<Integer> row = samples.get(i);
			for(int j=0; j<row.size(); j++) {
				int curResult = 0;
				if(row.get(j) == 1) {
					curResult++;
					Queue<Integer> q = new LinkedList<Integer>(); 
					q.add(j*limit + i);
					while(!q.isEmpty()) {
						int x=j/limit, y=i%limit;
						while(x+1 < row.size()-1 && y+1 < samples.size()-1) {
							if(row.get(x+1)==1 && samples.get(y+1).get(x)==1 && samples.get(y+1).get(x)==1) {
								curResult++;
								x++; y++;
								q.add((x+1)*limit + y);
							}
							else
								break;
						}
						
					}
					if(result < curResult)
						result = curResult;
				}
			}
		}
		
		return result;
	}
	
	public static int getMax(List<List<Integer>> samples, int x, int y) {
		int result = 1;
		
		return result;
	}

}
