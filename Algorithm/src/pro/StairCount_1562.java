package pro;

import java.util.Scanner;

//이해 안감
public class StairCount_1562 {
	
	public static int N, VISIT=1<<10, MOD=1000000000;
	public static long dp[][][] = new long[101][10][VISIT];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
		N = 10;
		System.out.println(calc());
		sc.close();
	}

	private static long calc() {
		long sum=0;
		int i, j, k, bit;

		for(i=1; i<10; i++) dp[1][i][1<<i] = 1;

		for (i=2; i<=N; i++)
			for (j=0; j<=9; j++)
				for(k=0; k<VISIT; k++) {
					bit = k | (1<<j);
					dp[i][j][bit] = (dp[i][j][bit] + 
                                     ((0<j ? dp[i-1][j-1][k] : 0) +
                                      (j<9 ? dp[i-1][j+1][k] : 0))%MOD
                                     )%MOD;
					System.out.print("i:"+i+", j:"+j+", k:"+k+", bit:"+bit+" ,"+dp[i][j][bit]);
					if(0<j)
						System.out.print(", ("+(i-1)+","+(j-1)+","+k+"):"+dp[i-1][j-1][k]);
					if(j<9)
						System.out.print(", ("+(i-1)+","+(j+1)+","+k+")"+dp[i-1][j+1][k]);
					System.out.println();
				}
		for (i=0; i<10; i++) sum = (sum + dp[N][i][VISIT-1])%MOD;
		return sum;
	}

}

