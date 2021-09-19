package company.bairesDev;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

// method2 and 3 is same and fastest. 4 is wrong
public class BairesDev3 {
	
	public static void main(String[] args) {
//		System.out.println('a'-97);
		
//		int[] a = {1,2};
		
		int[][] arr = {{0,11},{-7,1},{-5,-3}}; //4.472135955
//		int[][] arr = {{19,-15},  {4,9},  {13,-7},  {-3,-1},  {-10,30}}; //10
		System.out.println(closestPointPair4(arr));
	}
	
	static double closestPointPair(int[][] p) {
		double result = Double.MAX_VALUE;
		for(int i=0; i<p.length-1; i++) {
			for(int j=i+1; j<p.length; j++) {
				double cur = Math.abs(Math.pow(Math.pow(p[i][0] - p[j][0], 2) + Math.pow(p[i][1] - p[j][1], 2), 0.5));
				if(result > cur)
					result = cur;
				
			}
		}
		return result;
	}
	
	static double closestPointPair4(int[][] p) {
	    Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return (int)(Math.abs(o1[0] - o2[0]) + Math.abs(o1[1] - o2[1]));
			}
		});
	    for(int i=0; i<p.length; i++) {
	    	q.add(p[i]);
	    }
	    
	    int[] arr1 = q.poll();
	    int[] arr2 = new int[2];
	    while(!q.isEmpty()) 
	    	arr2 = q.poll();

	    return Math.abs(Math.pow(Math.pow(arr1[0] - arr2[0], 2) + Math.pow(arr1[1] - arr2[1], 2), 0.5));
	}
	
	static double closestPointPair2(int[][] p) {
	    double result = Double.MAX_VALUE;
	    int min = Integer.MAX_VALUE;
	    for(int i=0; i<p.length-1; i++) {
	        for(int j=i+1; j<p.length; j++) {
	            int cur = Math.abs(p[i][0] - p[j][0]) + Math.abs(p[i][1] - p[j][1]);
	            if(min > cur) {
	                min = cur;
	                result = Math.abs(Math.pow(Math.pow(p[i][0] - p[j][0], 2) + Math.pow(p[i][1] - p[j][1], 2), 0.5));
	            }
	            
	        }
	    }
	    return result;
	}
	
	static double closestPointPair3(int[][] p) {
//		double result = Double.MAX_VALUE;
		int min = Integer.MAX_VALUE, minX1=0, minX2=0, minY1=0, minY2=0;
		for(int i=0; i<p.length-1; i++) {
			for(int j=i+1; j<p.length; j++) {
				int cur = Math.abs(p[i][0] - p[j][0]) + Math.abs(p[i][1] - p[j][1]);
				if(min > cur) {
					min = cur;
					minX1 = p[i][0];
					minX2 = p[j][0];
					minY1 = p[i][1];
					minY2 = p[j][1];
				}
				
			}
		}
		return Math.abs(Math.pow(Math.pow(minX1 - minX2, 2) + Math.pow(minY1 - minY2, 2), 0.5));
	}



}
