package backjun.graph;

import java.util.*;

public class BjDij1261 {
	
	static class Info {
		int x, y, value;
		public Info(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
	
	static int N, M, map[][], cost[][];
	static Queue<Info> q = new PriorityQueue<>(new Comparator<Info>() {
		@Override
		public int compare(Info o1, Info o2) {
			return o2.value - o1.value;
		}
	});
	
	public static void main(String[] args) {
		getIn();
		dij();
		System.out.println(cost[M-1][N-1]);
	}
	
	private static void dij(){
		q.add(new Info(0,0,map[0][0]));
		cost[0][0] = map[0][0];
		int dx[] = {0,0,-1,1}, dy[] = {-1,1,0,0};
		while(!q.isEmpty()){
			Info cur = q.poll();
			for(int i=0; i<dx.length; i++){
				int xx = cur.x+dx[i], yy = cur.y+dy[i];
				if(xx < 0 || yy < 0 ||  xx > N-1 || yy > M-1)	continue;
				if(cost[yy][xx] > cost[cur.y][cur.x] + map[yy][xx]){
					cost[yy][xx] = cost[cur.y][cur.x] + map[yy][xx];
					q.add(new Info(xx, yy, map[yy][xx]));
				}
			}
		}
	}
	
	private static void getIn() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[M][N];
		cost = new int[M][N];
		sc.nextLine();
		for(int i=0; i<M; i++){
			String str = sc.nextLine();
			for(int j=0; j<N; j++){
				map[i][j] = Integer.parseInt(str.substring(j, j+1));
				cost[i][j] = Integer.MAX_VALUE;
			}
		}
		sc.close();
	}

}
