// https://www.acmicpc.net/problem/2667

package backjun.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class BuildingBlock2667 {
	
	public static void main(String[] args) {
		List<Integer> l0 = Arrays.asList(0,1,1,0,1,0,0); 
		List<Integer> l1 = Arrays.asList(0,1,1,0,1,0,1); 
		List<Integer> l2 = Arrays.asList(1,1,1,0,1,0,1); 
		List<Integer> l3 = Arrays.asList(0,0,0,0,1,1,1); 
		List<Integer> l4 = Arrays.asList(0,1,0,0,0,0,0); 
		List<Integer> l5 = Arrays.asList(0,1,1,1,1,1,0); 
		List<Integer> l6 = Arrays.asList(0,1,1,1,0,0,0);
		List<List<Integer>> input = Arrays.asList(l0, l1, l2, l3, l4, l5, l6);
		
		BuildingBlock2667 obj = new BuildingBlock2667();
		obj.printResult(input);
	}
	
	void printResult(List<List<Integer>> map) {
		int totLoc = 0;
		List<Integer> listArea = new ArrayList<Integer>();
		
		for(int i=0; i<map.size(); i++) {
			for(int j=0; j<map.get(i).size(); j++) {
				if(map.get(i).get(j) != 0) {
					listArea.add(getArea(map, i, j));
					totLoc++;
				}
			}
		}
		
		System.out.println(totLoc);
		for(int n:listArea)
			System.out.println(n);
	}
	
	int getArea(List<List<Integer>> map, int y, int x) {
		int dx[] = {0,0,-1,1}, dy[] = {-1,1,0,0}, loc[] = {y,x}, result = 0;
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		q.add(loc);
		map.get(y).set(x, 0);
		
		while(!q.isEmpty()) {
			loc=q.poll();
			y = loc[0]; x = loc[1];
			result++;
			
			for(int i=0; i<dx.length; i++) {
				int xx=x+dx[i], yy=y+dy[i];
				if(xx<0 || yy<0 || xx>map.get(0).size()-1 || yy>map.size()-1)
					continue;
				
				if(map.get(yy).get(xx) != 0) {
					map.get(yy).set(xx, 0);
					q.add(new int[] {yy,xx});
				}
			}
		}
		
		return result;
	}

}
