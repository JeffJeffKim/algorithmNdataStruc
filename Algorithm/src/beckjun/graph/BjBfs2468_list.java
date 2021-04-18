package beckjun.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

//memory over
public class BjBfs2468_list {
	
	static byte N, movX[] = {0, 0, -1, 1}, movY[] = {-1, 1, 0, 0}, min = 100, max = 1, result, level;
	static ArrayList<ArrayList<Byte>> inMap = new ArrayList<>();
	static ArrayList<ArrayList<Boolean>> visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		getIn(sc);
//		checkInMap();
		for(level=min; level<max; level++){
			getAreaCount();
		}
		System.out.println(result);
	}
	
	private static void getAreaCount(){
		byte curResult = 0;
		initVisit();
		for(int i=1; i<N+1; i++){
			for(int j=1; j<N+1; j++){
				if(inMap.get(i).get(j) > level && !visit.get(i).get(j)){
					bfs(i, j);
					curResult++;
				}
			}
		}
		if(curResult > result)	result = curResult;
	}
	
	private static void bfs(int row, int col){
		Queue<Integer> q = new ArrayDeque<>();
		int multi = 1000, nextX = col, nextY = row;
		q.add(row * multi + col);
		while(!q.isEmpty()){
			int qNum = q.poll();
			row = qNum / multi;	col = qNum % multi;
			visit.get(row).set(col, true);
			for(int i=0; i<movX.length; i++){
				nextX = col + movX[i];
				nextY = row + movY[i];
				if(inMap.get(nextY).get(nextX) > level && !visit.get(nextY).get(nextX)){
					q.add(nextY * multi + nextX);
				}
			}
		}
	}
	
	private static void getIn(Scanner sc){
		N = sc.nextByte();
		byte  curIn = 0;
		for(int i=0; i<N+2; i++) {
			ArrayList<Byte> singleRow = new ArrayList<>();
			for(int j=0; j<N+2; j++) {
				if(i == 0 || i == N+1){
					singleRow.add((byte)0);
				}else if(j == 0 || j == N+1){
					singleRow.add((byte)0);
				}else{
					curIn = sc.nextByte();
					if(curIn > max)	max = curIn;
					if(curIn < min)	min = curIn;
					singleRow.add((byte)curIn);
				}
			}
			inMap.add(singleRow);
		}
	}
	
	private static void initVisit(){
		visit = new ArrayList<>();
		for(int i=0; i<N+2; i++) {
			ArrayList<Boolean> singleRow = new ArrayList<>();
			for(int j=0; j<N+2; j++) {
				if(i == 0 || i == N+1){
					singleRow.add(true);
				}else if(j == 0 || j == N+1){
					singleRow.add(true);
				}else{
					singleRow.add(false);
				}
			}
			visit.add(singleRow);
		}
	}
	
	private static void checkInMap(){
		for(ArrayList<Byte> list : inMap){
			for(int i: list){
				System.out.print(i + " ");
			}
			System.out.println();
		}
		System.out.println("min: "+min);
		System.out.println("max: "+max);
	}

}
