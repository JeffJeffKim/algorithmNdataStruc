package pro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Segment {
	
	static int N, nQuery;
	static long treeArr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		nQuery = Integer.parseInt(st.nextToken());
		nQuery += Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int x = (int) Math.ceil(Math.log(N)/Math.log(2));
		int size = (int) Math.pow(2, x)*2;
		treeArr = new long[size];
		
		init(arr, 0, N-1, 1);
		
		while(nQuery-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(st.nextToken());
			int idx1 = Integer.parseInt(st.nextToken());
			int idx2 = Integer.parseInt(st.nextToken());
			
			if(t == 1) {
				int diff = idx2 - arr[idx1-1];
				arr[idx1-1] = idx2;
				update(1, 0, N-1, idx1-1, diff);
			} else {
				System.out.println(sum(1, 0, N-1, idx1-1, idx2-1));
			}
		}
	}
	
	static long init(int[] arr, int start, int end, int node) {
		if(start == end) 
			return treeArr[node] = arr[start];
		
		int mid = (start+end)/2;
		
		return treeArr[node] = init(arr, start, mid, node*2) 
				+ init(arr, mid+1, end, node*2 +1);
	}
	
	static void update(int node, int start, int end, int idx, long diff) {
		if(start>idx || end<idx)
			return;
		
		treeArr[node] += diff;
		
		if(start != end) {
			int mid = (start + end) /2;
			update(node*2, start, mid, idx, diff);
			update(node*2+1, mid+1, end, idx, diff);
		}
	}
	
	static long sum(int node, int start, int end, int left, int right) {
		if(left > end || right < start)
			return 0;
		
		if(left <= start && right >= end) 
			return treeArr[node];
		
		int mid = (start+end)/2;
		
		return sum(node*2, start, mid, left, right) + sum(node*2+1, mid+1, end, left, right); 
	}

}
