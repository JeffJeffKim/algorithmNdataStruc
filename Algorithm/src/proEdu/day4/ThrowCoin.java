package proEdu.day4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class ThrowCoin {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int map[][], dat[], result = 0, x, y;
	static boolean[][] isVisit;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		map = new int[y][x];
		for(int h=0; h<y; h++) {
			String line = br.readLine();
			for(int w=0; w<x; w++) {
				if(line.charAt(w) == '0')
					map[h][w] = 2;
				else
					map[h][w] = 1;
			}
		}
		dat = new int[x*y*2 + 100];
		
		search();
		// bfs
		// dat
		
		int inCnt = Integer.parseInt(br.readLine());
		int type = 0;
		
		for(int i=0; i<inCnt; i++) {
			st = new StringTokenizer(br.readLine());
			type = Integer.parseInt(st.nextToken());
			if(type == 1) {
				int h = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				type1(h, w);
			}
			else {
				int idx = Integer.parseInt(st.nextToken());
				type2(idx);
			}
		}
		bw.write(result+"");
		br.close();
		bw.close();
	}
	
	static void search() {
		isVisit = new boolean[y][x];
		int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
		for(int h=0; h<y; h++) {
			for(int w=0; w<x; w++) {
				if(isVisit[h][w])
					continue;
				bfs(w, h, isVisit, map[h][w], true);
			}
		}
	}
	
	static int bfs(int w, int h, boolean[][] isVisit, int value, boolean isDefault) {
		int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {h, w});
		int total = value;
		isVisit[h][w] = true;
		while(!q.isEmpty()) {
			int[] loc = q.poll();
			h = loc[0];
			w = loc[1];
			for(int t=0; t<dir.length; t++) {
				int yy = h+dir[t][0];
				int xx = w+dir[t][1];
				if(yy<0 || xx<0 || yy>=y || xx>=x)
					continue;
				if(isVisit[yy][xx])
					continue;
				if(value != map[yy][xx])
					continue;
				isVisit[yy][xx] = true;
				total += value;
				q.add(new int[]{yy, xx});
			}
		}
		if(isDefault)
			dat[total]++;
		else
			dat[total]--;
		return total;
	}
	
	static void type1 (int h, int w) {
		int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
		int value = 2;
		int prevSum = 2;
		isVisit = new boolean[y][x];
//		boolean twoExist = false;
		for(int t=0; t<dir.length; t++) {
			map[h][w] = 1;
			int yy = h+dir[t][0];
			int xx = w+dir[t][1];
			if(yy<0 || xx<0 || yy>=y || xx>=x)
				continue;
			if(isVisit[yy][xx])
				continue;
			if(value != map[yy][xx]) {
				bfs(xx, yy, isVisit, 1, false);
				map[h][w] = 2;
				isVisit = new boolean[y][x];
				bfs(xx, yy, isVisit, 1, true);
//				dat[num]++;
			}else {
				map[h][w] = 2;
				prevSum += bfs(xx, yy, isVisit, value, false);
			}
//			twoExist = true;
		}
//		if(!twoExist) {
//			int num = bfs(w, h, isVisit, 1, false)-1;
//			dat[num]++;
//		}
		map[h][w] = 2;
		dat[prevSum]++;
	}
	
	static void type2 (int idx) {
		result += dat[idx];
	}

}
