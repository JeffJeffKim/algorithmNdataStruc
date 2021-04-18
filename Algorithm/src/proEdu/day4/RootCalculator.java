package proEdu.day4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RootCalculator {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long target = Integer.parseInt(br.readLine());
		if(target == 1)
			bw.write("1");
		else {
			int pow = 0;
			while(true) {
				if((pow*pow) >= target)
					break;
				pow++;
			}
			
			bw.write(--pow+"");
		}
		br.close();
		bw.close();
	}

}
