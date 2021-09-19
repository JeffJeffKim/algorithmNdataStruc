package pro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Group_1_11723 {
	
	//비트 마스크
	public static void main(String[] args) throws NumberFormatException, IOException {
		final String ADD = "add", CHECK = "check", REMOVE = "remove", TOGGLE = "toggle", ALL = "all", EMPTY = "empty";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int idx = -1, num = 0;
		while(N-- > 0) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			String oper = st.nextToken();
			if(!oper.equals(ALL) && !oper.equals(EMPTY)) 
				idx = Integer.parseInt(st.nextToken());
			
			switch(oper) {
			case CHECK:
				sb.append(((num & 1<<idx) == 1 ? 1 : 0)+"\n");
				break;
			case ADD:
				num = num | 1<<idx;
				break;
			case REMOVE:
				num = num & 0<<idx;
				break;
			case TOGGLE:
				num = num ^ 1<<idx;
				break;
			case ALL:
				num = ~0;
				break;
			case EMPTY:
				num = 0;
				break;
			}
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}
