import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
*   Solution to https://www.hackerrank.com/challenges/sherlock-and-squares
*/
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int tests = in.nextInt();

        for (int i = 0; i < tests; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            //summing the amount of integers between the inverse function
            //from the next int after f-1(a) to the biggest whole int before f-1(b), plus one
            int total = (int)(Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);

            System.out.println(total);
        }
    }
}
