package company.sgDigital;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(acronym(new String[]{"Zone", "Impro", "Plan"}));
        System.out.println(acronym(new String[]{"What", "You", "See", "IS", "What"}));
        System.out.println(acronym(new String[]{"Back", "to", "the", "Future"}));
        System.out.println(acronym(new String[]{"DataBasZ"}));
        System.out.println(acronym(new String[]{"kitchen"}));
    }

    static String acronym(String[] input) {
        StringBuilder sb = new StringBuilder();

        if (input.length == 1) {
            int cntUpper = 0;
            for (int i = 0; i < input[0].length(); i++) {
                char c = input[0].charAt(i);
                int aCode = c;

                if (aCode >= 65 && aCode <= 65 + 26) {
                    sb.append(c).append(".");
                    cntUpper++;
                }
            }

            if (cntUpper == 0)
                return input[0].substring(0, 1).toUpperCase();

            return sb.toString().substring(0, sb.length()-1);
        } else {
//            char prev = ' ';
            boolean isFirstLow = true;
            for (String s : input) {
                char c = s.charAt(0);
                int aCode = c;
                if (aCode > 65 + 26) {
                    if(!isFirstLow){
                        continue;
                    }
                    isFirstLow = false;
                }
//                if (c == prev)
//                    continue;
//                prev = c;
                sb.append(String.valueOf(c).toUpperCase()).append(".");
            }
            return sb.toString().substring(0, sb.length()-1);
        }
    }
}
