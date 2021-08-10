package company.rakutenKobo;

class Solution {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        //System.out.println(reverse(1234));
        //System.out.println(reverse(1324));
    }

    private static int reverse(int input) {
        int result = 0;
      /*
      123 / 100 = 1
      123 % 100 = 23

      123 % 10 = 3
      123 / 10 = 12

      arr[] = {3, 2, 1}
      */
        int[] arr = new int[20];
        int idx = 0;
        final int divider = 10;
        while (input != 0) { //change
            // input 123, 12, 1
            int remain = input % divider;  //3, 2, 1
            input /= divider;  //12, 1,
            arr[idx++] = remain;
        }

        idx--;
        // idx = 2
        for (int i=idx, j=0; i>=0; i--, j++) {
            result = result + arr[j] * (int)Math.pow(10, i);
        }

        return result;
    }
}
