package beckjun.graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class BjBfs7569 {
	
	static int M, N, H, box[][][], result=-1;
	static Queue<ArrayList<Loc>> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws FileNotFoundException {
		getIn();
		boolean isPrint = false;
		if(!q.isEmpty()){
			result++;
			bfs();
		}else{
			if(chkAllZero()){
				isPrint = true;
				System.out.println(0);
			}
		}
		if(!isPrint){
			if(chkOneZero())
				System.out.println(-1);
			else
				System.out.println(result);
		}
	}
	
	private static boolean chkOneZero(){
		boolean result = true;
		for(int i=0; i<H; i++){
			for(int j=0; j<N; j++){
				for(int k=0; k<M; k++){
					if(box[i][j][k] == 0){
						return result;
					}
				}
			}
		}
		return false;
	}
	
	private static boolean chkAllZero(){
		boolean result = false;
		for(int i=0; i<H; i++){
			for(int j=0; j<N; j++){
				for(int k=0; k<M; k++){
					if(box[i][j][k] != 0){
						return result;
					}
				}
			}
		}
		return true;
	}
	
	private static void bfs(){
		int dx[] = {0,0,0,0,-1,1}, dy[] = {0,0,-1,1,0,0}, dz[] = {-1,1,0,0,0,0};
		while(!q.isEmpty()){
			ArrayList<Loc> arr = q.poll();
			ArrayList<Loc> next = new ArrayList<>();
			for(Loc loc : arr){
				int x = loc.x, y = loc.y, z = loc.z;
				for(int i=0; i<dx.length; i++){
					int xx = x+dx[i], yy = y+dy[i], zz = z+dz[i];
					if(xx < 0 || xx >= M || yy < 0 || yy >= N || zz < 0 || zz >= H)
						continue;
					if(box[zz][yy][xx] == 0){
						box[zz][yy][xx] = 1;
 						next.add(new Loc(xx, yy, zz));
					}
				}
			}
			if(next.size() > 0){
				result++;
				q.add(next);
			}
		}
	}
	
	private static void getIn() throws FileNotFoundException{
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
//		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();	N = sc.nextInt(); H = sc.nextInt();
		box = new int[H][N][M];
		ArrayList<Loc> arr = new ArrayList<>();
		for(int i=0; i<H; i++){
			for(int j=0; j<N; j++){
				for(int k=0; k<M; k++){
					box[i][j][k] = sc.nextInt();
					if(box[i][j][k] == 1){
						arr.add(new Loc(k,j,i));
					}
				}
			}
		}
		q.add(arr);
	}
	
	private static class Loc{
		public int x, y, z;

		public Loc(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
	}

}
