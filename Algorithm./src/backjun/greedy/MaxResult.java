package backjun.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxResult {

    /**
     * only multiply and add
     */
    public int getMaxResult(int[] arr) {
        int result = 0;
        List<Integer> pArr = new ArrayList<>();
        int zeroCnt = 0;
        List<Integer> nArr = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                nArr.add(arr[i]);
            } else if (arr[i] == 0) {
                zeroCnt++;
            } else {
                pArr.add(arr[i]);
            }
        }

//        Collections.reverse(pArr);
        pArr.sort(Collections.reverseOrder());
//        Collections.sort(pArr, Collections.reverseOrder());
        Collections.sort(nArr);

        // positive
        for (int i = 0; i < pArr.size() - 1; i += 2) {
            if (pArr.get(i + 1) == 1) {
                result += pArr.get(i) + pArr.get(i+1);
            } else {
                result += pArr.get(i) * pArr.get(i + 1);
            }
        }

        if (pArr.size() % 2 == 1) {
            result += pArr.get(pArr.size() - 1);
        }


        // negative
        for (int i = 0; i < nArr.size() - 1; i += 2) {
            result += nArr.get(i) * nArr.get(i + 1);
        }

        if (nArr.size() % 2 == 1) {
            if (zeroCnt == 0) {
                result += nArr.get(pArr.size() - 1);
            } else {

            }
        }

        return result;
    }
}
//        for (int i = 0; i < arr.length - 1; i += 2) {
//
//            if (arr[i] < 0 && arr[i + 1] < 0) {
//                result += arr[i] * arr[i + 1];
//            } else if (arr[i] < 0 && arr[i+1] == 0) {
//                // nothing == result += (arr[i] * 0);
//            } else if (arr[i] < 0 && arr[i+1] > 0) {
//                result += arr[i] + arr[i + 1];
//            } else if (arr[i] == 0 && arr[i + 1] == 0) {
//                // nothing == result += (arr[i] * arr[i + 1]);
//            } else if (arr[i] == 0 && arr[i + 1] > 0) {
//                result += arr[i] + arr[i + 1];
//            } else if (arr[i] > 0 && arr[i + 1] > 0) {
//                if (arr[i] == 1) {
//                    result += arr[i] + arr[i + 1];
//                } else {
//                    result += (arr[i] * arr[i + 1]);
//                }
//            }
//
//        }
