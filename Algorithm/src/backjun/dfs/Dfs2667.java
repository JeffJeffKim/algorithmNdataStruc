package backjun.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;


public class Dfs2667 {
	static int curCnt;
	
	public static void main(String[] args) {
		List<Integer> l0 = Arrays.asList(0,1,1,0,1,0,0); 
		List<Integer> l1 = Arrays.asList(0,1,1,0,1,0,1); 
		List<Integer> l2 = Arrays.asList(1,1,1,0,1,0,1); 
		List<Integer> l3 = Arrays.asList(0,0,0,0,1,1,1); 
		List<Integer> l4 = Arrays.asList(0,1,0,0,0,0,0); 
		List<Integer> l5 = Arrays.asList(0,1,1,1,1,1,0); 
		List<Integer> l6 = Arrays.asList(0,1,1,1,0,0,0);
		List<List<Integer>> input = Arrays.asList(l0, l1, l2, l3, l4, l5, l6);
		Dfs2667 obj = new Dfs2667();
		obj.printResult(input);
	}
	
	void printResult(List<List<Integer>> list){
		int total = 0;
		List<Integer> count = new ArrayList<Integer>();
		for(int y=0; y<list.size(); y++) {
			for(int x=0; x<list.get(y).size(); x++) {
				if(list.get(y).get(x) != 0) {
					total++;
					curCnt=0;
					dfs(list, y, x);
					count.add(curCnt);
				}
			}
		}
		System.out.println(total);
		for(int n:count)
			System.out.println(n);
	}
	
	void dfs(List<List<Integer>> map, int y, int x) {
		int dx[] = {0,0,-1,1}, dy[] = {-1,1,0,0};
		map.get(y).set(x, 0);
		curCnt++;
		for(int i=0; i<dx.length; i++) {
			int xx=x+dx[i], yy=y+dy[i];
			if(xx<0 || yy<0 || xx>map.get(0).size()-1 || yy>map.size()-1)
				continue;
			if(map.get(yy).get(xx) != 0) 
				dfs(map, yy, xx);
		}
	}

}
