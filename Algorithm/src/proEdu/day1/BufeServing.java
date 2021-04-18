package proEdu.day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BufeServing {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int tc = Integer.parseInt(br.readLine());
		for(int i=1; i<=tc; i++) {
			int[] dup = new int[100];
			String result = "YES";
			StringTokenizer st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int wide = Integer.parseInt(st.nextToken());
			String str = br.readLine();
			
			// init
			dup[str.charAt(wide)]++;
			for(int k=1; k<=wide; k++) {
				dup[str.charAt(wide+k)]++;
				dup[str.charAt(wide-k)]++;
			}
			
			for(int j=wide+1; j<str.length(); j++) {
				int idx = getIdx(j+wide, str.length());
				dup[str.charAt(idx)]++;
				int idx2 = getIdx(j-wide-1, str.length());
				dup[str.charAt(idx2)]--;
				if(dup[str.charAt(idx)] > 2) {
					result = "NO";
					break;
				}
			}
			
			bw.write("#"+i+" "+result+"\n");
		}
		
		br.close();
		bw.close();
	}
	
	static int getIdx(int idx, int len) {
		int result = 0;
		if(idx > len-1) {
			result = idx - len;
		}else if(idx < 0) {
			result = len-idx-1;
		}else {
			result = idx;
		}
		return result;
	}

}
