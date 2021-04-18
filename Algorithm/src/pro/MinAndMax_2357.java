package pro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MinAndMax_2357 {
	
	static int arrMax[], arrMin[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cntNum = Integer.parseInt(st.nextToken());
		int cntOut = Integer.parseInt(st.nextToken());
		int[] arrIn = new int[cntNum];
		for(int i=0; i<cntNum; i++)
			arrIn[i] = Integer.parseInt(br.readLine()); 
		
		int power = (int) Math.ceil(Math.log(cntNum)/Math.log(2)) +1;
		int size = (int) Math.pow(2, power);
		arrMax = new int[size];	arrMin = new int[size];
//		init(1, 0, cntNum-1, arrIn);
		initMin(1, 0, cntNum-1, arrIn);
		initMax(1, 0, cntNum-1, arrIn);
		
		StringBuilder sb = new StringBuilder();
		while(cntOut-- > 0) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken())-1;
			int right = Integer.parseInt(st.nextToken())-1;
//			int[] arr = getMinMax(1, 0, cntNum-1, left, right);
//			sb.append(arr[0] +" "+ arr[1]+"\n");
			sb.append(getMin(1, 0, cntNum-1, left, right) +" "+ getMax(1, 0, cntNum-1, left, right)+"\n");
		}
		br.close();
		bw.write(sb.toString());
		bw.close();
	}
	
	static void init(int node, int start, int end, int[] arr) {
		if(start >= end) {
			arrMax[node] = arr[start];
			arrMin[node] = arr[start];
			return;
		}
		int mid = (start+end)/2;
		init(node*2, start, mid, arr);
		init(node*2+1, mid+1, end, arr);
		arrMin[node] = Math.min(arrMin[node*2], arrMin[node*2+1]);
		arrMax[node] = Math.max(arrMax[node*2], arrMax[node*2+1]);
	}
	
	static int initMin(int node, int start, int end, int[] arr) {
		if(start >= end) 
			return arrMin[node] = arr[start];
		int mid = (start+end)/2;
		return arrMin[node] = Math.min(initMin(node*2, start, mid, arr), initMin(node*2+1, mid+1, end, arr));
	}

	static int initMax(int node, int start, int end, int[] arr) {
		if(start >= end) 
			return arrMax[node] = arr[start];
		int mid = (start+end)/2;
		return arrMax[node] = Math.max(initMax(node*2, start, mid, arr), initMax(node*2+1, mid+1, end, arr));
	}
	
	static int[] getMinMax(int node, int start, int end, int left, int right) {
		if(left > end || right < start) 
			return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
		if(left <= start && end <= right) 
			return new int[] {arrMin[node], arrMax[node]};
		int mid = (start+end)/2;
		if(start >= end)	
			return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
		
		int[] arr1 = getMinMax(node*2, start, mid, left, right);
		int[] arr2 = getMinMax(node*2+1, mid+1, end, left, right);
		
		return new int[] {Math.min(arr1[0], arr2[0]), Math.max(arr1[1], arr2[1])};
	}

	static int getMin(int node, int start, int end, int left, int right) {
		if(left > end || right < start)
			return Integer.MAX_VALUE;
		if(left <= start && end <= right)
			return arrMin[node];
		int mid = (start+end)/2;
//		if(start >= end)	
//			return Integer.MAX_VALUE;
		return Math.min(getMin(node*2, start, mid, left, right), getMin(node*2+1, mid+1, end, left, right));
	}

	static int getMax(int node, int start, int end, int left, int right) {
		if(left > end || right < start)
			return Integer.MIN_VALUE;
		if(left <= start && end <= right)
			return arrMax[node];
		int mid = (start+end)/2;
//		if(start >= end)	
//			return Integer.MIN_VALUE;
		return Math.max(getMax(node*2, start, mid, left, right), getMax(node*2+1, mid+1, end, left, right));
	}
}

/*
10 4
75
30
100
38
50
51
52
20
81
5
1 10
3 5
6 9
8 10

ans
5 100
38 100
20 81
5 81
 */