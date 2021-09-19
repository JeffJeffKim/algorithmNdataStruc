package pro;

import java.util.Scanner;

public class TransMatrix_1080 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		boolean[][] arrA = new boolean[row][col], arrB = new boolean[row][col];
		String[] arrLine = new String[row];
		sc.nextLine();
		for(int i=0; i<row; i++) 
			arrLine[i] = sc.nextLine();
		setInput(arrA, arrLine);
		for(int i=0; i<row; i++) 
			arrLine[i] = sc.nextLine();
		setInput(arrB, arrLine);
		
		sc.close();
		
		int result = 0;
		for(int i=0; i<row-2; i++) {
			for(int j=0; j<col-2; j++) {
				if(arrA[i][j] != arrB[i][j]) {
					inverseArr(arrA, i, j);
					++result;
				}
			}
		}
		
		loop1: for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(arrA[i][j] != arrB[i][j]) {
					result = -1;
					break loop1;
				}
			}
		}
		System.out.println(result);
	}
	
	static void inverseArr(boolean[][] bArr, int row, int col) {
		for(int i=row; i<row+3; i++) {
			for(int j=col; j<col+3; j++) {
				bArr[i][j] = !bArr[i][j];
			}
		}
	}
	
	static void setInput(boolean[][] bArr, String[] sArr) {
		for(int i=0; i<bArr.length; i++) {
			String str = sArr[i];
			for(int j=0; j<bArr[i].length; j++) {
				if(str.charAt(j) == '1')
					bArr[i][j] = true;
			}
		}
	}

}
