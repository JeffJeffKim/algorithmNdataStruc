package proEdu.day4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class UnionFind {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static char[] uArr = new char[100];
	
	static void setUnion(char t1, char t2) {
		char a = getFind(t1);
		char b = getFind(t2);
		if(a == b)
			return;
		uArr[b] = a;
	}
	
	private static char getFind(char tar) {
		if(uArr[tar] == 0)
			return tar;
		char ret = getFind(uArr[tar]);
		uArr[tar] = ret;
		return ret;
	}

	public static void main(String[] args) throws IOException {
		setUnion('A', 'B');
		setUnion('D', 'E');
		setUnion('E', 'B');
		
		if(getFind('A') == getFind('B'))
			System.out.println("Same Group");
		else
			System.out.println("Diff Group");
		br.close();
		bw.close();
	}

}
