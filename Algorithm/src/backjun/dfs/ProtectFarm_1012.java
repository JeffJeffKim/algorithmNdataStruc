// https://www.acmicpc.net/problem/1012
package backjun.dfs;

import java.util.Scanner;

public class ProtectFarm_1012 {
	
	static boolean visit[][], map[][];
	static int T, X, Y, K, result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int i=0; i<T; i++) {
			getInput(sc);
			search();
			System.out.println(result);
		}
		sc.close();
	}
	
	static void search() {
		for(int  y=0; y<Y; y++) {
			for(int x=0; x<X; x++) {
				if(map[y][x] && !visit[y][x]) {
					dfs(x, y);
					result++;
				}
			}
		}
	}
	
	static void dfs(int x, int y) {
		int movX[] = {0,0,-1,1}, movY[] = {-1,1,0,0};
		visit[y][x] = true;
		for(int i=0; i<4; i++) {
			int xx = x+movX[i], yy = y+movY[i];
			if(xx < 0 || xx >= X || yy < 0 || yy >= Y)	continue;
			if(map[yy][xx] && !visit[yy][xx])
				dfs(xx, yy);
		}
		
	}
	
	static void getInput(Scanner sc) {
		result = 0;
		X = sc.nextInt();
		Y = sc.nextInt();
		K = sc.nextInt();
		visit = new boolean[Y][X];
		map = new boolean[Y][X];
		for(int j=0; j<K; j++) {
			int xx = sc.nextInt();
			int yy = sc.nextInt();
			map[yy][xx] = true;
		}
	}

}
