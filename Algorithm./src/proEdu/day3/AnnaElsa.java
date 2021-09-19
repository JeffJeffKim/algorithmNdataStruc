package proEdu.day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class AnnaElsa {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int map1[][], map2[][], sec = 0;
	public static void main(String[] args) throws IOException {
		int size = Integer.parseInt(br.readLine());
		map1 = new int[size][size];
		
		for(int i=0; i<size; i++) {
			String line = br.readLine();
			for(int j=0; j<line.length(); j++) {
				if(line.substring(j, j+1).equals("_")) {
					map1[i][j] = 0;
					map2[i][j] = 0;
				}
				else {
					map1[i][j] =-1;
					map2[i][j] = -1;
				}
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y1 = Integer.parseInt(st.nextToken());
		int x1 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		boolean isMeet = false;
		Queue<Loc> c1 = new ArrayDeque<>();
		Queue<Loc> c2 = new ArrayDeque<>();
		c1.add(new Loc(x1, y1, 0));
		map1[y1][x1] = 1;
		c2.add(new Loc(x2, y2, 0));
		map2[y1][x1] = 1;
		int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}, {0,0}};
		HashSet<Loc> set = new HashSet<>();
		while(!isMeet) {
			sec++;
			while(!c1.isEmpty()) {
				Loc cur = c1.poll();
				int time = cur.time;
				for(int t=0; t<dir.length; t++) {
					int xx = cur.x + dir[t][0];
					int yy = cur.y + dir[t][1];
					if(xx < 0 || yy < 0 || xx >= size || yy >= size)
						continue;
					if(map1[yy][xx] > 0)
						continue;
					map1[yy][xx] = 1;
					Loc next = new Loc(xx, yy, sec);
					c1.add(next);
					set.add(next);
				}
			}
			
			while(!c2.isEmpty()) {
				Loc cur = c2.poll();
				for(int t=0; t<dir.length; t++) {
					int xx = cur.x + dir[t][0];
					int yy = cur.y + dir[t][1];
					if(xx < 0 || yy < 0 || xx >= size || yy >= size)
						continue;
					if(map2[yy][xx] > 0)
						continue;
					map2[yy][xx] = 1;
					Loc next = new Loc(xx, yy, sec);
					c2.add(next);
					if(set.contains(next)) {
						isMeet = true;
						break;
					}
				}
			}
		}
		
		br.close();
		bw.close();
	}
}

class Loc {
	public int x;
	public int y;
	public int time;
	
	public Loc(int x, int y, int time) {
		super();
		this.x = x;
		this.y = y;
		this.time = time;
	}


	@Override
	public String toString() {
		return " [x=" + x + ", y=" + y + ", time=" + time + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + time;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loc other = (Loc) obj;
		if (time != other.time)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
}
