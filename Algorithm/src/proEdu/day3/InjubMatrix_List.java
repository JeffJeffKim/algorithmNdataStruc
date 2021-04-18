package proEdu.day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class InjubMatrix_List {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] dts = new int[10000];
	
	public static void main(String[] args) throws IOException {
		ArrayList<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<11; i++)
			aList.add(new ArrayList<Integer>());
		aList.get(0).add(1680);
		aList.get(0).add(9941);
		aList.get(1).add(3367);
		aList.get(1).add(3261);
		aList.get(2).add(2976);
		aList.get(2).add(4889);
		//
		aList.get(4).add(1234);
		aList.get(4).add(6461);
		//
		aList.get(7).add(7329);
		aList.get(7).add(5518);
		
		int[] nodeIdx = {1004, 
				1680, 9941, 
				3367, 3261, 
					1234, 6461, 
				2976, 4889, 
				7329, 5518};
		
		Arrays.fill(dts, -1);
		for(int i=0; i<nodeIdx.length; i++) {
			dts[nodeIdx[i]] = i;
		}
		
		int val = Integer.parseInt(br.readLine());
		int idx = dts[val];
		if(idx == -1) {
			bw.write("no person");
		}else {
			// 부모 2중 for, 비효율적
			
		}
		
		br.close();
		bw.close();
		
	}

}
