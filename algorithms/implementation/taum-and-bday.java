import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
*   Solution to https://www.hackerrank.com/challenges/taum-and-bday/
*/
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long tests = read(in);

        for (int i = 0; i < tests; i++) {
            long[] bw = readNumbers(in);
            long black = bw[0];
            long white = bw[1];

            long[] xyz = readNumbers(in);
            long costBlack = xyz[0];
            long costWhite = xyz[1];
            long convertCost = xyz[2];

            System.out.println(solve(black, white, costBlack, costWhite, convertCost));
        }
    }

    private static long solve(long b, long w, long costB, long costW, long convertCost) {
        if (costB > costW + convertCost) {
            //buy all whites
            return w * costW + b * (costW + convertCost);
        }
        else if (costW > costB + convertCost) {
            //buy all blacks
            return b * costB + w * (costB + convertCost);
        }
        else {
            //buy b + w without conversion
            return b * costB + w * costW;
        }
    }

    private static long read(Scanner in) {
        return Long.parseLong(in.nextLine().trim());
    }

    private static long[] readNumbers(Scanner in) {
        String next = in.nextLine().trim();
        String[] split = next.split("\\s+");

        long[] numbers = new long[split.length];

        for (int i = 0; i < split.length; i++) {
            numbers[i] = Integer.parseInt(split[i].trim());
        }

        return numbers;
    }
}
