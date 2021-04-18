package proEdu.day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class PQueue {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
		while(n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String type = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			if("push".equals(type)) {
				q.add(num);
			}else if("pop".equals(type)) {
				while(num-- > 0) {
					bw.write(q.poll()+" ");
				}
				bw.write("\n");
			}else {
				q.add(q.poll()+num);
			}
		}
		
		
		br.close();
		bw.close();
	}

}
