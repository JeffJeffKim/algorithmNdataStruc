// https://www.acmicpc.net/problem/1987

package backjun.dfs;

import java.util.Scanner;

public class Alphabet_MaxMove_1987 {
	
	static int X, Y, result = Integer.MAX_VALUE;
	static char[][] map;
	
	public static void main(String[] args) {
		getIn();
		travel(0, 0, 1, new boolean[26]);
		System.out.println(result);
	}
	
	static void travel(int x, int y, int cnt, boolean[] visit) {
		int movX[] = {0,0,-1,1}, movY[] = {-1,1,0,0};
		if(visit[map[y][x]-65]) {
			if(result > cnt)	result = cnt;
			return;
		}
		
		visit[map[y][x]-65] = true;
		for(int i=0; i<4; i++) {
			int xx = x+movX[i], yy = y+movY[i];
			if(xx<0 || xx>=X || yy<0 || yy>=Y)	continue;
			travel(xx, yy, ++cnt, visit);
		}
		visit[map[y][x]-65] = false;
	}
	
	static void getIn() {
		Scanner sc = new Scanner(System.in);
		Y = sc.nextInt();
		X = sc.nextInt();
		map = new char[Y][X];
		sc.nextLine();
		for(int i=0; i<Y; i++) {
			String str = sc.nextLine();
			for(int j=0; j<X; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		sc.close();
	}

}
