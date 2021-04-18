package proEdu.day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BuildTest {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		int type = Integer.parseInt(br.readLine());
		
		if(type == 1) {
			type1();
		}else if(type == 2) {
			type2();
		}else if(type == 3) {
			type3();
		}
		br.close();
		bw.write(sb.toString());
		bw.close();
	}
	
	static void type3() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n*m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i*m+j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<arr.length; i++) {
		}
		Arrays.sort(arr);
		int cnt = 1, min = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(min == arr[i])
				cnt++;
			else
				break;
		}
		sb.append(min+"\n"+cnt+"°³");
	}
	
	static void type2() throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		String arrIn[] = new String[n];
		int arrLen[] = new int[n];
		while(n-- > 0) {
			arrIn[n] = br.readLine();
			arrLen[n] = arrIn[n].length();
		}
		
		int min = Integer.MAX_VALUE, max = 0, minIdx = 0, maxIdx = 0;
		for(int i=0; i<arrLen.length; i++) {
			if(arrIn[i].length() < min) {
				min = arrIn[i].length();
				minIdx = i;
			}

			if(arrIn[i].length() > max) {
				max = arrIn[i].length();
				maxIdx = i;
			}
		}
		
		sb.append(arrIn[maxIdx]+"\n");
		sb.append(arrIn[minIdx]);
	}
	
	static void type1() throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int[] arrIn = new int[n];
		String arr[] = str.split(" ");
		for(int i=0; i<arr.length; i++)
			arrIn[i] = Integer.parseInt(arr[i]);
		int sum = 0; long mul = 1;
		for(int num : arrIn) {
			sum += num;
			mul *= num;
		}
		sb.append(sum+" "+mul);
	}
	
	
	
	

}
