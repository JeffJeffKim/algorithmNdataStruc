package pro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinDist_1753 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cntNode = sc.nextInt();
		int cntPath = sc.nextInt();
		int startP = sc.nextInt()-1;
		// <s, <e, d>>
		var map = new ArrayList<ArrayList<Node>>();
		int s=0, e=0, d=0, arrDist[] = new int[cntNode];
		
		for(int i = 0; i<cntNode; i++) {
			map.add(new ArrayList<Node>());
			arrDist[i] = Integer.MAX_VALUE;
		}
		arrDist[startP] = 0;
		
		for (int i = 0; i < cntPath; i++) {
			s = sc.nextInt()-1;
			e = sc.nextInt()-1;
			d = sc.nextInt();
			map.get(s).add(new Node(e,d));
		}
		sc.close();
		
		var q = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.d - o2.d;
			}
		});
		
		for(Node n : map.get(startP)) {
			q.add(n);
		}
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(arrDist[n.e] > n.d) {
				arrDist[n.e] = n.d;
				for(Node next : map.get(n.e)) {
					if(arrDist[next.e] > n.d + next.d) {
						next.d += n.d;
						q.add(next);
					}
				}
			}
		}
		
		for(int i=0; i<arrDist.length; i++) {
			if(arrDist[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(arrDist[i]);
		}
	}
	
	static class Node {
		int e, d;
		public Node (int e, int d) {
			this.e = e;	this.d = d;
		}
	}

}
