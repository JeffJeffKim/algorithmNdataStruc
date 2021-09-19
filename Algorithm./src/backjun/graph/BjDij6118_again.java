package backjun.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class BjDij6118_again {
	
	static int cnt, inCnt, room, dist;
	static ArrayList<Integer> map[], sameDist = new ArrayList<>();
	static boolean visit[];
	
	public static void main(String[] args) {
		getIn();
		dij();
		
		int min=Integer.MAX_VALUE, sameCnt=0;
		for(int i : sameDist){
			if(i < min)	min = i;
			sameCnt++;
		}
		System.out.print(min + " " + dist +" "+ sameCnt);
	}
	
	private static void dij(){
		Queue<ArrayList<Integer>> q = new ArrayDeque<>(); 
		visit[1] = true;
		ArrayList<Integer> listNext = new ArrayList<>();
		listNext.add(1);
		q.add(listNext);
		sameDist.add(1);
		while(!q.isEmpty()){
			ArrayList<Integer> listCur = q.poll();
			boolean isFirst = false;
			
			for(int cur : listCur){
				listNext = new ArrayList<>();
				for(int next : map[cur]){
					if(visit[next])	continue;
					if(!isFirst){
						isFirst = true;
						sameDist = new ArrayList<>();
					}
					visit[next] = true;
					sameDist.add(next);
					listNext.add(next);
				}
				q.add(listNext);
			}
			if(isFirst)	dist++;
		}
	}
	
	private static void getIn(){
		Scanner sc = new Scanner(System.in);
		cnt = sc.nextInt();
		inCnt = sc.nextInt();
		map = new ArrayList[cnt+1];
		visit = new boolean[cnt+1];
		for(int i=0; i<map.length; i++){
			map[i] = new ArrayList<>();
		}
		for(int i=0; i<inCnt; i++){
			int j = sc.nextInt();
			int k = sc.nextInt();
			map[j].add(k);
			map[k].add(j);
		}
	}

}
