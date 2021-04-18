package proEdu.day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BlackList {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean[] arrB; 
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int inRow = Integer.parseInt(st.nextToken());
		int inCol = Integer.parseInt(st.nextToken());
//		int total = inRow * inCol;
		int max = 100_000;
		int[][] arrApt = new int[inRow][inCol];
		for(int i=0; i<inRow; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<inCol; j++)
				arrApt[i][j] = Integer.parseInt(st.nextToken()); 
		}
		st = new StringTokenizer(br.readLine());
		int bRow = Integer.parseInt(st.nextToken());
		int bCol = Integer.parseInt(st.nextToken());
		arrB = new boolean[max+100];
		for(int i=0; i<bRow; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<bCol; j++)
				arrB[Integer.parseInt(st.nextToken())] = true;; 
		}

		int bCount = 0, nCount = 0;
		for(int i=0; i<inRow; i++) {
			for(int j=0; j<inCol; j++) {
				if(arrB[arrApt[i][j]]) {
					bCount++;
				}else
					nCount++;
			}
		}
		
		bw.write(bCount+"\n"+nCount);
//		bw.write((total-bCount)+"\n"+bCount);
		
		br.close();
		bw.close();
	}

}
