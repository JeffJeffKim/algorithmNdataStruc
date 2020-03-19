// https://www.acmicpc.net/problem/10814

package backjun.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OrderAndMultiple_18114 {
	
	static int N;
	static ArrayList<Integer> arrA = new ArrayList<Integer>(), arrB = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		getIn();
		
		arrA = (ArrayList<Integer>) arrA.stream()
				.sorted(Comparator.naturalOrder())
				.collect(Collectors.toList());
		arrB = (ArrayList<Integer>) arrB.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		
		int result = 0;
		for(int i=0; i<N; i++)
			result += arrA.get(i) * arrB.get(i);
		
		System.out.println(result);
	}
	
	static void getIn() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=0; i<N; i++)
			arrA.add(sc.nextInt());
		for(int i=0; i<N; i++)
			arrB.add(sc.nextInt());
		sc.close();
	}

}
