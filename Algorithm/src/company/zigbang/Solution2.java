package company.zigbang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int cnt = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] inNum = new int[cnt];
		for(int i=0; i<cnt; i++) {
			inNum[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(inNum);
		int midIdx = inNum.length/2;
		int lSize = cnt%2 == 0 ? midIdx : midIdx+1;
		Integer[] smalls = new Integer[midIdx];
		Integer[] larges = new Integer[lSize];
		for(int i=0; i<midIdx; i++) {
			smalls[i] = inNum[i];
		}
		for(int i=midIdx, j=0; i<cnt; i++, j++) {
			larges[j] = inNum[i];
		}
		
		Arrays.sort(smalls, Collections.reverseOrder());
		Arrays.sort(larges);

		int result = 0;
		for(int i=0; i<lSize; i++) {
			int idx = i*2+1;
			result += larges[i] * idx;
			if(i<smalls.length) {
				result += smalls[i] * ++idx * -1;
			}
		}
		
		bw.write(result+"");
		
		br.close();
		bw.close();
	}

}

/*
1. ī�带 ���� ��, ī�忡 ���� ���� ������� ���� ī���� ������ ���Ѵ�
2. ���� ¦�� ��°�� ���� ī���� -1�� �߰��� ���Ѵ�.

3
1 2 3

9

5
1 3 5 7 9

61
 */
