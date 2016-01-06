import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
*   Solution to https://www.hackerrank.com/challenges/candies
*/
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long children = read(in);

        long[] ratings = new long[(int)children];
        long[] candies = new long[(int)children];

        for (int i = 0; i < children; i++) {
            ratings[i] = read(in);
            candies[i] = 1;
        }

        long total = children; //one per kid

        for (int i = 0; i < candies.length; i++) {
            //kid on the right
            if (i < candies.length - 1 &&
                ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1])
            {
                candies[i]++;
                total++;
                i = Math.max(i - 2, 0);
            }

            //kid on the left
            if (i > 0 &&
                ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1])
            {
                candies[i]++;
                total++;
                i = Math.max(i - 2, 0);
            }
        }

        System.out.println(total);
    }

    private static long read(Scanner in) {
        return Long.parseLong(in.nextLine().trim());
    }
}
