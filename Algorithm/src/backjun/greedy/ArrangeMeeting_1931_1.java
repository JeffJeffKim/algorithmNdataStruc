package backjun.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ArrangeMeeting_1931_1 {
	
	public static void main(String[] args) {
		Queue<Meeting> q = getInput();
//		sort(list);
		System.out.println(getCount(q));
	}
	
	static int getCount(Queue<Meeting> q) {
		int count = 0, lastEnd = -1;
		while(!q.isEmpty()) {
			Meeting meet = q.poll();
			if(lastEnd <= meet.start) {
				count++;
				lastEnd = meet.end;
			}
		}
		return count;
	}
	
//	static void sort(List<Meeting> list) {
//		list.sort(Comparator.comparing(m -> m.end));
//	}
	
	static Queue<Meeting> getInput() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Meeting> q = new PriorityQueue<Meeting>(Comparator.comparing(m -> m.end));
		for(int i=0; i<N; i++) {
			Meeting meet = new Meeting();
			meet.start = sc.nextInt();
			meet.end = sc.nextInt();
			q.add(meet);
		}
		sc.close();
		return q;
	}
	
	static class Meeting {
		public int start;
		public int end;
	}

}
