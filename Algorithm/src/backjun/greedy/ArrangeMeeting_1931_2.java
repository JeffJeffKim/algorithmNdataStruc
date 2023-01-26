//https://www.acmicpc.net/problem/1931

package backjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ArrangeMeeting_1931_2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] time = new int[N][2];

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++)
				time[i][j] = Integer.parseInt(st.nextToken());
		}
		int result=0;

//		Arrays.sort(time, (t1, t2) -> t1[0] - t2[0]);
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
//				if (o1[1] > o2[1])
//					return 1;
//				if (o1[1] < o2[1])
//					return -1;
//				if (o1[0] < o2[0])
//					return 1;
//				if (o1[0] > o2[0])
//					return -1;
//				return 0;
				if (o2[1] != o1[1])
					return o1[1] - o2[1];

				return o1[0] - o2[0];
			}
		});

		int end = 0;

		for (int i = 0; i < time.length; i++) {
			if (time[i][0] >= end) {
				end = time[i][1];
				result++;
			}
		}

		System.out.println(result);
	}
	
}
