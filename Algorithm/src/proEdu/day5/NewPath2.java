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

public class NewPath2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int map[][], nodeCnt, pathCnt;
	static int move[];
	
	public static void main(String[] args) throws IOException {
		int tc = Integer.parseInt(br.readLine());
		for(int i=1; i<=tc; i++) {
			getIn();
			int result = 0;
			
			int minDist= bfs(0, nodeCnt-1);
			

			int sNextArr[] = new int[nodeCnt];
			int eNextArr[] = new int[nodeCnt];
			for(int s=1; s<=nodeCnt-2; s++) 
				sNextArr[s] = bfs(0, s);
			for(int s=1; s<=nodeCnt-2; s++) 
				eNextArr[s] = bfs(s, nodeCnt-1);
			

			int minSarr = Integer.MAX_VALUE;
			for(int s=1; s<=nodeCnt-2; s++) 
				if(minSarr > sNextArr[s])
					minSarr = sNextArr[s];
			
			int minEarr = Integer.MAX_VALUE;
			for(int s=1; s<=nodeCnt-2; s++) 
				if(minEarr > eNextArr[s])
					minEarr = eNextArr[s];
			
			
			int sLimit = minDist- minEarr - 1;
			int eLimit = minDist- minSarr - 1;
			Arrays.sort(sNextArr);
			Arrays.sort(eNextArr);
			for(int s=2; s<=nodeCnt; s++) {
				if(sNextArr[s] >= sLimit)
					break;
				for(int e=2; e<=nodeCnt; e++) {
					if(eNextArr[e] >= eLimit)
						break;
					if(sNextArr[s] + eNextArr[e] + 1 < minDist)
						result++;
				}
			}
			
			bw.write("#"+i+" "+result+"\n");
		}
				
		br.close();
		bw.close();
	}
	
	static int bfs(int s, int e) {
		Queue<Node> q = new PriorityQueue<Node>(Comparator.comparing(n -> n.cost));
		q.add(new Node(s, 0));
		int arrMin[] = new int[nodeCnt];
		Arrays.fill(arrMin, Integer.MAX_VALUE);
		boolean[] isVisit = new boolean[nodeCnt];

		while(!q.isEmpty()) {
			Node cur = q.poll();
			int cost = cur.cost;
			int x = cur.x;
			
			if(arrMin[x] <= cost)
				continue;
			arrMin[x] = cost;
			isVisit[x] = true;
			if(x == e)
				return cost;
			
			for(int t=0; t<map[x].length; t++) {
				if(t == x)
					continue;
				if(map[x][t] == 0)
					continue;
				if(isVisit[t])
					continue;
				q.add(new Node(t, cost+map[x][t]));
			}
		}
		return -1;
	}
	
	
	static void getIn() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		nodeCnt = Integer.parseInt(st.nextToken());
		pathCnt = Integer.parseInt(st.nextToken());
		map = new int[nodeCnt][nodeCnt];
		move = new int[nodeCnt];
		
		for(int i =0; i<pathCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			map[s][e] = cost;
			map[e][s] = cost;
		}
	}

	static class Node {
		public int x;
		public int cost;
		public Node(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}
	}
}

