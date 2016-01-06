import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
*   Solution to https://www.hackerrank.com/challenges/kaprekar-numbers
*/
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int lower = in.nextInt();
        int upper = in.nextInt();
        boolean found = false;

        StringBuilder sb = new StringBuilder();

        for (long i = lower; i <= upper; i++) {
            String s = Long.toString(i * i);
            int middle = s.length() / 2;

            int left = middle > 0 ? Integer.parseInt(s.substring(0, middle)) : 0;
            int right = Integer.parseInt(s.substring(middle, s.length()));

            if (i == left + right) {
                sb.append(i).append(" ");
                found = true;
            }
        }

        if (!found) {
            System.out.println("INVALID RANGE");
        }
        else {
            sb.setLength(sb.length() - 1); //remove trailing space
            System.out.println(sb);
        }
    }
}
