package proEdu.day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Farm {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		for(int i=0; i<row; i++) {
			String str = br.readLine();
			int cnt = 0;
			for(int j=0; j<col; j++) {
				if(str.charAt(j) == '1')
					cnt++;
			}
			bw.write(cnt+"\n");
		}
		br.close();
		bw.close();
	}

}
