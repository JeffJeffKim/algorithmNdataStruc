package proEdu.day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ChocoPresent {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String in = br.readLine();
		boolean[] arr = new boolean[26];
		for(int i=0; i<in.length(); i++) {
			arr[(int)(in.charAt(i)) - 65] = true;
		}
		for(int i=0; i<arr.length; i++) {
			if(arr[i]) {
				bw.write((char)(i+65));
			}
		}
		
		br.close();
		bw.close();
	}

}
