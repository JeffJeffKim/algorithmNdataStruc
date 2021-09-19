package proEdu.day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LoveStick {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int count = Integer.parseInt(br.readLine());
		int[] result = new int[count];
		for(int i=0; i<count; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<count; j++) {
				if(Integer.parseInt(st.nextToken()) == 1)
					result[j]++;
			}
		}
		
		int max = 0, maxI = -1, min = Integer.MAX_VALUE, minI = -1;
		for(int i=0; i<count; i++) {
			if(result[i] > max) {
				max = result[i];
				maxI = i;
			}
			if(result[i] < min) {
				min = result[i];
				minI = i;
			}
		}
		bw.write(maxI +" "+minI);
		
		
		br.close();
		bw.close();
	}

}
