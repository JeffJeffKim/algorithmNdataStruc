package pro;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class DeliveryMan {
	
	static int x, y, count, map[][], hist[][];
	static int dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, -1, 1 };
	static int locX, locY;
	static Map<Integer, HashMap<Integer,  HashMap<Integer, Integer>>> dist;
	final static int mul = 101;

	public static void main(String[] args) {
		int result = 0;
		getIn();
		dist = new HashMap<Integer, HashMap<Integer,  HashMap<Integer, Integer>>>();
		for(int i=1; i<count; i++){
			int val = getDist(i);
			if(val == Integer.MAX_VALUE){
				result = 0;
				break;
			}else {
				result += val;
			}
		}
		System.out.println(result+"ȸ");
		
	}
	
	static int getDist(int nt) {
		Queue<NextWay> q = new PriorityQueue<NextWay>(1, new Comparator<NextWay>() {
			@Override
			public int compare(NextWay a0, NextWay a1) {
				return a0.dist - a1.dist;
			}
		});
		int result = Integer.MAX_VALUE;
		boolean[][] visited = new boolean[x][y]; 
		visited[locX][locY] = true;
		int start = nt;
		int key = 0;
		for(int i=0; i<4; i++) {
			if(locX+dx[i] < 0 || locY+dy[i] < 0 || locX+dx[i] > x-1 || locY+dy[i] > y-1)
				continue;
			if(map[locX+dx[i]][locY+dy[i]] == -1)
				continue;
			if(visited[locX+dx[i]][locY+dy[i]])
				continue;
			q.add(new NextWay(locX+dx[i], locY+dy[i], 1, visited, start));
			if(nt > 0) {
				key = locX*mul + locY;
				if(!dist.containsKey(key)) {
					HashMap<Integer,  HashMap<Integer, Integer>> subDist = dist.get(key);
					subDist.put(nt, new HashMap<Integer, Integer>());
					dist.put(key, new  HashMap<Integer,  HashMap<Integer, Integer>>());
				}
			}
		}
		
		while(!q.isEmpty()){
			NextWay next = q.poll();
			int nX = next.x, nY = next.y, dist=next.dist, loc = map[nX][nY];
 			visited = next.visited;
			visited[nX][nY] = true;
			
			if(loc == nt) {
				result = dist;
				locX = nX;
				locY = nY;
				break;
			}
			
			if(loc > 1) {
				
			}
			
			for(int i=0; i<4; i++) {
				int nxx = nX + dx[i], nyy = nY + dy[i];
				if(nxx < 0 || nyy < 0 || nxx > x-1 || nyy > y-1)
					continue;
				if(map[nxx][nyy] == -1)
					continue;
				if(visited[nxx][nyy])
					continue;
				q.add(new NextWay(nxx, nyy, dist+1, visited, start));
			}
		}
		return result;
	}

	static void getIn() {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		count = sc.nextInt();
		map = new int[x][y];
		sc.nextLine();
		for (int i = 0; i < x; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < y; j++) {
				if (str.charAt(j) == '#') {
					map[i][j] = -1;
				} else {
					map[i][j] = Integer.parseInt(str.substring(j, j + 1));
				}
			}
		}
		sc.close();
	}
	
	static class NextWay {
		public int x;
		public int y;
		public int dist;
		public boolean[][] visited;
		private int start;
		public NextWay(int x, int y, int dist, boolean[][] visited, int start) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.visited = visited;
			this.start = start;
		}
	}
}

/*
5 7 4
0000000
0300020
0##4##0
0010240
0000000

15
*/




//public static void main(String[] args) {
//	int result = 0;
//	getIn();
//	for(int i=1; i<=count; i++){
//		int val = getDist(i);
//		if(val == Integer.MAX_VALUE){
//			result = 0;
//			break;
//		}else {
//			result += val;
//		}
//	}
//	System.out.println(result+"ȸ");
//	
//}
//
//static int getDist(int nt) {
//	Queue<NextWay> q = new PriorityQueue<NextWay>(1, new Comparator<NextWay>() {
//		@Override
//		public int compare(NextWay a0, NextWay a1) {
//			return a0.dist - a1.dist;
//		}
//	});
//	int result = Integer.MAX_VALUE;
//	boolean[][] visited = new boolean[x][y]; 
//	visited[locX][locY] = true;
//	int start = nt;
//	hist[nt-1][0] = 1;
//	for(int i=0; i<4; i++) {
//		if(locX+dx[i] < 0 || locY+dy[i] < 0 || locX+dx[i] > x-1 || locY+dy[i] > y-1)
//			continue;
//		if(map[locX+dx[i]][locY+dy[i]] == -1)
//			continue;
//		if(visited[locX+dx[i]][locY+dy[i]])
//			continue;
//		q.add(new NextWay(locX+dx[i], locY+dy[i], 1, visited, start));
//	}
//	
//	while(!q.isEmpty()){
//		NextWay next = q.poll();
//		int nX = next.x, nY = next.y, dist=next.dist, loc = map[nX][nY];
//			visited = next.visited;
//		visited[nX][nY] = true;
//		
//		if(loc == nt) {
//			result = dist;
//			locX = nX;
//			locY = nY;
//			break;
//		}
//		
//		for(int i=0; i<4; i++) {
//			int nxx = nX + dx[i], nyy = nY + dy[i];
//			if(nxx < 0 || nyy < 0 || nxx > x-1 || nyy > y-1)
//				continue;
//			if(map[nxx][nyy] == -1)
//				continue;
//			if(visited[nxx][nyy])
//				continue;
//			q.add(new NextWay(nxx, nyy, dist+1, visited, start));
//		}
//	}
//	return result;
//}
//
//static void getIn() {
//	Scanner sc = new Scanner(System.in);
//	x = sc.nextInt();
//	y = sc.nextInt();
//	count = sc.nextInt();
//	map = new int[x][y];
//	sc.nextLine();
//	for (int i = 0; i < x; i++) {
//		String str = sc.nextLine();
//		for (int j = 0; j < y; j++) {
//			if (str.charAt(j) == '#') {
//				map[i][j] = -1;
//			} else {
//				map[i][j] = Integer.parseInt(str.substring(j, j + 1));
//			}
//		}
//	}
//	sc.close();
//}