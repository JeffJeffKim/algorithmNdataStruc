package company.localCoin;

import java.util.LinkedHashMap;

public class Solution2 {

    public static void main(String[] args) {
//        int empty = ' ';
//        System.out.println("empty = " + empty);
//        int a = 'A'; // 65
//        int z = 'Z'; // 90
//        int aa = 'a'; //97
//        int zz = 'z'; // 122
//        System.out.println("a = " + a);
//        System.out.println("z = " + z);
//        System.out.println("aa = " + aa);
//        System.out.println("zz = " + zz);
//        int exc = '!';
//        System.out.println("exc = " + exc);//33
//        int hypen = '-';
//        int period = '.';
//        int comma = ',';
//        int question = '?';
//        System.out.println("hypen = " + hypen); // 44
//        System.out.println("period = " + period); // 45
//        System.out.println("comma = " + comma); // 46
//        System.out.println("question = " + question); //63
//
//        int num1 = '1';
//        System.out.println("num1 = " + num1);
//        System.out.println(howMany("akf dhj ds 878  dwa WE DE 7475 dsfh ds  RAMU 748 dj."));
//        System.out.println(howMany("jds dsaf lkdf kdsa fkldsf, adsbf ldka ads? asd bfdal ds bf[l. akf dhj ds 878  dwa WE DE 7475 dsfh ds  RAMU 748 dj."));
        System.out.println(howMany("n? O, A? ir! FhL  gmaMbo? IQtz  Nx  rkQ?  17E? Fl-TX! P (n  r   745yDs  E 4y (bPg 1Vs, KGz-jgE 92lFDOLTE. cvuXh 5IL-h 6VN. Nqz  G. KsUj (k, Hjh 4j, q-Edw 2e,  )C  v-zyt-T 0q. BVrKLW 3u, B! Cz }DGZe-mn-jcw! hT! V? ySyJ 1k. wo. V 9wI  oR!  0JD. GLKSBUB 3Eyyg )Lft  oTHbC! apSa! ujCw, Es  z )ITnWSk. nn, w 1O-xmsw  JcB. ct? lSv {HpYTM? Mc 7C (lhM.  }G {J, w [IChoXO 6dbUgKs? MLr? o 17Q! fFh [(3x. CaGQhQ  akej }p.  (g? teS. B 8qKS )n ]E-HQ,  5Mm 2qX )xiYUO! DZ! cB! G-WZ  cZc, JqpdPEpC {d, Ce, m,  8b? HH 8W 68EM, sJ-VsgDo-u 4C   5U 5mMr ]s 1tMu 8GP 7b-MW-d 6w! v 4Vu 9mBV 58vyO? uxQa [xZ! P. DA! xNr 4nl?  5n  ElH! O 4QvCf. i 30tN 8bM 6y  Yei! jsxT-a 3CEy 5KMLYdg! L 7D 1xxQViNT. rucIiius  o? r, H {1aH 0g  is 9C 3olX }P? azL-ICWgwrC! tv [FIt?  1lF (m 9zrcAfSwNjetRkc [(DSqN. yfa. uu 6BiL (L (r 0Fo 7{hJ {Py   )4JH 14oWKQdI }L )2)PZz.  5(U. BreAl 8B-pYHla! O 6rEzI?  9LDwB! aG? F-OqB (6s-cu? Zx (cZ )xv. bkdBuPZR 2Gij 2hQ 60jV 9FukJPhQc )R 9ztytQ!  ]l 6(a, S? I  b {tS,  (s, u 6)P-irIWA-vj? O, e 8")); //ans 91
    }

    public static int howMany(String sentence) {
        int result = 0;

        String[] words = sentence.split(" ");
        for (String word : words) {
            word = word.trim();
            if (word.isEmpty())
                continue;
            if(isValuable(word)) {
                System.out.println("word = " + word);
                result++;
            }
        }

        return result;
    }

    static boolean isValuable(String word) {
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i);

            if (i == word.length() - 1) {
                if ((65 <= c && c <= 90) || (97 <= c && c <= 122) || c == 44 || c == 46 || c == 63 || c == 33) {
                    return true;
                }
                return false;
            } else if (i != 0) {
                if ((65 <= c && c <= 90) || (97 <= c && c <= 122) || c == 45) {
                    continue;
                }
                return false;
            } else {
                if ((65 <= c && c <= 90) || (97 <= c && c <= 122) ) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
