// https://www.acmicpc.net/problem/1504
package backjun.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Dijkstra_1504 {

	static int cntNode, cntEdge, pA, pB, arrCost[], INF=200001*1000;
	static Map<Integer, List<Location>> map = new HashMap<Integer, List<Location>>();

	static class Location {
		public int node, cost;

		public Location(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
	}

	public static void main(String[] args) {
		getIn();
		int costA = getCost(pA, pB);
		int costB = getCost(pB, pA);
		System.out.println(Math.min(costA, costB));
	}

	private static int getPartCost(int start, int end) {
		Arrays.fill(arrCost, INF);
		Queue<Location> q = new PriorityQueue<Location>(
				Comparator.comparing(l -> l.cost));
//		q = new PriorityQueue<Location>(new Comparator<Location>() {
//			public int compare(Location o1, Location o2) {
//				return 0;
//			}
//		});
		q.add(new Location(start, 0));
		
		while (!q.isEmpty()) {
			Location prev = q.poll();
//			int prevLoc = prev.node;
			for (Location next : map.get(prev.node)) {
//				if (prev.node == next.end) {
					if (arrCost[next.node] > prev.cost + next.cost) {
						arrCost[next.node] = prev.cost + next.cost;
						q.add(new Location(next.node, arrCost[next.node]));
//						q.add(new Location(next.node, next.cost));
					}
//				}
			}
		}
		
		return arrCost[end];
	}

	private static int getCost(int pFirst, int pSecond) {
		int result = getPartCost(1, pFirst) 
				+ getPartCost(pFirst, pSecond) 
				+ getPartCost(pSecond, cntNode);
		
		if(result > INF)	result = -1;
		return result;
	}

	private static void getIn() {
		Scanner sc = new Scanner(System.in);
		cntNode = sc.nextInt();
		cntEdge = sc.nextInt();
		for (int i=1; i<=cntNode; i++) {
			map.put(i, new ArrayList<Location>());
		}
		for (int i = 0; i < cntEdge; i++) {
			int pointA = sc.nextInt();
			int pointB = sc.nextInt();
			int cost = sc.nextInt();
			map.get(pointA).add(new Location(pointB, cost));
			map.get(pointB).add(new Location(pointA, cost));
		}
		pA = sc.nextInt();
		pB = sc.nextInt();
		sc.close();
		arrCost = new int[cntNode + 1];
	}

}
