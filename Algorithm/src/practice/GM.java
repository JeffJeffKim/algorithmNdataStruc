package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class GM {
	/**
	 * Iterate through each line of input.
	 */
	public static void main(String[] args) throws IOException {
//		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//		BufferedReader in = new BufferedReader(reader);
		System.out.println("ha");
		String line="";
		String input = "He Wo";
		String arr[] = input.split(" ");
		System.out.println(arr.length);
		for(int i=arr.length-1; i>=0; i--) {
			System.out.println(arr[i]);
			line += arr[i]+" ";
			line.trim();
		}
		System.out.println(line);
//		while ((line = in.readLine()) != null) {
//			System.out.println(Integer.parseInt(line)*5);
//		}
	}
}