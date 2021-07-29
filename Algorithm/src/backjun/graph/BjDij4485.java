package backjun.graph;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BjDij4485 {
	static int N=-1, map[][], cost[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noP = 0;
		while(N != 0){
			N = sc.nextInt();
			map = new int[N][N];	cost = new int[N][N];
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					map[i][j] = sc.nextInt();
					cost[i][j] = Integer.MAX_VALUE;
				}
			}
//			cost[0][0] = 0;
			cost[0][0] = map[0][0];
			dij();
			System.out.println("Problem "+ ++noP + ": " + cost[N-1][N-1]);
		}
	}
	
	private static void dij() {
		PriorityQueue<Info> q = new PriorityQueue<Info>(new Comparator<Info>() {
			@Override
			public int compare(Info o1, Info o2) {
				return o1.accDist - o1.accDist;
			}
		});
		Info start = new Info(cost[0][0],0,0);
		q.add(start);
		int dx[] = {0,0,-1,1}, dy[] = {-1,1,0,0};
		while(!q.isEmpty()){
			Info cur = q.poll();
			for(int i=0; i<dx.length; i++){
				int xx = cur.x + dx[i], yy = cur.y + dy[i];
				if(xx < 0 || yy < 0 || xx > N-1 || yy > N-1)	continue;
				if(cost[yy][xx] <= cost[cur.y][cur.x] + map[yy][xx])	continue;
				cost[yy][xx] = cost[cur.y][cur.x] + map[yy][xx];
				q.add(new Info(xx, yy, cost[yy][xx]));
			}
		}
	}
	
	static class Info{
		int x,y,accDist;

		public Info(int x, int y, int accDist) {
			this.x = x;
			this.y = y;
			this.accDist = accDist;
		}
		
	}
}
