package beckjun.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BjDij6118_1 {
	static int roomCnt, map[][];
	static boolean visit[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		roomCnt = sc.nextInt();	int inCnt = sc.nextInt();
		map = new int[roomCnt+1][roomCnt+2];	//[roomNo][pathCnt, pathNo1, 2,...]
		visit = new boolean[roomCnt+1];
		int inX, inY;	visit[0] = true;
		for(int i=0; i<inCnt; i++) {
			inX = sc.nextInt(); inY = sc.nextInt();
			map[inX][0]++;
			map[inX][map[inX][0]] = inY;
			map[inY][0]++;
			map[inY][map[inY][0]] = inX;
		}
		sc.close();
		bfs(1);
	}
	
	public static void bfs(int n) {
		int dist=0, cntSol=0, roomNo, finalDist=0,  multi=60000, cntVisit=1, pathCnt=0;
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
		ArrayList<Integer> list;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		visit[n]=true;
		q.add(n*multi + dist);
		while(!q.isEmpty()) {
			n = q.poll();
			roomNo = n/multi; dist = n%multi +1;
			list = new ArrayList<>();
			pathCnt = map[roomNo][0];
			for(int i=1; i<pathCnt+1; i++) {
				if(visit[map[roomNo][i]])	continue;
				visit[map[roomNo][i]] = true;
				cntVisit++;
				finalDist = dist;
				if(hm.containsKey(dist)) {
					list = hm.get(dist);
				}else {
					hm.remove(dist-1);
				}
				list.add(map[roomNo][i]);
				hm.put(dist, list);
				q.add(map[roomNo][i]*multi + dist);
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
