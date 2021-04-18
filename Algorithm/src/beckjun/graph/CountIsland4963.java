package beckjun.graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class CountIsland4963 {
	
	static int multi = 10000, map[][], sol;
	static boolean visit[][];
	static int moveX[]= {-1,-1,-1, 1, 1, 1, 0, 0};
	static int moveY[]= { 0, 1,-1, 0,-1, 1, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int col, row;
		while(sc.hasNextInt()) {
			col = sc.nextInt(); row = sc.nextInt();
			if(col==0 && row==0)	break;
			map = new int[row+2][col+2];	visit = new boolean[row+2][col+2];
			for(int i=1; i<row+1; i++) 
				for(int j=1; j<col+1; j++) 
					map[i][j] = sc.nextInt();
			for(int i=0; i<col+2; i++) {
				visit[0][i] = true;	visit[row+1][i]	= true;
			}
			for(int i=0; i<row+2; i++) {
				visit[i][0] = true; visit[i][col+1] = true; 
			}
			
			cntIs();
			System.out.println(sol);
			sol=0;
		}
		sc.close();
	}
	
	static void cntIs() {
		int loc=searchLand();
		if(loc == 0) 	return;
		int col=0, row=0;
		Queue<Integer> q = new ArrayDeque<>();
		q.add(loc);
		while(!q.isEmpty()) {
			loc = q.poll();
			col=loc/multi;	row=loc%multi;	visit[row][col] = true;
			for(int i=0; i<moveX.length; i++) {
				if(!visit[row+moveY[i]][col+moveX[i]] && map[row+moveY[i]][col+moveX[i]] ==1) {
					visit[row+moveY[i]][col+moveX[i]] = true;
					loc=row+moveY[i]+ (col+moveX[i])*multi;
					q.add(loc);
				}
			}
		}
		sol++;
		cntIs();
	}
	
	static int searchLand() {
		int loc=0;
		loop: for(int i=1; i<map.length-1; i++) {
			for(int j=1; j<map[0].length-1; j++) {
				if(visit[i][j])	continue;
				if(map[i][j] == 0)	continue;
				loc = j*multi + i;
				break loop;
			}
		}
		return loc;
	}

}
