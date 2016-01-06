import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
*   Solution to https://www.hackerrank.com/challenges/alternating-characters/
*/
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int tests = readInt(in);

        for (int test = 0; test < tests; test++) {
            String line = in.nextLine().trim();
            char[] c = line.toCharArray();

            int n = line.length();

            int deletes = 0;
            for (int i = 0; i < n - 1; i++) {
                if (c[i] == c[i + 1]) {
                    deletes++;
                }
            }

            System.out.println(deletes);
        }
    }

    private static int readInt(Scanner in) {
        return Integer.parseInt(in.nextLine().trim());
    }
}
