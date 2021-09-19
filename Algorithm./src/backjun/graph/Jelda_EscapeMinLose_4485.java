// https://www.acmicpc.net/problem/4485

package backjun.graph;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Jelda_EscapeMinLose_4485 {
	
	static class Info {
		int x, y, cost;
		Info (int x, int y, int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int gameCnt = 0;
		
		while(true) {
			int N = sc.nextInt();
			if(N == 0)	break;
			
			int map[][] = new int[N][N];
			int dist[][] = new int[N][N];
			
			for(int i=0; i<N; i++)
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					dist[i][j] = Integer.MAX_VALUE;
				}
			
			int dx[]= {0,0,-1,1}, dy[]= {-1,1,0,0}, xx, yy;
			Queue<Info> q = new PriorityQueue<Info>(Comparator.comparing(i -> i.cost));
			
			dist[0][0] = map[0][0];
			q.add(new Info(0, 0, map[0][0]));
			
			while(!q.isEmpty()) {
				Info info = q.poll();
				for(int i=0; i<4; i++) {
					xx = info.x + dx[i];	yy = info.y+dy[i];
					if(xx<0 || yy<0 || xx>N-1 || yy>N-1)	continue;
					if(dist[yy][xx] <= info.cost + map[yy][xx])	continue;
					
					dist[yy][xx] = info.cost + map[yy][xx];
					q.add(new Info(xx, yy, info.cost+map[yy][xx]));
				}
			}
			
			System.out.println("Problem "+ ++gameCnt +": "+dist[N-1][N-1]);
		}
		sc.close();
		
	}

}
