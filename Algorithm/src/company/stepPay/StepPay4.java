package company.stepPay;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class StepPay4 {

    static public int solution(int[][] maps) {
        //0 = wall, 1 = path
    	int answer = -1;
    	int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    	final int ty = maps.length-1;
    	final int tx = maps[0].length-1;
    	Queue<Node> q = new PriorityQueue<Node>(Comparator.comparing(n -> n.d));
    	q.add(new Node(0, 0, 1));
    	maps[0][0] = 0;
    	
    	Node node;
    	while(!q.isEmpty()) {
    		node = q.poll();
    		if(node.x == tx && node.y == ty) {
    			answer = node.d;
    			break;
    		}
    		
    		for(int i=0; i<dir.length; i++) {
    			int nx = node.x + dir[i][1];
    			int ny = node.y + dir[i][0];
    			if(nx<0 || ny<0 || nx>tx || ny>ty)
    				continue;
    			if(maps[ny][nx] == 0)
    				continue;
    			maps[ny][nx] = 0;
    			q.add(new Node(nx, ny, node.d+1));
    		}
    	}
        
        return answer;
    }
    
    static class Node {
    	int x;
    	int y;
    	int d;
		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + ", d=" + d + "]";
		}
		
    }
    
	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
		System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
		
		System.out.println(solution(new int[][]{{1,0}}));
		System.out.println(solution(new int[][]{{1,1}}));
		System.out.println(solution(new int[][]{{1},{1}}));
	}

}
