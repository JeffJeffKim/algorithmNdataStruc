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

public class UglyNumber {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int arrIdx[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			arrIdx[i] = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[2001];
		Queue<Long> q = new PriorityQueue<>();
		q.add(1L);
		int idx = 0;
		while(arr[2000] == 0) {
			if(idx >= 11) {
				
				int dd = 0;
				dd =1;
			}
			long num = q.poll();
			if(arr[idx] == num)
				continue;
			arr[++idx] = num;
			q.add(num*2);
			q.add(num*3);
			q.add(num*5);
		}
		for(int cur : arrIdx) {
			bw.write(arr[cur]+" ");
		}
		br.close();
		bw.close();
	}

}
