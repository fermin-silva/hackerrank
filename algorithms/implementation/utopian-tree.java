import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
*   Solution to https://www.hackerrank.com/challenges/utopian-tree/
*/
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int tests = in.nextInt();

        for (int i = 0; i < tests; i++) {
            int cycles = in.nextInt();
            long total = 1L;

            for (int j = 0; j < cycles; j++) {
                if (j % 2 == 0) {
                    total *= 2;
                }
                else {
                    total += 1;
                }
            }

            System.out.println(total);
        }
    }
}
