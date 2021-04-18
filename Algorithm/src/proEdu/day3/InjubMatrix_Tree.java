package proEdu.day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class InjubMatrix_Tree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] nodeV = {
			{0,1680,9941,0,0,0,0,0,0,0,0},
			{0,0,0,3367,3261,0,0,0,0,0,0},
			{0,0,0,0,0,2976,4889,0,0,0,0},
			{0,0,0,0,0,0,0,1234,6461,0,0},
			{0,0,0,0,0,0,0,0,0,7329,5518},
	};
//	static int[] nodeIdx = {1004, 1680, 9941, 3367, 1234, 6461, 2976, 4889, 7329, 5518};
	static int[] nodeIdx = {0, 1004, 
			1680, 9941, 
			3367, 3261, 2976, 4889, 
			0, 0, 1234, 6461, 7329, 5518, 0, 0};
	
	public static void main(String[] args) throws IOException {
		int value = Integer.parseInt(br.readLine());
		int idx = getIdx(value);
		if(idx == -1) {
			System.out.println("no person");
		}else {
			boss(idx);
			company(idx);
			junior(idx);
		}
		
		br.close();
		bw.close();
	}
	
	static int getIdx(int value) {
		int result = -1;
		for(int i=0; i<nodeIdx.length; i++) {
			if(nodeIdx[i] == value)
				result = i;
		}
		return result;
	}
	
	static void junior(int idx) {
		if(idx*2 > nodeIdx.length-1) {
			System.out.println("no junior");
			return;
		}
		int result = nodeIdx[idx*2];
		int result1 = nodeIdx[idx*2+1];
		if(result == 0 || result == idx)
			System.out.println("no junior");
		else
			System.out.println(result+" "+result1);
	}
	
	static void company(int idx) {
		if(idx == 1) {
			System.out.println("no company");
			return;
		}
		int result = 0;
		if(idx%2 == 0)
			result = nodeIdx[idx+1];
		else
			result = nodeIdx[idx-1];
		if(result == 0 || result == idx)
			System.out.println("no company");
		else
			System.out.println(result);
	}

	private static void boss(int idx) {
		int result = nodeIdx[idx/2];
		if(result == 0 || result == idx)
			System.out.println("no boss");
		else
			System.out.println(result);
		
//		for(int i=0; i<nodeV.length; i++) {
//			if(nodeV[idx][i] != 0)
//				System.out.println();
//			return;
//		}
//		System.out.println("no boss");
	}
}
