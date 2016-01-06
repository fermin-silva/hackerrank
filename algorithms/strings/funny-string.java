import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
*   Solution to https://www.hackerrank.com/challenges/funny-string/
*/
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int tests = readInt(in);

        for (int i = 0; i < tests; i++) {
            String line = in.nextLine().trim();
            int n = line.length();

            boolean funny = true;

            for (int j = 1; j < n; j++) {
                int a = Math.abs(line.charAt(j) - line.charAt(j - 1));
                int b = Math.abs(line.charAt(n - j) - line.charAt(n - j - 1));

                funny &= a == b;
            }

            System.out.println(funny ? "Funny" : "Not Funny");
        }
    }

    private static int readInt(Scanner in) {
        return Integer.parseInt(in.nextLine().trim());
    }
}
