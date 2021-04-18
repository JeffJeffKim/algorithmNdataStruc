package proEdu.day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class FindFriend {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int dist = 0, cLoc[] = new int[2], fLoc[] = new int[2];
	static boolean map[][];
	
	public static void main(String[] args) throws IOException {
		drawMap();
		getLoc();
		bfs(0, 0, cLoc[0], cLoc[1]);
		bfs(cLoc[0], cLoc[1], fLoc[0], fLoc[1]);
		bw.write(dist+"");
		br.close();
		bw.close();
	}
	
	static void bfs(int sy, int sx,int ty,int tx) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {sy, sx});
		int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
		int[][] distMap = new int[3][5];
		int result = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[1], y = cur[0];
			for(int i=0; i<dir.length; i++) {
				int xx = x+dir[i][1], yy = y+dir[i][0];
				if(xx < 0 || xx >=5 || yy < 0 | yy>=3)
					continue;
				if(!map[yy][xx])
					continue;
				if(distMap[yy][xx] != 0)
					continue;
				distMap[yy][xx] = distMap[y][x]+1;
				result = distMap[yy][xx];
				q.add(new int[] {yy,xx});
				if(yy == ty && xx == tx) {
					q.clear();
					break;
				}
			}
		}
		dist += result;
	}
	
	static void getLoc() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		cLoc[0] = Integer.parseInt(st.nextToken());
		cLoc[1] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		fLoc[0] = Integer.parseInt(st.nextToken());
		fLoc[1] = Integer.parseInt(st.nextToken());
	}
	
	static void drawMap() {
		map = new boolean[][]{
				{true, true, true, true, false},	
				{false, true, false, true, true},	
				{true, true, true, true, false},	
		};
	}

}
