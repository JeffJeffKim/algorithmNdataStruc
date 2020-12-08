package pro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Group_11723 {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		final String ADD = "add", CHECK = "check", REMOVE = "remove", TOGGLE = "toggle", ALL = "all", EMPTY = "empty";
		ArrayList<Boolean> arrVal = new ArrayList<Boolean>(20);
		for(int i=0; i<20; i++)
			arrVal.add(false);
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		int idx=-1;

		for(int i=0; i<N; i++) {
			String str = sc.next();
			if(!str.equals(ALL) && !str.equals(EMPTY)) 
				idx = sc.nextInt()-1;

			switch(str) {
			case CHECK:
				sb.append((arrVal.get(idx) ? 1 : 0) +"\n");
				break;
			case ADD:
				arrVal.set(idx, true);
				break;
			case REMOVE:
				arrVal.set(idx, false);
				break;
			case TOGGLE:
				arrVal.set(idx, !arrVal.get(idx));
				break;
			case ALL:
				Collections.fill(arrVal, true);
				break;
			case EMPTY:
				Collections.fill(arrVal, false);
				break;
			}
		}
		sc.close();
		System.out.println(sb);
	}

}
