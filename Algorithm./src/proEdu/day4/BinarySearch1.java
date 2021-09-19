package proEdu.day4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch1 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, arr[], arrT[];
	
	static void bs() throws IOException {
		loop1 : for(int t : arrT) {
			int s=0, e=arr.length-1;
			if(t == 4) {
				
				int d=1;
			}
			while(s <= e) {
				int mid = (s+e)/2;
				int val = arr[mid];
				if(val == t) {
					bw.write("O");
					continue loop1;
				}else if(val > t)
					e = mid-1;
				else
					s = mid+1;
			}
			bw.write("X");
		}
	}
	
	public static void main(String[] args) throws IOException {
		getIn();
		Arrays.sort(arr);
		bs();
		
		br.close();
		bw.close();
	}
	
	static void getIn() throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arrT = new int[n];
		for(int i=0; i<n; i++) {
			arrT[i] = Integer.parseInt(st.nextToken());
		}
	}

}
