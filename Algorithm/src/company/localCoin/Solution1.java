package company.localCoin;

import java.util.HashSet;
import java.util.LinkedHashMap;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(getUniqueCharacter("hackthegame"));
        System.out.println(getUniqueCharacter("statistics"));
        System.out.println(getUniqueCharacter("falafal"));
    }

    public static int getUniqueCharacter(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i+1);
            }
        }

        int result = -1;
        for (Character c : map.keySet()) {
            if (map.get(c) != -1) {
                result = map.get(c);
                break;
            }
        }

        return result;
    }
}
