package backjun.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Dij1916 {
	static int cntCity, cntBus, pStart, pEnd, map[][], arrCost[];
	
	static class City {
		public int loc, cost;
		public City (int loc, int cost) {
			this.loc = loc;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) {
		getInput();
		Queue<City> q = new PriorityQueue<City>(Comparator.comparing(c -> c.cost));
		dii(pStart, q);
		System.out.println(arrCost[pEnd]);
	}
	
	private static void dii(int start, Queue<City> q) {
		q.add(new City(start, 0));
		while(!q.isEmpty()) {
			City prev = q.poll();
			start = prev.loc;
			for(int i=0; i<cntBus; i++) {
				if(map[i][0] == start) {
					int destLoc = map[i][1];
					int destCost = map[i][2];
					if(arrCost[destLoc] > prev.cost + destCost) {
						arrCost[destLoc] = prev.cost + destCost;
						q.add(new City(destLoc, arrCost[destLoc]));
					}
				}
			}
		}
	}
	
	
	private static void getInput() {
		Scanner sc = new Scanner(System.in);
		cntCity = sc.nextInt();
		cntBus = sc.nextInt();
		map = new int[cntBus][3];
		for(int i=0; i<cntBus; i++) {
			map[i][0] = sc.nextInt()-1;
			map[i][1] = sc.nextInt()-1;
			map[i][2] = sc.nextInt();
		}
		pStart = sc.nextInt()-1;
		pEnd = sc.nextInt()-1;
		
		sc.close();
		
		arrCost = new int[cntCity];
		Arrays.fill(arrCost, Integer.MAX_VALUE);
	}

}
