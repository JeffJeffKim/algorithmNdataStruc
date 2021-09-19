package proEdu.day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class MidUniv {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		Queue<Integer> minQ = new PriorityQueue<>();
		Queue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
		int mid = 500;
		
		int n = Integer.parseInt(br.readLine());
		while(n -- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			if(mid < n1) 
				minQ.add(n1);
			else
				maxQ.add(n1);
			
			if(mid < n2) 
				minQ.add(n2);
			else
				maxQ.add(n2);
			
			if(minQ.size() > maxQ.size()) {
				maxQ.add(mid);
				mid = minQ.poll();
			}else if(minQ.size() < maxQ.size()) {
				minQ.add(mid);
				mid = maxQ.poll();
			}
			bw.write(mid+"\n");
		}
		
		br.close();
		bw.close();
	}
	
}
