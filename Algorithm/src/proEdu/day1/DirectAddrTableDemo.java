package proEdu.day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class DirectAddrTableDemo {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String str = "AABCDAFEB";
		str = "AABCDAFEBBBB";
		int[] arr = new int[27];
		int max = 0;
		char c = 'A';
		for(int i=0; i<str.length(); i++) {
			arr[(int)str.charAt(i)-65]++;
			if(max < arr[i]) {
				max = arr[i]; 
				c = str.charAt(i);
			}
		}
		System.out.println(max + " " + c);
	}

}
