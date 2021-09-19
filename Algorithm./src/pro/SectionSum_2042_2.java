package pro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
5 2 2
1
2
3
4
5
1 3 6
2 2 5
1 5 2
2 3 5

ans
17 
12
 */

public class SectionSum_2042_2 {
	
	static long[] arrTree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());
		cnt += Integer.parseInt(st.nextToken());
		
		int[] arrIn = new int[N];
		for(int i=0; i<N; i++)
			arrIn[i] = Integer.parseInt(br.readLine());
		
		int power = (int)Math.ceil(Math.log(N)/Math.log(2)) +1;
		int size = (int) Math.pow(2, power);
		arrTree = new long[size];
		
		init(1, 0, N-1, arrIn);
		while(cnt-- > 0) {
			st = new StringTokenizer(br.readLine());
			int formular = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken())-1;
			int val = Integer.parseInt(st.nextToken());
			if(formular == 1) {
				int diff = val - arrIn[idx];
				arrIn[idx] = val;
				update(1, idx, 0, N-1, diff);
			}else {
				sb.append(sum(1, idx, val-1, 0, N-1)+"\n");
			}
		}
		
		br.close();
		bw.write(sb.toString());
		bw.close();
	}
	
	static long init(int node, int start, int end, int[] arr) {
		if(start >= end)
			return arrTree[node] = arr[start];
		
		int mid = (start+end)/2;
		return arrTree[node] = init(node*2, start, mid, arr) + init(node*2+1, mid+1, end, arr);
	}
	
	static void update(int node, int idx, int start, int end, int diff) {
		if(!(start <= idx && idx <= end))	
			return;
		
		if((start <= idx && idx <= end))	
			arrTree[node] += diff;
		if(start >= end)	
			return;
		int mid = (start+end)/2;
		update(node*2, idx, start, mid, diff);
		update(node*2+1, idx, mid+1, end, diff);
	}

	static long sum(int node, int left, int right, int start, int end) {
		if(left > end || right < start)	
			return 0;
		if(left <= start && end <= right)
			return arrTree[node];
		int mid = (start+end)/2;
		return sum(node*2, left, right, start, mid) + sum(node*2+1, left, right, mid+1, end);
	}
}
