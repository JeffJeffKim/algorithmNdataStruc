package proEdu.day5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class MotherInRaw {
	static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int nCount, map[][], move[][], startX, startY, end;
	
	public static void main(String[] args) throws IOException {
		getInput();
		int result = 0;
		Queue<Node> q= new PriorityQueue<Node>(Comparator.comparing(n -> n.cost));
		int cost = map[startY][startX];
		move[startY][startX] = map[startY][startX];
		int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
		int xx = 0, yy = 0;
		for(int i=0; i<dir.length; i++) {
			xx = startX+dir[i][1];
			yy = startY+dir[i][0];
			if(xx < 0 || yy < 0 || xx >= nCount || yy >= nCount)
				continue;
			if(map[yy][xx] == -1)
				continue;
			q.add(new Node(yy, xx, cost+map[yy][xx]));
		}
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int cx = cur.x;	int cy = cur.y;  int cCost = cur.cost;
			if(move[cy][cx] <= cCost)
				continue;
			move[cy][cx] = cCost;
			if(result < cCost)
				result = cCost;
			
			for(int i=0; i<dir.length; i++) {
				xx = cx+dir[i][1];
				yy = cy+dir[i][0];
				if(xx < 0 || yy < 0 || xx >= nCount || yy >= nCount)
					continue;
				if(map[yy][xx] == -1)
					continue;
				q.add(new Node(yy, xx, cCost+map[yy][xx]));
			}
		}
		bw.write(result+"");
		br.close();
		bw.close();
	}

	static void getInput() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		startY = Integer.parseInt(st.nextToken());
		startX = Integer.parseInt(st.nextToken());
		
		nCount = Integer.parseInt(br.readLine());
		
		map = new int[nCount][nCount];
		move = new int[nCount][nCount];
		
		for(int i=0; i<move.length; i++)
			for(int j=0; j<move[i].length; j++)
				move[i][j] = Integer.MAX_VALUE;
		
		for(int i=0; i<nCount; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<nCount; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	static class Node {
		int y;
		int x;
		int cost;
		public Node(int y, int x, int cost) {
			super();
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
	}
}


