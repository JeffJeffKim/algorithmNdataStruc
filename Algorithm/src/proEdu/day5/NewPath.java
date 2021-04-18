package proEdu.day5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class NewPath {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int map[][], nodeCnt, pathCnt;
	static long move[];
	
	public static void main(String[] args) throws IOException {
		int tc = Integer.parseInt(br.readLine());
		for(int i=1; i<=tc; i++) {
			getIn();
			int result = 0;
//			boolean[] isVisit = new boolean[nodeCnt];
//			for(int j=0; j<isVisit.length; j++)
//				isVisit[i] = false;
			Queue<Node> q = new PriorityQueue<Node>(Comparator.comparing(n -> n.cost));
			q.add(new Node(0, 0));
			
			loop: while(!q.isEmpty()) {
				Node cur = q.poll();
				long cost = cur.cost;
				int x = cur.x;
				boolean isBuilt = cur.isUse;

				if(move[x] <= cost)
					continue;
				if(!isBuilt) {
					move[x] = cost;
//					isVisit[x] = true;
				}

				if(x+1 == nodeCnt) {
					if(isBuilt)
						result++;
					else
						break loop;
				}
				
				for(int t=0; t<map[x].length; t++) {
					if(t == x)
						continue;
//					if(isVisit[t])
//						continue;
					if(isBuilt) {
						q.add(new Node(t, cost+map[x][t], true));
					} else {
						q.add(new Node(t, cost+map[x][t]));
						if(map[x][t] != 1 && x != 0 && t != nodeCnt-1)
							q.add(new Node(t, cost+1, true));
					}
				}
			}
			
			bw.write("#"+i+" "+result+"\n");
		}
				
		br.close();
		bw.close();
	}
	
	static void getIn() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		nodeCnt = Integer.parseInt(st.nextToken());
		pathCnt = Integer.parseInt(st.nextToken());
		map = new int[nodeCnt][nodeCnt];
		move = new long[nodeCnt];
		for(int i=0; i<nodeCnt; i++) {
			move[i] = 10_000L;
			for(int j=0; j<nodeCnt; j++) 
				map[i][j] = 10_000;
		}
		
		for(int i =0; i<pathCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			map[s][e] = cost;
//			map[e][s] = cost;
		}
	}

	static class Node {
		public int x;
		public long cost;
		public boolean isUse;
		public Node(int x, long cost) {
			this.x = x;
			this.cost = cost;
		}
		public Node( int x, long cost, boolean isUse) {
			this.x = x;
			this.cost = cost;
			this.isUse = isUse;
		}
	}
}

