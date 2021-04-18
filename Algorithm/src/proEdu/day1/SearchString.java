package proEdu.day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SearchString {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		String str ="";
		for(int i=0; i<row;i++) {
			str += br.readLine();
		}
		int searchLen = Integer.parseInt(br.readLine());
		String strSearch = br.readLine();
		int sIdx = 0;
		while(str.indexOf(strSearch, sIdx) != -1) {
			sIdx = str.indexOf(strSearch, sIdx);
			bw.write("("+(sIdx/col)+","+(sIdx%col)+")\n");
			sIdx++;
		}
		br.close();
		bw.close();
	}
}
