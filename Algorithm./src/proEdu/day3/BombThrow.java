package proEdu.day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BombThrow {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static char[][] map = new char[4][5];
	public static void main(String[] args) throws IOException {
//		Arrays.fill(map, '_');
		for(int y=0; y<4; y++) {
			for(int x=0; x<5; x++) {
				map[y][x] = '_';
			}
		}
		run();
		run();
		for(int y=0; y<4; y++) {
			for(int x=0; x<5; x++) {
				bw.write(map[y][x]+" ");
			}
			bw.write("\n");
		}
		br.close();
		bw.close();
	}

	static void run() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[][] dir = {
				{-1,-1},
				{-1,0},
				{-1,1},
				{1,-1},
				{1,1},
				{1,0},
				{0,1},
				{0,-1},
		};
		
		for(int i=0; i<dir.length; i++) {
			int xx = x+dir[i][1];
			int yy = y+dir[i][0];
			if(xx<0 || yy<0 || xx>4 || yy>3)
				continue;
			map[yy][xx] = '#';
		}
	}
}
