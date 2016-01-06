import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
*   Solution to https://www.hackerrank.com/challenges/extra-long-factorials/
*/
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = readInt(in);

        BigDecimal result = new BigDecimal(1);

        for (int i = n; i > 0; i--) {
            result = result.multiply(new BigDecimal(i));
        }

        System.out.println(result);
    }

    private static int readInt(Scanner in) {
        return Integer.parseInt(in.nextLine().trim());
    }
}
