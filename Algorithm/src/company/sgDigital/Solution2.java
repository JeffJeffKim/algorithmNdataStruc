package company.sgDigital;

public class Solution2 {

    public static void main(String[] args) {
//        System.out.println(reproduceString("mprrrrr"));
//        System.out.println(reproduceString("Identity"));
//        System.out.println(reproduceString("Guadalajara is a great Mexican city"));
        System.out.println(reproduceString("aaaaa"));
    }

    static String reproduceString(String fullText) {
        StringBuilder sb = new StringBuilder();
        final char[] arrCheck = {'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u' };
        int vowelCnt = 0;

        for (int i = 0; i < fullText.length(); i++) {
            char cur = fullText.charAt(i);
            boolean isVowel = false;
            if (cur == ' ') {
                continue;
            }

            for (char checking : arrCheck) {
                if (cur == checking) {
                    vowelCnt++;
                    isVowel = true;
                    break;
                }
            }

            if (!isVowel)
                sb.append(cur);
        }

        if (vowelCnt == fullText.length()) {
            return "-";
        }

        return sb.toString();
    }
}
