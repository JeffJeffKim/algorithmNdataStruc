package pro;
/*
10
10 -4 3 1 5 6 -35 12 21 -1
33
10
2 1 -4 3 4 -4 6 5 -5 1
14
5
-1 -2 -3 -4 -5
-1
5
10 1 -10 8 3
12
*/
import java.util.Scanner;

public class ContinuousSum_1912 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		sc.close();
		
		int[] dp = new int[N];
		dp[0] = arr[0];
		
        int max = arr[0];
        for(int i=1; i<N; i++){
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
	}

}

//		lastIdx = 0;
//		int max =0;
//		for(int i=1; i<N; i++) {
//			getMax(i);
//		}
//		System.out.println(dp[lastIdx]);

//static void getMax(int idx) {
//	int curMax=arr[idx], sum=0, i;
//	for(i=idx; i>lastIdx; i--) {
//		sum += arr[i];
//		if(sum > curMax) {
//			curMax = sum;
//		}
//	}
//	
//	if(sum + dp[lastIdx] >= curMax) {
//		if(sum > 0) {
//			dp[idx] = sum+dp[lastIdx];
//			lastIdx = idx;
//		}
//	}else {
//		if(curMax >= dp[lastIdx]) {
//			dp[idx] = curMax;
//			lastIdx = idx;
//		} 
//	}
//}



//static void getMax(int idx) {
//	int curMax=arr[idx], sum=0, curIdx=idx, i;
//	for(i=idx; i>lastIdx; i--) {
//		sum += arr[i];
//		if(sum > curMax) {
//			curMax = sum;
//			curIdx = i;
//		}
//	}
//	
//	if(sum+dp[lastIdx] > curMax && sum > 0) {
//		dp[idx] = sum+dp[lastIdx];
//		lastIdx = idx;
//	}
//	
//	if(curMax >= dp[lastIdx]) {
//		dp[idx] = curMax;
//		if(curIdx == lastIdx+1) 
//			if(dp[lastIdx] > 0)
//				dp[idx] += dp[lastIdx];
//		lastIdx = curIdx;
//	} else if(curIdx == lastIdx+1) {
//		if(curMax >= 0) { // 둘다 양수
//			dp[idx] = dp[lastIdx] + curMax;
//			lastIdx = curIdx;
//		}
//	}
//}
