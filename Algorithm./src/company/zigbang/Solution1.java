package company.zigbang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1 {
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int userCnt = Integer.parseInt(st.nextToken());
		int connCnt = Integer.parseInt(st.nextToken());

		List<String> users = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<userCnt; i++)
			users.add(st.nextToken());
		
		var map = new HashMap<String, ArrayList<String>>();
		for (int i=0; i<connCnt; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			if (map.containsKey(a)) {
				map.get(a).add(b);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(b);
				map.put(a, list);
			}

			if (map.containsKey(b)) {
				map.get(b).add(a);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(a);
				map.put(b, list);
			}
		}
		
		Iterator<String> keys = map.keySet().iterator();
		Node[] nodes = new Node[map.size()];
		int idx = 0;
		while(keys.hasNext()){
			String key = keys.next();
			ArrayList<String> value = map.get(key);
			Node node = new Node(key);
			for(String s : value)
				node.friends.add(s);
			nodes[idx++] = node;
		}
		
		Arrays.sort(nodes, Comparator.comparing(n -> n == null ? -100 : n.friends.size()));
		var checkMap = new HashMap<String, HashSet<String>>();
		int resultCnt = 0;
		String userA="", userB="";
		for (Node node : nodes) {
			if (!checkMap.containsKey(node.user))
				checkMap.put(node.user, new HashSet<>());
//			Collections.sort(curList, Comparator.comparing(l -> map.get(l).size()));
			
			ArrayList<String> noConn = new ArrayList<>();
			for(String s : users) {
				if(!node.friends.contains(s)) {
					if(checkMap.get(node.user).contains(s))
						continue;
					if(s.equals(node.user))
						continue;
					noConn.add(s);
					checkMap.get(node.user).add(s);
					
					if (!checkMap.containsKey(s)) {
						HashSet<String> set = new HashSet<String>();
						set.add(node.user);
						checkMap.put(s, set);
					}
				}
			}
			Collections.sort(noConn, Comparator.comparing(l -> map.get(l) == null ? -1 : map.get(l).size()));
			HashSet<String> curList = node.friends;
			
			for(String cur : noConn) {
				int curDup = 0;
				ArrayList<String> list = map.get(cur);
				if(list == null)
					continue;
				for(String s : list) {
					if(node.friends.contains(s))
						curDup++;
				}
				if(curDup > resultCnt) {
					userA = node.user;
					userB = cur;
					resultCnt = curDup;
				}
			}
		}
		
		bw.write(userA+" "+userB+"\n"+resultCnt);
		
		br.close();
		bw.close();
	}
	
	static class Node {
		String user;
		HashSet<String> friends;
		public Node(String user) {
			this.user = user;
			this.friends = new HashSet<>();
		}
	}

}

/*
7 8
A B C D E P Q
P A
P B
P C
P D
Q B
Q C
Q D
Q E

P Q
3

4 2
RA LW LD JX
LW JX
LD JX

LD LW
1
*/