package proEdu.day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class ZombiVirus {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int x, y, zomCount=0, map[][];
	public static void main(String[] args) throws IOException {
		init();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken())-1;
		int b = Integer.parseInt(st.nextToken())-1;
		map[b][a] = 3;
		
		int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {b, a}); // y, x
		zomCount--;
		int day = 3;
		
		while(!q.isEmpty()) {
			int[] loc = q.poll(); //y,x
			for(int i=0; i<dir.length; i++) {
				int xx = loc[1]+dir[i][1], yy = loc[0]+dir[i][0];
				if(xx<0 || yy<0 || xx>=x || yy>=y)
					continue;
				if(map[yy][xx] == 0)
					continue;
				if(map[yy][xx] != 1)// && map[yy][xx] <= map[loc[0]][loc[1]])
					continue;
				map[yy][xx] = map[loc[0]][loc[1]]+1;
				day = map[yy][xx];
				q.add(new int[] {yy, xx});
				zomCount--;
			}
		}
		bw.write(day+"\n"+zomCount);
		
		br.close();
		bw.close();
	}
	
	static void init() throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		map = new int[y][x];
		for(int i=0; i<y; i++) {
			String str = br.readLine();
			for(int j=0; j<x; j++) {
//				System.out.println(str.substring(j, j+1));
				int num = Integer.valueOf(str.substring(j, j+1));
				if(num == 1) {
					zomCount++;
					map[i][j] = 1;
				}
			}
		}
	}

}
