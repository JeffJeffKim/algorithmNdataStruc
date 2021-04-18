package proEdu.day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class UndefinedSignal {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int tc = Integer.parseInt(br.readLine());
		for(int i=1;  i<=tc; i++) {
			String result = "PASS";
			int width = Integer.parseInt(br.readLine());
			String str = br.readLine();
			int[] isExist = new int[200];
			
			//init
			for(int j=0; j<width; j++) {
				if(isExist[str.charAt(j)] == 1) {
					result = "FAIL";
					break;
				}else {
					isExist[str.charAt(j)]++;
				}
			}
			System.out.println(str.length()+" "+(str.length()-width));
			if(result.equals("PASS")) {
				for(int j=width; j<=str.length() - width; j++) {
					isExist[str.charAt(j-width)]--;
					isExist[str.charAt(j)]++;
					char c = str.charAt(j);
					if(isExist[str.charAt(j)] > 1) {
						result = "FAIL";
						break;
					}
				}
			}
			
			bw.write("#"+i+" "+result+"\n");
		}
		
		br.close();
		bw.close();
	}

}
