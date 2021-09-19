package backjun.graph;

import java.util.Scanner;

public class PermutationCycle {
	static int cnt, arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			inputScan(sc);
			System.out.println(getPermutationCount());
		}
		sc.close();
		
	}
	
	static int getPermutationCount() {
		int result = 0;
		int size = arr.length;
		boolean isVisit[] = new boolean[size];
		for(int i=0; i<size; i++) {
			int nextAddr = arr[i]-1;
			while(!isVisit[nextAddr]) {
				if(isVisit[nextAddr])	break;
				isVisit[nextAddr] = true;
				if(nextAddr == i) {
					result++;
					break;
				}
				nextAddr = arr[nextAddr]-1;
			}
		}
		
		return result;
	}
	
	static void inputScan(Scanner sc) {
		cnt = sc.nextInt();
		arr = new int[cnt];
		for(int i=0; i<cnt; i++) {
			arr[i] = sc.nextInt();
		}
	}

}
