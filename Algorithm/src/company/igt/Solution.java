package company.igt;

/*
Given a string of lowercase characters from ‘a’ – ‘z’. We need to write a program to print the characters of this string in sorted order.

Examples:

Input : bbccdefbbaa
Output : aabbbbccdef
 */

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        //
//        char a = 'a';
//        char b = 'b';
//        if (b > a) {
//            System.out.println("b is bigger");
//        } else {
//            System.out.println("b is not bigger");
//        }
//        System.out.println((int)'a');
//        System.out.println((int)'z');
//
//        System.out.println((char)97); //
        System.out.println(getSorted("bbccdefbbaa"));
    }

    static public String getSorted(String inputStr) {
        StringBuffer sb = new StringBuffer();
        int[] letters = new int[26];

        for (int i = 0; i < inputStr.length(); i++) {
            char c = inputStr.charAt(i-97);
            letters[c]++;
        }

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > 0) {
                char c = (char) (i+97);
                int count = letters[i];
                while (count-- > 0) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}
