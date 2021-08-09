package company.amazonAudi;

import java.util.Arrays;
import java.util.List;

public class Audi11_2_finalInstances {

	public static void main(String[] args) {
//		System.out.println(Math.pow(10, 8)*2);
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Long.MAX_VALUE);
		List<Integer> list1 = Arrays.asList(5, 6, 30, 5, 4, 8, 19, 89);
		System.out.println(finalInstances(5, list1));
		List<Integer> list2 = Arrays.asList(25, 23, 1, 2,3,4,5,6,7,8,9,10,76,80);
		System.out.println(finalInstances(2, list2)); // ans: 2
		List<Integer> list3 = Arrays.asList(61, 1, 2,3,4,5,6,7);
		System.out.println(finalInstances(100000000, list3));
	}

	public static int finalInstances(int instances, List<Integer> averageUtil) {
		// Write your code here
		final int MAX = 2 * (int)Math.pow(10, 8);
		for (int i=0; i<averageUtil.size()-1; i++) {
			int cur = averageUtil.get(i);

			if (cur < 25) {
				if (instances > 1) {
					if (instances % 2 != 0)
						instances++;
					instances = instances / 2;
					i += 10;
				}
			} else if (cur > 60) {
				if (instances*2 > MAX)
					continue;
				instances *= 2;
				i += 10;
			}

		}

		return instances;
	}
}



/*
https://www.chegg.com/homework-help/questions-and-answers/langu-1-1-autoscale-policy-14-15-1--1-17-18-scaling-computing-system-checks-average-utiliz-q65636338
1. Autoscale Policy 14 15 1 . 1 17 18 A scaling computing system checks its average utilization every second while it monitors. It implements an autoscale policy to increase or reduce instances depending on the current load as described below. Once an action of increasing or reducing the number of instances is performed, the system will stop monitoring for 10 seconds. During that time, the number of instances does not change. 19 20 21 22 23 24 25 26 27 • If the average utilization < 25%, then an action is instantiated to reduce the number of instances by half if the number of instances is greater than 1. Take the ceiling if the number is not an integer. If the number of instances is 1, take no action. • If 25% s average utilization s 60%, take no action. • If the average utilization > 60%, then an action is instantiated to double the number of instances if the doubled value does not exceed 2* 108. If the number of instances exceeds this limit upon doubling, take no action. 28 29 30 31 32 33 > Given an array of integers that represent the average utilization at each second, determine the number of instances at the end of the time frame. Example instances = 2 averageUtil = [25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80) At second 1. the average utilization average Miro = 25 25 Rogala hackerrank.com/test/b5r3qs2406a/questions/1hp11c6d1fa instances at the end of the time frame. sm ft Langua: Example instances = 2 averageUtil = [25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 807 1 > 14 LL 15 16 17 18 19 هه 20 • At second 1, the average utilization averageUtil[0] =25 s 25, so take no action. . At second 2, the average utilization averageUtil[1] = 23 < 25, so reduce the number of instances by half to get 2/2 - 1. • Since an action was taken the system will stop checking for 10 seconds, from averageUtil[2] through averageUtil[11]. • At averageUtil[12] = 76, 76 > 60, so the number of instances is doubled from 1 to 2. 21 1 22 23 24 25 26 There are no more readings to consider and 2 is the final answer. 27 28 Function Description Complete the function finalinstances in the editor below. 29 30 31 } 32 finalinstances has the following parameter(s): int instances: the original number of instances running int averageUtil[n]: the average utilization at each second of the time frame 33 > pub Returns: int: the final number of instances running Constraints . 1 s instances < 105 15n<105 savaramollir 100
 */