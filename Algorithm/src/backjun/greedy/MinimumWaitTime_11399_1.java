package backjun.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//https://www.acmicpc.net/problem/11399

public class MinimumWaitTime_11399_1 {
	
	public static void main(String[] args) {
		List<Integer> list = getInput();
		sort(list);
		System.out.println(getSum(list));
	}
	
	static int getSum(List<Integer> list) {
		int result = 0, priv = 0;
		for(int i: list) {
			priv += i;
			result += priv;
		}
		return result;
	}
	
	static void sort(List<Integer> arg) {
		Collections.sort(arg);
	}
	
	static List<Integer> getInput() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> list = new ArrayList<>(N);
		for(int i=0; i<N; i++)
			list.add(sc.nextInt());
		sc.close();
		return list;
	}

}
