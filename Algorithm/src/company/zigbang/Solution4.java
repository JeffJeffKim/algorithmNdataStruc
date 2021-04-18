package company.zigbang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean dat[];
	static Node top = new Node(1);
	static HashMap<Integer, ArrayList<Integer>> link = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int wellCnt = Integer.parseInt(st.nextToken());
		int qCnt = Integer.parseInt(st.nextToken());
		link.put(1, new ArrayList<Integer>());
		dat = new boolean[wellCnt+1];
		
		for(int i=1; i<wellCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			if(num1 == 1 || num2 == 1) {
				if(num1 == 1)
					link.get(1).add(num2);
				else
					link.get(1).add(num1);
			} else {
				if(!link.containsKey(num1))
					link.put(num1, new ArrayList<>());
				link.get(num1).add(num2);
				if(!link.containsKey(num2))
					link.put(num2, new ArrayList<>());
				link.get(num2).add(num1);
			}
		}
		
		setTree(top, 0, 1);
		
		
		while(qCnt-- > 0) {
			st = new StringTokenizer(br.readLine());
			int query = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			if(query == 1) {
				Node sNode = findWell(top, idx);
				setWater(sNode);
			}else if(query == 2) {
				removeWater(top, idx);
			}else if(query == 3) {
				if(dat[idx])
					bw.write("1\n");
				else
					bw.write("0\n");
			}else {
				// error
			}
		}
		
		br.close();
		bw.close();
	}
	
	static boolean removeWater(Node node, int idx) {
		if(node.num  == idx)
			return true;
		for(Node sub : node.sub) {
			if(sub.num == idx) {
				sub.isFull = false;
				dat[sub.num] = false;
				return true;
			}
			if(removeWater(sub, idx)) {
				sub.isFull = false;
				dat[sub.num] = false;
				return true;
			}
				
		}
		return false;
	}
	
	static Node findWell(Node node, int idx) {
		if(node.num == idx)
			return node;
		for(Node sub : node.sub) {
			if(sub.num == idx)
				return sub;
			else
				return findWell(sub, idx);
		}
		return null;
	}
	
	static void setWater(Node node) {
		node.isFull = true;
		dat[node.num] = true;
		for(Node sub : node.sub)
			setWater(sub);
	}
	
	static void setTree(Node node, int father, int idx) {
		ArrayList<Integer> list = link.get(idx);
		for(int num : list) {
			if(father == num)
				continue;
			Node sub = new Node(num);
			node.sub.add(sub);
			setTree(sub, idx, num);
		}
	}
	
	static class Node  {
		int num;
		boolean isFull;
		ArrayList<Node> sub;
		public Node(int num) {
			this.num = num;
			this.sub = new ArrayList<>();
		}
	}

}

/*
4 7
3 4
2 3
2 1
2 3
3 1
3 1
3 3
2 4
3 4
2 4

8 5
8 1
8 4
5 6
7 3
2 5
3 6
4 7
2 2
3 2
1 4
3 7
1 1
*/