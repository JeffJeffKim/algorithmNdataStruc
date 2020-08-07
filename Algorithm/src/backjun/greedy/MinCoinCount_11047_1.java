package backjun.greedy;
//https://www.acmicpc.net/problem/11047
import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MinCoinCount_11047_1 {
	static int price;
	
	public static void main(String[] args) {
		List<Integer> list = getInput();
//		sort(list);
		System.out.println(getCount(list));
	}
	
	static int getCount(List<Integer> list) {
		int count=0, idx=list.size()-1;
		while(price > 0) {
			while(price < list.get(idx)) 
				idx--;
			price -= list.get(idx);
			count++;
		}
		return count;
	}
	
//	static void sort(List<Integer> list) {
//		Collections.sort(list, Collections.reverseOrder());
//	}
	
	static List<Integer> getInput() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		price = sc.nextInt();
		List<Integer> list = new ArrayList<>(N);
		for(int i=0; i<N; i++)
			list.add(sc.nextInt());
		sc.close();
		return list;
	}

}
