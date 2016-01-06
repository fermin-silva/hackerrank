import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
*   Solution to https://www.hackerrank.com/challenges/sherlock-and-the-beast/
*/
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int tests = readInt(in);

        for (int test = 0; test < tests; test++) {
            int n = readInt(in);

            int fives = n / 3;
            while (fives > 0 &&
                  (n - (3 * fives)) % 5 != 0)
            {
                fives--;
            }

            int threes = n - (fives * 3);

            if (threes % 5 != 0) {
                System.out.println("-1");
            }
            else {
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < fives * 3; i++) {
                    sb.append("5");
                }

                for (int i = 0; i < threes; i++) {
                    sb.append("3");
                }

                System.out.println(sb);
            }
        }
    }

    private static int readInt(Scanner in) {
        return Integer.parseInt(in.nextLine().trim());
    }
}
