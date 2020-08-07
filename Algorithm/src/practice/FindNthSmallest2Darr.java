package practice;

//Given an n x n matrix, where every row and column is sorted in non-decreasing order. Find the kth smallest element in the given 2D array.

public class FindNthSmallest2Darr {
	
	static final int[][] arr = new int[][]{{1,2,3}, {4,5,6}};
	public static void main(String[] args) {
		for(int i=1; i<=arr.length*arr[0].length; i++)
			System.out.println(getElement(i));
	}
	
	static int getElement(int n) {
		n--;
		int len = arr[0].length;
		int y = n/len;
		int x = n%len;
		return arr[y][x];
	}

}
