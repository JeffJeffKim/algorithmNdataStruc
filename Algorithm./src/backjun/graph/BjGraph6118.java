package backjun.graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BjGraph6118 {
	static int cntLoc;
	static boolean map[][];
	static int dist, cntSol;
	static int sameDist[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cntLoc = sc.nextInt(); 
		int cntPath = sc.nextInt(), inS, inE;
		map = new boolean[cntLoc+1][cntLoc+1];
		for(int i=0; i<cntPath; i++) {
			inS = sc.nextInt(); inE = sc.nextInt();
			map[inS][inE] = true;	map[inE][inS] = true;
		}
		sc.close();
		bfs();
		output();
	}
	
	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		boolean visit[] = new boolean[cntLoc+1];
		visit[1] = true;
		int multi=100000;
		q.add(1*multi);
		sameDist = new int[cntLoc];
		
		boolean alreadyChk=false, changedLev=false;
		int n, curCnt=0, beforeDiv, level, preLev=-1;
		boolean find;
		while(!q.isEmpty()) {
			beforeDiv = q.poll();
			n = beforeDiv/multi;	
			level=beforeDiv%multi;
			
			if(preLev != level) {
				preLev=level;
				curCnt=0; 
				alreadyChk=false;
				if(changedLev)	sameDist = new int[cntLoc];
			}
			changedLev=false;
			find=false;
			
			for(int i=1; i<=cntLoc; i++) {
				if(!visit[i]) {
					if(map[n][i]) {
						visit[i]=true;
						find=true;
						sameDist[curCnt++]=i;
						q.add(i*multi + level+1);
					}
				}
			}
			if(find) {	// ������ loop���� ã������ ������
				if(!alreadyChk) {
					cntSol++;
					changedLev=true;
					alreadyChk=true;
				}
				int visitCnt=0;
				for(int i=1; i<=cntLoc; i++) {
					if(visit[i]) visitCnt++;	
				}
				if(visitCnt == cntLoc)	break;
			}
		}
	}
	
	static void output() {
		int minLoc=Integer.MAX_VALUE, cntSameDist=0;
		for(int i=0;i<=cntSol;i++) {
			if(sameDist[i] != 0) {
				cntSameDist++;
				if(minLoc>sameDist[i]) {
					minLoc = sameDist[i];
				}
			}
		}
		System.out.println(minLoc+" "+cntSol+" "+cntSameDist);
	}
}

