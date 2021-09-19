package company.ama202104;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution2_countGroups {
	
//	static int[] group;
	static int[] uArr;
//	static boolean[] bArr;
	static int groupedCnt = 0;
	static int unionCnt = 0;
	
	
	public static void main(String[] args) {
		System.out.println(countGroups(Arrays.asList("1100", "1110", "0110", "0001")));
	}
	
    public static int countGroups(List<String> related) {
    // Write your code here
    	int result = 0;
    	int size = related.size();
    	int[][] map = new int[size][size];
//    	group = new int[size];
    	uArr = new int[size];
//    	Arrays.fill(uArr, val);
//    	bArr = new boolean[size];
    	
    	int lineIdx = -1;
    	for(String line : related) {
    		lineIdx++;
    		for(int i=0; i<line.length(); i++) {
    			map[lineIdx][i] = Integer.parseInt(line.substring(i, i+1));
    		}
    	}
    	
    	for(int i=0; i<size; i++) {
    		for(int j=0; j<size; j++) {
    			if(i == j)
    				continue;
    			
    			if(map[i][j] == 0)
    				continue;
//    			uArr[i] = j;
    			union(i, j);
    		}
    	}
    	if(unionCnt > 0) {
    		result--;
    		
    		HashSet<Integer> set = new HashSet<>();
    		for(int num : uArr) {
    			if(num != 0)
    				set.add(num);
    			else
    				result++;
    		}
    		result += set.size();
    	} 
    	
    	return result;
    }
    
	static int find(int a) {
		if(uArr[a] == 0)
			return a;
		int ret = find(uArr[a]);
		uArr[a] = ret;
		return ret;
	}
	
	static void union (int t1, int t2) {
		int a = find(t1);
		int b = find(t2);
		if(a == b)
			return;
		uArr[b] = a;
//		if(!bArr[a]) {
//			bArr[a] = true;
//			groupedCnt++;
//		}
//		if(!bArr[b]) {
//			bArr[b] = true;
//			groupedCnt++;
//		}
		unionCnt++;
	}

}


/*
https://www.chegg.com/homework-help/questions-and-answers/4-connected-groups-relationships-people-may-represented-matrix-series-binary-digits-exampl-q50864032

Connected Groups Relationships between people may be represented in a matrix as a series of binary digits.
For example, the direct relationships for person with persons O through 5 might be shown as 101100.
This means that person knows persons 0, 2 and 3, the indices of each of the 1 values.
A relationship is transitive. In other words, if person Oknows person 2 and person 2 knows person 3,
then person Oknows person 3 through person 2.
A group is composed of all of the people who know one another, whether directly or transitively.

Example Consider the following relationships matrix: 110 110 001 Persons 0 and 1 are connected,while person 2 is not.
There are 2 groups.
Determine the number of groups represented in a matrix.

Note: The method signatures may vary slightly depending on the requirements of the chosen language.
For example, C language will have an argument that represents the number of rows and columns in the matrix.
Also, Java will receive a list rather than an array.
Function Description Complete the function countGroups in the editor below.
countGroups has the following parameter(s): int related[n]: an array of strings of binary digits related[i]
that represent connections of people Returns: int: an integer that represents the number of groups of people Constraints
• 1sns 300 • Osi<n • related = 1
• Each related[i] contains a binary string of n zeros and ones.
related is a square matrix.
Sample Input STDIN Function 4 → size of related[]
n = 4 related = ['1100', '1110', '110', '0001'] > 1100 1110 0110 0001
Sample Output 2
Explanation Squares highlighting a connection between two people are highlighted in green.
Each of the people is known to self,
so they are highlighted in gray Sample Case o 0 1 2. 3 0 0 1 1 0 1 1 1 1 0 2. 0 0 3 0 0 0 1
There are n = 4 people numbered related[0] through related[3].
There are 2 pairs who directly know each another: (related[0], related[1]) and (related[1], related[2]).
Because a relation is transitive, the set of people {related[0]), related(1), related[2]} is considered a single group.
The remaining person, related[3], does not know any other people and is a separate group: {related[3]}.
There are a total of 2 groups.
 */