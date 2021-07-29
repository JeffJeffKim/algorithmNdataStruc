package backjun.graph;

import java.io.*;
import java.util.*;

public class BjDij1753_usingListMapPQ {
	
	static class Info /*implements Comparable<Info>*/ {
		public int dest, cost;
		public String a, b;

		public Info(int curLoc, int curCost) {
			this.dest = curLoc;
			this.cost = curCost;
		}

//		@Override
//		public int compareTo(Info o) {
//			return o.cost;
//		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int cost[], V, E;
	static ArrayList<Info>[] map;
//	static Queue<Info> q = new ArrayDeque<>();
	static PriorityQueue<Info> q = new PriorityQueue<>(new Comparator<Info>() {
		@Override
		public int compare(Info o1, Info o2) {
			return o1.cost - o2.cost;
		}
	});
	
//	static PriorityQueue<Info> q1 = new PriorityQueue<Info>((o1,o2) -> o1.cost - o2.cost);
	
	private static void dijkstra()  {
		while(!q.isEmpty()){
			Info cur = q.poll();
			for(Info next : map[cur.dest]){
				if(cur.cost + next.cost < cost[next.dest]){
					cost[next.dest] = cost[cur.dest] + next.cost;
					q.add(new Info(next.dest, cost[next.dest]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		int launch = sc.nextInt() -1;
		
		map = new ArrayList[V];
		cost = new int[V];
		Arrays.fill(cost, INF);
		cost[launch] = 0;
		q.add(new Info(launch, 0));
		
		for(int i=0; i<V; i++){
			map[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++){
			int start = sc.nextInt()-1;
			int dest = sc.nextInt()-1;
			int weight = sc.nextInt();
			
			map[start].add(new Info(dest, weight));
		}
		
		dijkstra();
		
		for(int i=0; i<V; i++){
			if(cost[i] == INF){
				System.out.println("INF");
			}else{
				
				System.out.println(cost[i]);
			}
		}
	}

}
