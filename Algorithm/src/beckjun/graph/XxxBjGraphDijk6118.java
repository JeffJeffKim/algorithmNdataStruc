package beckjun.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class XxxBjGraphDijk6118 {
	static ArrayList<Integer> map[];
	static int n, INF=Integer.MAX_VALUE, farthest, farthestDist, sameDist; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line[] = in.readLine().split(" ");
		int i, from, to, m = Integer.parseInt(line[1]);
		n = Integer.parseInt(line[0]);
		
		map = new ArrayList[n];
		for(i=0; i<n; i++)	map[i] = new ArrayList<>();
		
		for(i=0; i<m; i++) {
			line = in.readLine().split(" ");
			from = Integer.parseInt(line[0])-1;
			to = Integer.parseInt(line[1])-1;
			map[from].add(to);
			map[to].add(from);
		}
	}
	
	public static void dijkstra(int start) {
		int i, curNode;
		
		Distance dist[] = new Distance[n];
		for(i=0; i<n; i++)	dist[i] = new Distance(i, INF);
		dist[start].dist = 0;
		
		
		
	}
}


