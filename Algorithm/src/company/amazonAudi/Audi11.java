package company.amazonAudi;

import java.util.Arrays;
import java.util.List;

public class Audi11 {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(5, 6, 30, 5, 4, 8, 19, 89);
		System.out.println(finalInstances(5, list1));
		List<Integer> list2 = Arrays.asList(25, 23, 1, 2,3,4,5,6,7,8,9,10,76,80);
		System.out.println(finalInstances(2, list2));
		List<Integer> list3 = Arrays.asList(61, 1, 2,3,4,5,6,7);
		System.out.println(finalInstances(100000000, list3));
	}

	public static int finalInstances(int instances, List<Integer> averageUtil) {
		// Write your code here
		int noMoniSec = 0;
		boolean isMoni = false;
		for (int i = 0; i < averageUtil.size(); i++) {
//			if (isMoni) {
//				if (noMoniSec >= 9) {
//					noMoniSec = 0;
//					isMoni = false;
//				} else {
//					noMoniSec++;
//				}
//				continue;
//			}

			int cur = averageUtil.get(i);

			if (cur < 25) {
				if (instances < 2)
					continue;
				i += 10;
                if(instances % 2 != 0)
                    instances += 1;
                instances /= 2;
			} else if (cur > 60) {
				if (instances <= 100000000) {
					instances *= 2;
				}
				i += 10;
			}
		}
		return instances;
	}
}
