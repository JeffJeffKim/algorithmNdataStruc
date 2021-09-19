package practice;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

    public static void main(String[] args) {
        System.out.println(getPrimeNumbers(100));
        System.out.println(getPrimeNumbers2(100));
        System.out.println(getPrimeNumbers3(100));
    }

    static List<Integer> getPrimeNumbers3(int n) {
        List<Integer> result = new ArrayList<>();
        boolean[] isDividable = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            if (isDividable[i])
                continue;
            for (int j = 2; j <= n; j++) {
                int num = i*j;
                if (num > n)
                    break;
                isDividable[num] = true;
            }
        }

        for (int i = 2; i <= n; i++) {
            if(!isDividable[i])
                result.add(i);
        }

        return result;
    }

    static List<Integer> getPrimeNumbers2(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(2);
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            int sqrt = (int) Math.ceil(Math.sqrt(i));
            for (int j = 2; j <= sqrt; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                result.add(i);
        }

        return result;
    }

    static List<Integer> getPrimeNumbers(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                result.add(i);
        }

        return result;
    }
}
