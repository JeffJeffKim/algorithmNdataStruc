package company.kakao;

import java.util.Arrays;
import java.util.List;

public class Solution3 {
	
	public static void main(String[] args) {
		System.out.println(solution(Arrays.asList(1,3,5), Arrays.asList(2,2,2))); //3
		System.out.println(solution(Arrays.asList(1,3,3,5,7), Arrays.asList(2,2,1,2,1))); //4
		System.out.println(solution(Arrays.asList(1,1,1,1,4), Arrays.asList(10,3,6,4,2))); //2
	}
	
	public static int solution(List<Integer> start_time, List<Integer> running_time) {
	    // Write your code here
		int result = 0;
		Session[] arr = new Session[start_time.size()];
		for(int i=0; i<start_time.size(); i++) {
			arr[i] = new Session(start_time.get(i), start_time.get(i)+running_time.get(i));
		}
		Arrays.sort(arr);
		
		int e = arr[0].end;
		result++;
		
		for(int i=1; i<arr.length; i++) {
			if(e > arr[i].start)
				continue;
			result++;
			e = arr[i].end;
		}
		
		return result;
    }
	
	static class Session implements Comparable<Session>{
		int start;
		int end;
		
		public Session(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Session o) {
			if(o.end > this.end)
				return -1;
			if(o.end < this.end)
				return 1;
			if(o.start > this.start)
				return -1;
			if(o.start < this.start)
				return 1;
			
			return 0;
		}

		@Override
		public String toString() {
			return "[start=" + start + ", end=" + end + "]";
		}
		
	}

}
