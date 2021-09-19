package proEdu.day4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FuelGuage {
	
	static int bs(String str) {
		int s = 0;
		int e = str.length()-1;
		char tar = '#';
		int result = 0;
		while(s <= e) {
			int mid = (s+e)/2;
			if(str.charAt(mid) == tar) {
				result = mid+1;
				s = mid+1;
			}else {
				e = mid-1;
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int caseCnt = Integer.parseInt(br.readLine());
		for(int i=0; i<caseCnt; i++) {
			String str = br.readLine();
			int len = str.length();
			int result = bs(str);
			result = result*100/len;
			bw.write(result+"%\n");
		}
		br.close();
		bw.close();
	}

}

//int s = 0, e = str.length()-1;
//boolean findUnder = false, findSharp = false;
//char target = '_';
//int result = 0;
//while(e >= s) {
//	if(findUnder && findSharp)
//		target = '#';
//	int mid = (s+e)/2;
//	if(!findUnder && !findSharp) {
//		if(str.charAt(mid) == target) {
//			e =  mid-1;
//			findUnder = true;
//			target = '#';
//		}else {
//			s = mid+1;
//		}
//	}else if(findUnder && !findSharp) {
//		if(str.charAt(mid) == target) {
//			s =  mid+1;
//			findSharp = true;
//		} else {
//			e = mid-1;
//		}
//	}else if(findUnder && findSharp) {
//		if(str.charAt(mid) == target) {
//			s =  mid+1;
//			findSharp = true;
//		} else {
//			e = mid-1;
//		}
//	}
//	result = mid;
//}
//
//return result;
