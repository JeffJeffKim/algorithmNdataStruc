package beckjun.graph;

import java.util.*;

public class BjBfs2583 {
	
	static class Info {
		int x,y;
		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int cntX, cntY, cntZone;
	static boolean visit[][], map[][];
	static ArrayList<Integer> area = new ArrayList<>();
	
	public static void main(String[] args) {
		getIn();
		bfs();
		Collections.sort(area);
		System.out.println(cntZone);
		for(int i : area){
			System.out.print(i + " ");
		}
	}
	
	private static void bfs(){
		int loc[] = getStartPoint(0, 0);//{y,x}
		if(loc[0]*loc[1] == 40000){
			return;
		}
		
		Queue<Info> q = new ArrayDeque<>();
		q.add(new Info(loc[1], loc[0]));
		int dx[] = {0,0,-1,1}, dy[] = {-1,1,0,0};
		int curZoneArea = 1;
		visit[loc[0]][loc[1]] = true;
		while(!q.isEmpty()){
			Info cur = q.poll();
			for(int i=0; i<dx.length; i++){
				int xx = cur.x + dx[i];
				int yy = cur.y + dy[i];
				if(xx<0 || xx>=cntX || yy<0 || yy>=cntY)	continue;
				if(visit[yy][xx])	continue;
				visit[yy][xx] = true;
				q.add(new Info(xx, yy));
				curZoneArea++;
			}
		}
		area.add(curZoneArea);
		cntZone++;
		bfs();
	}
	
	private static int[] getStartPoint(int x, int y){
		int result[] = new int[2];	// {y, x}
		result[0] = -200;
		result[1] = -200;
		for(int i=y; i<cntY; i++) {
			for(int j=x; j<cntX; j++) {
				if(!visit[i][j]){
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}
	
	private static void getIn() {
		Scanner sc = new Scanner(System.in);
		cntY = sc.nextInt();
		cntX = sc.nextInt();
		map = new boolean[cntY][cntX];
		visit = new boolean[cntY][cntX];
		int cntBox = sc.nextInt();
		for(int i=0; i<cntBox; i++){
			int sX = sc.nextInt();
			int sY = sc.nextInt();
			int eX = sc.nextInt();
			int eY = sc.nextInt();
			drawMap(sX, sY, eX, eY);
		}
	}
	
	private static void drawMap(int sX, int sY, int eX, int eY) {
		for(int i=sY; i<eY; i++){
			for(int j=sX; j<eX; j++){
				map[i][j] = true;
				visit[i][j] = true;
			}
		}
	}
}
