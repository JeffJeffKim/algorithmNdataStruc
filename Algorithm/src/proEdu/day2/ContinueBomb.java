package proEdu.day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class ContinueBomb {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int size = Integer.parseInt(br.readLine());
		int[][] map = new int[size][size];
		boolean[][] bombMap = new boolean[size][size];
		Queue<BombInfo> pq = new PriorityQueue<BombInfo>(
				Comparator.comparing(bi -> bi.order));
		for(int i=0; i<size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<size; j++) {
				int curN = Integer.parseInt(st.nextToken());
				pq.add(new BombInfo(curN, i, j));
			}
		}
		
		int last = 0;
		int[] dx = {0,0,-1,1}, dy = {-1,1,0,0};
		while(!pq.isEmpty()) {
			BombInfo cur = pq.poll();
			if(bombMap[cur.x][cur.y])
				continue;
			last = cur.order;
			bombMap[cur.x][cur.y] = true;
			for(int i=0; i<4; i++) {
				int xx = cur.x + dx[i];
				int yy = cur.y + dy[i];
				if(xx < 0 || yy < 0 || xx > size-1 || yy > size-1)
					continue;
				bombMap[xx][yy] = true;
			}
		}
		bw.write(last+"");
		
		br.close();
		bw.close();
	}

}

class BombInfo {
	public int order;
	public int x;
	public int y;
	public BombInfo(int order, int x, int y) {
		super();
		this.order = order;
		this.x = x;
		this.y = y;
	}
	
}
