package proEdu.day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bloom {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] map;
	static int day, count, targetCount, x, y;
	static Queue<int[]> seed = new ArrayDeque<int[]>();
	public static void main(String[] args) throws IOException {
		init();
		int result = 0;
		int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
		if(x == 1 && y == 1) {
			result = 1;
		}else {
			while(!seed.isEmpty()) {
				int[] next = seed.poll();
				for(int i=0; i<dir.length; i++) {
					int yy = next[0]+dir[i][0], xx = next[1]+dir[i][1];
					if(xx<0 || yy<0 || xx>=x || yy>=y)
						continue;
					if(map[yy][xx] > 0)
						continue;
					map[yy][xx] = map[next[0]][next[1]]+1;
					seed.add(new int[]{yy, xx});
					result = map[yy][xx];
				}
			}
		}
		bw.write(result+"");
		br.close();
		bw.close();
	}
	
	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		map = new int[y][x];
		targetCount = x*y;

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		map[a][b] = 1;
		seed.add(new int[] {a,b});
		targetCount++;
		
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		map[a][b] = 1;
		seed.add(new int[] {a,b});
		targetCount++;
	}
}
