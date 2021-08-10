package company.ama202104;

import java.util.*;

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
    	int cSize = related.get(0).length();
    	int[][] map = new int[size][cSize];

		for (int r = 0; r < related.size(); r++) {
			String row = related.get(r);
			for (int i = 0; i < row.length(); i++) {
				map[r][i] = Integer.parseInt(row.substring(i, i + 1));
			}
		}

		Queue<int[]> q = new ArrayDeque<>();
		int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -2}};
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				if (map[y][x] == 1) {
					q.add(new int[]{y, x});
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						int r = cur[0];
						int c = cur[1];
						map[r][c] = 0;

						for (int d = 0; d < dir.length; d++) {
							int rr = r + dir[d][0];
							int cc = c + dir[d][1];
							if(rr < 0 || cc < 0 || rr >= map.length || cc >= map[0].length)
								continue;

							if (map[rr][cc] == 1) {
								q.add(new int[]{rr, cc});
							}
						}
					}

					result++;
				}
			}
		}

    	return result;
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