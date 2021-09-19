package proEdu.day5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class TrainTravel {
	static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int nCount, eCount, map[][], move[];
	
	public static void main(String[] args) throws IOException {
		getInput();
		Queue<Node> q = new PriorityQueue<Node>(Comparator.comparing(n ->  n.cost));
		for(int i=0; i<nCount; i++) {
			if(map[0][i] != 0)
				q.add(new Node(i, map[0][i]));
		}
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int loc = cur.n;
			int cost = cur.cost;
			if(move[loc] <= cost)
				continue;
			move[loc] = cost;
			if(loc == nCount-1)
				break;
			for(int i=0; i<nCount; i++) {
				if(map[loc][i] != 0)
					q.add(new Node(i, cost+map[0][i]));
			}
		}
		if(move[nCount-1] == Integer.MAX_VALUE)
			bw.write("impossible");
		else
			bw.write(move[nCount-1]+"");
		br.close();
		bw.close();
	}
	
	static void getInput() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		nCount = Integer.parseInt(st.nextToken());
		eCount = Integer.parseInt(st.nextToken());
		map = new int[nCount][nCount];
		move = new int[nCount];
		for(int i=0; i<move.length; i++)
			move[i] = Integer.MAX_VALUE;
		for(int i=0; i<eCount; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[s][e] = cost;
		}
	}

}

class Node {
	int n;	int cost;

	public Node(int n, int cost) {
		super();
		this.n = n;
		this.cost = cost;
	}
}
