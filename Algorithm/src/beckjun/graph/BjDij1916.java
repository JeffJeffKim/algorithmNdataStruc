package beckjun.graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class BjDij1916 {

	static class Bus{
		int dest, cost;
		public Bus(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}
	
	static int N, M, sCity, eCity, costs[];
	static ArrayList<Bus>[] ways;
	static Queue<Bus> q = new PriorityQueue<>(new Comparator<Bus>() {
		@Override
		public int compare(Bus o1, Bus o2) {
			return o1.cost - o2.cost;
		}
		
	});
	
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		costs = new int[N];
		ways = new ArrayList[N];
		for(int i=0; i<N; i++)
			ways[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++)
			ways[sc.nextInt()-1].add(new Bus(sc.nextInt()-1, sc.nextInt()));
		
		sCity = sc.nextInt()-1;
		eCity = sc.nextInt()-1;
		
		Arrays.fill(costs, Integer.MAX_VALUE);
		costs[sCity] = 0;
		
		q.add(new Bus(sCity, 0));
		dijkstra();
		System.out.println(costs[eCity]);
	}
	
	private static void dijkstra(){
		while(!q.isEmpty()){
			Bus cur = q.poll();
			for(Bus next : ways[cur.dest]){
//				System.out.println(next.dest +" "+ costs[next.dest]+" "+ cur.dest +" "+ costs[cur.dest] +" "+ cur.cost);
				if(costs[next.dest] > costs[cur.dest] + next.cost){
					costs[next.dest] = costs[cur.dest] + next.cost;
					if(costs[next.dest] > costs[eCity])	continue;
					q.add(new Bus(next.dest, next.cost));
				}
			}
		}
	}

}
