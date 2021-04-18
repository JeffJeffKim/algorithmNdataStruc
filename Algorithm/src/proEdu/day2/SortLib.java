package proEdu.day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SortLib {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Node[] arrNode = new Node[tc];
		for(int i=0; i<tc; i++) {
			arrNode[i] = new Node();
			arrNode[i].n = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<tc; i++) {
			arrNode[i].ch = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arrNode, Comparator.comparing(n -> n.n));
		for(Node n : arrNode)
			bw.write(n.n+" ");
		bw.write("\n");
		
		Arrays.sort(arrNode, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o2.n - o1.n;
			}
		});
		for(Node n : arrNode)
			bw.write(n.n+" ");
		Arrays.sort(arrNode, Comparator.comparing(n -> n.ch));
		bw.write("\n");
		
		Arrays.sort(arrNode);
		for(Node n : arrNode)
			bw.write(n.n+" ");
		bw.write("\n");
		for(Node n : arrNode)
			bw.write((char)n.ch+" ");
		
		br.close();
		bw.close();
	}

}

class Node implements Comparable<Node> {
	int n;
	int ch;
	
	public Node() {}
	
	public Node(int n, char ch) {
		this.n = n;
		this.ch = ch;
	}

	@Override
	public int compareTo(Node o) {
		if(o.n%2 == 0) {
			if(this.n > o.n)
				return 10;
			if(this.n < o.n)
				return 8;
			if(this.ch > o.ch)
				return 10;
			if(this.ch < o.ch)
				return 8;
			else
				return 9;
		}else {
			if(this.n > o.n)
				return 1;
			if(this.n < o.n)
				return -1;
			if(this.ch > o.ch)
				return 1;
			if(this.ch < o.ch)
				return -1;
			else
				return 0;
		}
		
//		if(this.n > o.n)
//			return 1;
//		if(this.n < o.n)
//			return -1;
//		if(this.ch > o.ch)
//			return 1;
//		if(this.ch < o.ch)
//			return -1;
//		return 0;
	}

	@Override
	public String toString() {
		return "Node [n=" + n + ", ch=" + ch + "]";
	}
}
