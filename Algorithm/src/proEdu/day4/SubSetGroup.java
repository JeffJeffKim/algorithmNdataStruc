package proEdu.day4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SubSetGroup {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, arr[], arrT[];
	
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
//		int numCnt = Integer.parseInt(st.nextToken());
//		int groupCnt = Integer.parseInt(st.nextToken());
//		int arrHead[] = new int[numCnt];
		int numCnt = 8;
		int groupCnt = 3;
		int arrHead[] = {150, 130, 90, 110, 140, 200, 120, 90};
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<numCnt; i++)
			arrHead[i] = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Comparator.comparing(n -> n));
		
		while(numCnt-- > 0) {
			if(q.isEmpty() || q.size() <= groupCnt) {
				q.add(arrHead[numCnt]);
			}
//			else if(q.size() <= groupCnt) {}
			else {
				int num = q.peek();
				q.add(num + arrHead[numCnt]);
			}
				
		}
		
		
		br.close();
		bw.close();
	}
	
	static void bt(int[] arr, int count) {
		int[] arrSE = new int[count*2];
		int s = 0;
		int e = arr.length-1-2;
//		for(int i=2; i<arrSE.length; i+=2) {
//			arrSE[i] = 0;
//			arrSE[i+1] = arr.length-count+i;
//		}
		int sum = getSum(arr, arrSE[0], arrSE[1]);
		for(int i=0; i<count;  i++) {
			s = bs(arr, s, arr.length-1-i, sum/2);
			if(s == -1) {
				sum = (sum + sum/2)/2;
				break;
			} else {
				sum = sum/2;
			}
		}
	}
	
	static int bs(int[] arr, int s, int e, int target) {
		int result = -1;
		while(s <= e) {
			int mid = (s+e)/2;
			int sum = getSum(arr, s, mid);
			if(sum <= target) 
				result = mid;
			e = mid+1;
		}
		return result;
	}
	
	static int getSum(int[] arr, int s, int e) {
		int sum = 0;
		for(int i=s; i<=e; i++)
			sum += arr[i];
		return sum;
	}
}
