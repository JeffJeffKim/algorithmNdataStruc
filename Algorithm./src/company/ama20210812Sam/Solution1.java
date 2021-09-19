package company.ama20210812Sam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(chooseFleets(Arrays.asList(6,3,2))); // 2, 0, 1
        System.out.println(chooseFleets(Arrays.asList(10, 4, 11))); //3, 2, 0
    }

    /*
     * Complete the 'chooseFleets' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY wheels as parameter.
     */

    public static List<Integer> chooseFleets(List<Integer> wheels) {
        List<Integer> result = new ArrayList<>();

        for (int wheel : wheels) {
//            int cnt = 0;
            if (wheel % 2 != 0) {
                result.add(0);
                continue;
            }

            if (wheel == 2) {
                result.add(1);
                continue;
            }

//            cnt = wheel/4*2;
            result.add(wheel/4+1);
        }

        return result;
    }
}
