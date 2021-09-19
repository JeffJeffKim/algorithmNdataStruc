package company.sgDigital;

public class Solution4 {

    public static void main(String[] args) {
        System.out.println(number(27));
        System.out.println(number(512));
        System.out.println(number(48));
    }


    static String number(int input) {
        if (input <= 1) {
            return "no";
        }

        int cube = 0;
        for (int i = 2; i <= 30; i++) {
            if (Math.pow(i, 3) == input) {
                cube = i;
                break;
            }
        }

        if (cube == 0) {
            return "no";
        }

        for (int i = 2; i < cube; i++) {
            if (cube % i == 0) {
                return "no";
            }
        }

        return "yes";
    }



}
