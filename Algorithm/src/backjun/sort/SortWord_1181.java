package backjun.sort;

// https://www.acmicpc.net/problem/1181

import java.util.ArrayList;
import java.util.Scanner;

public class SortWord_1181 {
	
	static int N;
	static ArrayList<String> arr = new ArrayList<>();
	
	public static void main(String[] args) {
		getIn();
		arr.stream()
			.sorted((a,b) -> {
				if(a.length() == b.length())
					return a.compareTo(b);
				else
					return a.length() - b.length();
			})
//			.sorted((a,b) -> a.length() - b.length())
			.forEach(System.out::println);
	}
	
	public static void getIn() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<N; i++)
			arr.add(sc.nextLine());
		sc.close();
	}

}
