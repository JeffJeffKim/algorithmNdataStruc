package company.sgDigital;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(substrings("three lions and threelionesses"));
        System.out.println(substrings("BatMan vs SuperMan vs WonderWoman"));
    }

    static int substrings(String input) {
        int result = 0;

        input = input.replace(" ", "");
        for (int i = 0; i < input.length() - 4; i++) {
            String str = input.substring(i, i + 4);
            if (input.substring(i + 4).contains(str)) {
                result++;
            }

        }

        return result;
    }
}
