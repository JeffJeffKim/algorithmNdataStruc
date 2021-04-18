package proEdu.day4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IndianCorus {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static char[] uArr = new char[100];
	static boolean[] bArr = new boolean[100];
	static int groupedCnt = 0;
	static int unionCnt = 0;
	
	static char find(char a) {
		if(uArr[a] == 0)
			return a;
		char ret = find(uArr[a]);
		uArr[a] = ret;
		return ret;
	}
	
	static void union (char t1, char t2) {
		char a = find(t1);
		char b = find(t2);
		if(a == b)
			return;
		uArr[b] = a;
		if(!bArr[a]) {
			bArr[a] = true;
			groupedCnt++;
		}
		if(!bArr[b]) {
			bArr[b] = true;
			groupedCnt++;
		}
		unionCnt++;
	}
	
	public static void main(String[] args) throws IOException {
		int count = Integer.parseInt(br.readLine());
		for(int i=0; i<count; i++) {
			String str = br.readLine();
			char a = str.charAt(0);
			char b = str.charAt(2);
			union(a, b);
		}
		
		int groupCnt = groupedCnt - unionCnt;
		
		bw.write(groupCnt+"\n"+(26-groupedCnt));
		br.close();
		bw.close();		
	}

}
