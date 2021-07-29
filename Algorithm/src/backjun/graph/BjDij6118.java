package backjun.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BjDij6118 {
	static int roomCnt;
	static boolean map[][], visit[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		roomCnt = sc.nextInt();	int inCnt = sc.nextInt();
		map = new boolean[roomCnt+1][roomCnt+1];	visit = new boolean[roomCnt+1];
		int inX, inY;	visit[0] = true;
		for(int i=0; i<inCnt; i++) {
			inX = sc.nextInt(); inY = sc.nextInt();
			map[inX][inY] = true;
			map[inY][inX] = true;
		}
		sc.close();
		bfs(1);
	}
	
	public static void bfs(int n) {
		int dist=0, cntSol=0, roomNo, finalDist=0,  multi=60000, cntVisit=1;
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
		ArrayList<Integer> list;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		visit[n]=true;
		q.add(n*multi + dist);
		while(!q.isEmpty()) {
			n = q.poll();
			roomNo = n/multi; dist = n%multi +1;
			list = new ArrayList<>();
			for(int i=1; i<roomCnt+1; i++) {
				if(map[roomNo][i]) {
					if(visit[i])	continue;
					visit[i] = true;
					cntVisit++;
					finalDist = dist;
					if(hm.containsKey(dist)) {
						list = hm.get(dist);
					}else {
						hm.remove(dist-1);
					}
					list.add(i);
					hm.put(dist, list);
					q.add(i*multi + dist);
				}
			}
			
			if(cntVisit >= roomCnt) {
				break;
			}
		}
		
		list = hm.get(finalDist);
		int min = Integer.MAX_VALUE;
		for(int i:list) {
			if(min > i)	min=i;
			cntSol++;
		}
		System.out.println(min +" "+ finalDist +" "+ cntSol);
		
	}

}
