// https://www.acmicpc.net/problem/1697

package backjun.graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class HideNSee_1697 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt(), end = sc.nextInt();
		sc.close();
		int result = 0;
		boolean visit[] = new boolean[100001];
		if(start == end) {
			System.out.println(0);
			return;
		}

		// solve 1
		Queue<int[]> q1 = new ArrayDeque<int[]>();
		q1.add(new int[] {start+1, 1});
		q1.add(new int[] {start-1, 1});
		q1.add(new int[] {start*2, 1});
		while(!q1.isEmpty()) {
			int info[] = q1.poll();
			if(info[0] < 0 || info[0] > 100000)	continue;
			if(visit[info[0]])	continue;
			visit[info[0]] = true;
			if(info[0] == end) {
				result = info[1];
				break;
			}
			q1.add(new int[] {info[0]+1, info[1]+1});	
			q1.add(new int[] {info[0]-1, info[1]+1});	
			q1.add(new int[] {info[0]*2, info[1]+1});
		}
		
		// solve 2
//		Queue<Info> q = new ArrayDeque<Info>();
//		q.add(new Info(start+1, 1));	
//		q.add(new Info(start-1, 1));	
//		q.add(new Info(start*2, 1));
//		while(!q.isEmpty()) {
//			Info info = q.poll();
//			if(info.cur < 0 || info.cur > 100000)	continue;
//			if(visit[info.cur])	continue;
//			if(info.cur == end) {
//				result = info.cnt;
//				break;
//			}
//			q.add(new Info(info.cur+1, info.cnt+1));	
//			q.add(new Info(info.cur-1, info.cnt+1));	
//			q.add(new Info(info.cur*2, info.cnt+1));
//		}
		
		System.out.println(result);
	}

//	static public class Info {
//		public int cur, cnt;
//		public Info(int cur, int cnt) {
//			this.cur = cur;
//			this.cnt = cnt;
//		}
//	}
}
