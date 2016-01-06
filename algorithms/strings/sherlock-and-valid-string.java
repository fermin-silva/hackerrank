import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
*   Solution to https://www.hackerrank.com/challenges/sherlock-and-valid-string/
*/
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        int[] freq = new int['z' - 'a' + 1];

        char[] chars = s.toCharArray();

        for (char c : chars) {
            freq[c - 'a']++;
        }

        boolean sameFreq = sameFreq(freq);

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                freq[i]--;

                if (sameFreq(freq)) {
                    sameFreq = true;
                }

                freq[i]++;
            }
        }

        System.out.println(sameFreq ? "YES" : "NO");
    }

    private static boolean sameFreq(int[] arr) {
        boolean same = true;
        int freq = arr[0];

        for (int i = 0; i < arr.length && same; i++) {
            if (arr[i] != 0) {
                same &= freq == arr[i];
            }
        }

        return same;
    }
}
