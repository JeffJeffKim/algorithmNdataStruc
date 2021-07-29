package backjun.graph;

import java.util.*;

public class BjDij1238 {
	
	static class Info{
		public int dest, cost;

		public Info(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}
	
	static int cntCity, cntRoad, targetCity, INF = Integer.MAX_VALUE;
	static ArrayList<Info>[] map;
	static Queue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
		@Override
		public int compare(Info o1, Info o2) {
			return o1.cost - o2.cost;
		}
	});
	
	public static void main(String[] args) {
		getIn();
		int max = 0;
		for(int i=0; i<cntCity; i++){
			if(i == targetCity)	continue;
			int curDist = getDist(i, targetCity) + getDist(targetCity, i);
			if(max < curDist)
				max = curDist;
		}
		System.out.println(max);
	}
	
	private static int getDist(int curCity, int curTarget){
		int dist = INF;
		int cost[] = new int[cntCity];
		for(int i=0; i<cost.length; i++){
			cost[i] = INF;
		}
		cost[curCity] = 0;
		pq.add(new Info(curCity, 0));
		while(!pq.isEmpty()){
			Info cur = pq.poll();
			for(Info next : map[cur.dest]){
				if(cost[next.dest] > cost[cur.dest] + next.cost){
					cost[next.dest] = cost[cur.dest] + next.cost;
					pq.add(new Info(next.dest, next.cost));
					if(next.dest == curTarget && dist > cost[next.dest])
						dist = cost[next.dest];
				}
			}
		}
		
		return dist;
	}
	
	private static void getIn(){
		Scanner sc = new Scanner(System.in);
		cntCity = sc.nextInt();
		cntRoad = sc.nextInt();
		targetCity = sc.nextInt()-1;
		map = new ArrayList[cntCity];
		
		for(int i=0; i<map.length; i++){
			map[i] = new ArrayList<>();
		}
		
		for(int i=0; i<cntRoad; i++){
//			map[sc.nextInt()-1].add(new Info(sc.nextInt()-1, sc.nextInt()));
			int cur = sc.nextInt()-1;
			int next = sc.nextInt()-1;
			int cost = sc.nextInt();
			map[cur].add(new Info(next, cost));
		}
	}
}
