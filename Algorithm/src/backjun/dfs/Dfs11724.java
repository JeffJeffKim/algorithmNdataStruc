package backjun.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Dfs11724 {
	
	static int cntNode, cntEdge;
	static ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
	static boolean visit[];
	
	public static void main(String[] args) {
		getIn();
		int result = 0;
		for(int i=0; i<map.size(); i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(map.get(i));
				result++;
			}
		}
		System.out.println(result);
	}
	
	static void dfs(ArrayList<Integer> list) {
		
		for(int idx : list) {
			if(!visit[idx]) {
				visit[idx] = true;
				dfs(map.get(idx));
			}
		}
	}
	
	static void getIn() {
		Scanner sc = new Scanner(System.in);
		cntNode = sc.nextInt();
		cntEdge = sc.nextInt();
		visit = new boolean[cntNode];
		for(int i=0; i<cntNode; i++) {
			map.add(new ArrayList<Integer>());
		}
		for(int i=0; i<cntEdge; i++) {
			int a = sc.nextInt()-1, b = sc.nextInt()-1;
			map.get(a).add(b);
			map.get(b).add(a);
		}
		sc.close();
	}

}
