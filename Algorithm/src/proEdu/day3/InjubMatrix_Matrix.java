package proEdu.day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InjubMatrix_Matrix {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] nodeV = {
			{0,1680,9941,0,0,0,0,0,0,0,0},//0
			{0,0,0,3367,3261,0,0,0,0,0,0},//1
			{0,0,0,0,0,0,0,2976,4889,0,0},//2
			{0,0,0,0,0,0,0,0,0,0,0},//3
			{0,0,0,0,0,1234,6461,0,0,0,0},//4
			{0,0,0,0,0,0,0,0,0,0,0},//5
			{0,0,0,0,0,0,0,0,0,0,0},//6
			{0,0,0,0,0,0,0,0,0,7329,5518}, //7
			{0,0,0,0,0,0,0,0,0,0,0}, // 8
			{0,0,0,0,0,0,0,0,0,0,0}, // 9
			{0,0,0,0,0,0,0,0,0,0,0}, // 10
//			{0,1,2,3,4,5,6,7,8,9,10},
//			{0,0,0,0,0,0,0,0,0,0,0},
	};
	static int[] nodeIdx = {1004, 
			1680, 9941, 
			3367, 3261, 
				1234, 6461, 
			2976, 4889, 
			7329, 5518};
	static int[] dts = new int[10000];
	
	public static void main(String[] args) throws IOException {
		int value = Integer.parseInt(br.readLine());
		Arrays.fill(dts, -1);
		for(int i=0; i<nodeIdx.length; i++) {
			dts[nodeIdx[i]] = i;
		}
		
		int idx = getIdx(value);
		if(idx == -1) {
			System.out.println("no person");
		}else {
//			System.out.println(idx);
			int bossIdx = boss(idx);
			company(bossIdx, value);
			junior(idx);
		}
		
		br.close();
		bw.close();
	}
	
	static int getIdx(int value) {
		int result = dts[value];
		return result;
	}
	
	static void junior(int idx) {
		boolean isExist = false;
		for(int i=0; i<nodeV.length; i++) {
			if(nodeV[idx][i] != 0) {
				System.out.print(nodeV[idx][i]+" ");
				isExist = true;
			}
		}
		if(!isExist)
			System.out.println("no junior");
	}
	
	static void company(int idx, int value) {
		if(idx == -1) {
			System.out.println("no company");
			return;
		}
			
		for(int i=0; i<nodeV.length; i++) {
			if(nodeV[idx][i] != value && nodeV[idx][i] != 0) {
				System.out.println(nodeV[idx][i]);
				return;
			}
		}
		System.out.println("no company");
	}

	private static int boss(int idx) {
		for(int i=0; i<nodeV.length; i++) {
			if(nodeV[i][idx] == nodeIdx[idx]) {
				System.out.println(nodeIdx[i]);
				return i;
			}
		}
		System.out.println("no boss");
		return -1;
	}
}
