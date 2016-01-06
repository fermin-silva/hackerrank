import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
*   Solution to https://www.hackerrank.com/challenges/two-strings/
*/
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int test = readInt(in);

    outer:
        for (int i = 0; i < test; i++) {
            int[] counts = new int[127];

            String a = in.nextLine();
            String b = in.nextLine();

            for (char c : a.toCharArray()) {
                counts[c - 'a']++;
            }

            for (char c : b.toCharArray()) {
                if (counts[c - 'a'] > 0) {
                    System.out.println("YES");
                    continue outer;
                }
            }

            System.out.println("NO");
        }
    }

    private static int readInt(Scanner in) {
        return Integer.parseInt(in.nextLine().trim());
    }
}
