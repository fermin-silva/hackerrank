import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
* Solution to https://www.hackerrank.com/challenges/find-digits
*/
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int tests = in.nextInt();

        for (int i = 0; i < tests; i++) {
            int n = in.nextInt();
            int orig = n;

            int divisors = 0;

            while (n != 0) {
                int digit = n % 10;

                if (digit != 0 && orig % digit == 0) {
                    divisors++;
                }

                n /= 10;
            }

            System.out.println(divisors);
        }
    }
}
