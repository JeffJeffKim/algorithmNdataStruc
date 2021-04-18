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

public class TruckCount {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tLen = Integer.parseInt(st.nextToken());
		int boxCnt = Integer.parseInt(st.nextToken()); 
//		Queue<Box> qMin = new PriorityQueue<Box>(Comparator.comparing(b -> b.x));
//		Queue<Box> qMax = new PriorityQueue<Box>(Comparator.comparing(b -> b.x));
		Queue<Box> qMin = new PriorityQueue<Box>(new Comparator<Box>() {
			@Override
			public int compare(Box o1, Box o2) {
				return o2.x - o1.x;
			}
		});
		Queue<Box> qMax = new PriorityQueue<Box>(new Comparator<Box>() {
			@Override
			public int compare(Box o1, Box o2) {
				return o2.x - o1.x;
			}
		});
		
		while(boxCnt-- > 0 ) {
			st = new StringTokenizer(br.readLine());
			int a =  Integer.parseInt(st.nextToken());
			int b =  Integer.parseInt(st.nextToken());
			if(a > b)
				qMax.add(new Box(b, a));
			else
				qMax.add(new Box(a, b));
		}
		
		int result = 0;
		int remain = 130;
		while(!qMax.isEmpty() || !qMin.isEmpty()) {
			Box box = null;
			if(!qMin.isEmpty()) {
				box = qMin.poll();
			} else
				box = qMax.poll();
			if(box.x < remain) {
				
			}else {
				continue;
			}
			
		}
		
		
		br.close();
		bw.close();
	}

}

class Box {
	public int x;
	public int y;
	public Box(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
