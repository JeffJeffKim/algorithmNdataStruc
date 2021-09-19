package pro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CutTree_2805 {
	
	
	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line, " ");
		int N = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		line = br.readLine();
		br.close();
		st = new StringTokenizer(line, " ");
		var lTree = new ArrayList<Integer>(N);
		for(int i=0; i<N; i++) {
			int h = Integer.parseInt(st.nextToken());
			lTree.add(h);
		}
		
		Collections.sort(lTree);
		int low = 1;
		int high = lTree.get(N-1);
		while(low <= high) {
			long curSum = 0;
			int tempH = (low+high)/2;
			for(int i=N-1; i>=0; i--) {
				if(tempH >= lTree.get(i))	break;
				curSum += lTree.get(i)-tempH;
				
				if(curSum >= target) {
					low = tempH+1;
					break;
				}
			}
			if(curSum < target)
				high = tempH-1; 
		}
		
		System.out.println(high);
	}
}

