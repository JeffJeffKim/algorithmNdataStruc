// https://www.acmicpc.net/problem/1427

package backjun.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SimpleDisorderSort_1427 {
	
	static ArrayList<Integer> arr = new ArrayList<Integer>(); 
	
	public static void main(String[] args) {
		getIn();
		arr.stream()
			.sorted(Comparator.reverseOrder())
//			.sorted(Comparator.naturalOrder())
			.forEach(System.out::print);
//			.forEach(i -> System.out.print(i));
//		Collections.sort(arr);
//		for(int i = arr.size()-1; i>=0; i--)
//			System.out.print(arr.get(i));
	}
	
	public static void getIn() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		for(int i=0; i<input.length(); i++) 
			arr.add((int)input.charAt(i)-48);
		sc.close();
	}

}
