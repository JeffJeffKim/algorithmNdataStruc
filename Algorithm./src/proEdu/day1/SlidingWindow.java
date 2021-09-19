package proEdu.day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SlidingWindow {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int tc = Integer.parseInt(br.readLine());
		for(int i=1; i<=tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int win = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] inArr = new int[cnt];
			int max = Integer.MIN_VALUE;
			int sum = 0, eIdx = 0, sIdx = 0;
			for(int j=0; j<cnt; j++) {
				inArr[j] = Integer.parseInt(st.nextToken());
				sum += inArr[j];
				if(j >= win) 
					sum -= inArr[j-win];
				if(j >= win-1 && sum > max) {
					eIdx = j;
					if(j < win)
						sIdx = 0;
					else
						sIdx = j-win+1;
					max = sum; 
				}
			}
			bw.write("#"+i+" "+sIdx+" "+eIdx+" "+max+"\n");
		}
		
		br.close();
		bw.close();
		
	}

}
