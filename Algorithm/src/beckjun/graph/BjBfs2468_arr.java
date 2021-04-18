package beckjun.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

// memory over
public class BjBfs2468_arr {
	
	static byte N, movX[] = {0, 0, -1, 1}, movY[] = {-1, 1, 0, 0}, min = 100, max = 1, result, level, inMap[][];
	static boolean visit[][];
	
	public static void main(String[] args) {
		getIn();
		for(level=min; level<max; level++){
			getAreaCount();
		}
		System.out.println(result);
	}
	
	private static void getAreaCount(){
		byte curResult = 0;
		initVisit();
		for(byte i=1; i<N+1; i++){
			for(byte j=1; j<N+1; j++){
				if(inMap[i][j] > level && !visit[i][j]){
					bfs(i, j);
					curResult++;
				}
			}
		}
		if(curResult > result)	result = curResult;
	}
	
	private static void bfs(byte row, byte col){
		Queue<Short> q = new ArrayDeque<>();
		byte multi = 101, nextX = col, nextY = row;
		q.add((short) (row * multi + col));
		while(!q.isEmpty()){
			int qNum = q.poll();
			row = (byte) (qNum / multi);	col = (byte) (qNum % multi);
			visit[row][col] = true;
			for(byte i=0; i<movX.length; i++){
				nextX = (byte) (col + movX[i]);
				nextY = (byte) (row + movY[i]);
				if(inMap[nextY][nextX] > level && !visit[nextY][nextX]){
					q.add((short) (nextY * multi + nextX));
				}
			}
		}
		q = null;
	}
	
	private static void getIn(){
		Scanner sc = new Scanner(System.in);
		N = sc.nextByte();
		inMap = new byte[N+2][N+2];
		byte  curIn = 0;
		for(int i=0; i<N+2; i++) {
			for(int j=0; j<N+2; j++) {
				if(i == 0 || i == N+1){
					inMap[i][j] = 0;
				}else if(j == 0 || j == N+1){
					inMap[i][j] = 0;
				}else{
					curIn = sc.nextByte();
					if(curIn > max)	max = curIn;
					if(curIn < min)	min = curIn;
					inMap[i][j] = curIn;
				}
			}
		}
		sc.close();
	}
	
	private static void initVisit(){
		visit = new boolean[N+2][N+2];
		for(int i=0; i<N+2; i++) {
			for(int j=0; j<N+2; j++) {
				if(i == 0 || i == N+1){
					visit[i][j] = true;
				}else if(j == 0 || j == N+1){
					visit[i][j] = true;
				}
			}
		}
	}
	
}
