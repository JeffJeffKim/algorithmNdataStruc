package proEdu.day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CardMachine {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int tc = Integer.parseInt(br.readLine());
		while(tc-- > 0) {
			int count = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] order = new int[count+1];
			int[] h = new int[count+1];
			for(int i=0; i<count; i++) 
				h[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<count; i++) 
				order[i] = Integer.parseInt(st.nextToken());
			
			int[] orderedH = new int[count+1];
			for(int i=0; i<count+1; i++) {
				int num = order[i];
				int numH = h[i];
				orderedH[num] = numH;
			}
			
			String result = "YES";
			for(int i=2; i<count+1; i++) {
//				System.out.println(orderedH[i-1]+" "+orderedH[i]);
				if(orderedH[i-1] < orderedH[i]) {
					result = "NO";
					break;
				}
			}
			
			bw.write(result+"\n");
		}
		br.close();
		bw.close();
	}

}
