package company.zigbang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int pNum = Integer.parseInt(st.nextToken());
		int inoutNum = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[inoutNum];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<inoutNum; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		int patient = Integer.parseInt(br.readLine());
		
		HashSet<Integer> inBuilding = new HashSet<>(); 
		HashSet<Integer> result = new HashSet<>();
		boolean inPatient = false;
		boolean pNumErr = false;
		for(int cur : arr) {
			
			if(cur > 0) {
				if(cur > pNum) {
					pNumErr = true;
					break;
				}
				
				if(cur == patient) {
					inPatient = true;
					Iterator<Integer> iSet = inBuilding.iterator();
					while(iSet.hasNext()){
						result.add(iSet.next());
					}
				} else {
					if(inPatient) {
						result.add(cur);
					} else {
						inBuilding.add(cur);
					}
				}
			} else {
				cur *= -1;
				if(cur > pNum) {
					pNumErr = true;
					break;
				}
				
				if(cur == patient) {
					inPatient = false;
				} else {
					inBuilding.remove(cur);
				}
			}
		}
		
		if(pNumErr) {
			bw.write("-1");
		} else if(result.size() == 0) {
			bw.write("-1");
		} else {
			Iterator<Integer> iSet = result.iterator();
			while(iSet.hasNext()){
				bw.write(iSet.next()+" ");
			}
		}
		
		br.close();
		bw.close();
	}

}

/*
6 14 
2 1 3 4 -3 -4 -1 -2 5 -5 1 6 -1 -6 
1

2 3 4 6 


7 10
2 6 3 4 -6 5 -3 -4 -5 -2 
2

3 4 5 6 
*/