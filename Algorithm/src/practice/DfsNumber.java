package practice;

public class DfsNumber {
	
//	static int arr[];
//	static boolean visit[];
	static int N=4;
	
	public static void main(String[] args) {
		boolean visit[] = new boolean[N];
		int arr[] = new int[N];
		dfs(arr, visit, 0);
	}
	
	static void dfs(int[] arr, boolean[] visit, int idx) {
		
		if(idx >= 4) {
			for(int i : arr)	System.out.print(i+" ");
			System.out.println();
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[idx]=i;
				dfs(arr, visit, idx+1);
				visit[i] = false;
			}
			
		}
	}

}
