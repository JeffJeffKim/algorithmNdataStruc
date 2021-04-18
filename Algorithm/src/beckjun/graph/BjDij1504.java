package beckjun.graph;

import java.util.*;

public class BjDij1504 {
	
	static class Info {
		int loc, dist;
		public Info(int loc, int dist) {
			this.loc = loc;
			this.dist = dist;
		}
	}
	
	static int cntN, cntE, stopA, stopB, INF=200001*1000;
	static boolean allThrough;
	static ArrayList<Info> map[];
	static Queue<Info> q = new PriorityQueue<Info>(new Comparator<Info>() {
		@Override
		public int compare(Info o1, Info o2) {
			return o1.dist - o2.dist;
		}
	});
		
	public static void main(String[] args) {
		getIn();
		int totDist = 0, dist1 = 0, dist2 = 0;
		int arrTarget1[] = {0, stopA, stopB, cntN-1};
		for(int i=0; i<arrTarget1.length-1; i++){
			dist1 += dij(arrTarget1[i], arrTarget1[i+1]);
		}
		int arrTarget[] = {0, stopB, stopA, cntN-1};
		for(int i=0; i<arrTarget.length-1; i++){
			dist2 += dij(arrTarget[i], arrTarget[i+1]);
		}
		totDist = Math.min(dist1, dist2);
		System.out.println(totDist > INF ? -1: totDist);
	}
	
	private static int dij(int start, int target) {
		int arrDist[] = new int[cntN];
		for(int i=0; i<arrDist.length; i++)
			arrDist[i] = INF;
		arrDist[start] = 0;
		q.add(new Info(start, 0));
		while(!q.isEmpty()){
			Info cur = q.poll();
			for(Info next : map[cur.loc]){
//				System.out.println(cur.loc+"->"+next.loc+": "+next.dist);
				int accuDist = arrDist[cur.loc] + next.dist;
				if(arrDist[next.loc] <= accuDist)	continue;
				if(arrDist[target] <= accuDist)	continue;
				arrDist[next.loc] = accuDist;
				q.add(new Info(next.loc, next.dist));
			}
		}
		return arrDist[target];
	}
	
	private static void getIn() {
		Scanner sc = new Scanner(System.in);
		cntN = sc.nextInt();
		cntE = sc.nextInt();
		map = new ArrayList[cntN];
		for(int i=0; i<cntN; i++){
			map[i] = new ArrayList<>();
		}
		for(int i=0; i<cntE; i++){
			int pointA = sc.nextInt()-1;
			int pointB = sc.nextInt()-1;
			int dist = sc.nextInt();
			map[pointA].add(new Info(pointB, dist));
			map[pointB].add(new Info(pointA, dist));
		}
		stopA = sc.nextInt()-1;
		stopB = sc.nextInt()-1;
		sc.close();
	}

}
