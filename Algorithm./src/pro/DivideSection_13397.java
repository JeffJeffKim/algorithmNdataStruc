package pro;

import java.util.Arrays;
import java.util.Scanner;

public class DivideSection_13397 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sizeArr = sc.nextInt();
		int sizeDiv = sc.nextInt();
		int arrIn[] = new int[sizeArr];
		int i=sizeArr;
		while(i-->0)
			arrIn[i] = sc.nextInt();
		sc.close();
		
		int min = Integer.MAX_VALUE;
	}
	
	static int getSecMax(int[] arrSec) {
		int[] arr = arrSec.clone();
		Arrays.sort(arr);
		return arrSec[arr.length-1] - arrSec[0];
	}
}
