import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
*   Solution to https://www.hackerrank.com/challenges/coin-change/
*/
public class Solution {

    private static long[][] cache;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] sizes = readNumbers(in);
        int amount = sizes[0];
        int coinTypes = sizes[1];

        int[] coins = readNumbers(in);
        Arrays.sort(coins);

        cache = new long[amount + 1][coins.length + 1];

        System.out.println(combs(coins, coins.length, amount, ""));
    }

    private static long combs(int[] coins, int n, int amount, String pattern) {
        if (n == 0) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        if (amount < 0) {
            return 0;
        }

        if (cache[amount][n] != 0) {
            return cache[amount][n];
        }

        int lastCoin = coins[n - 1];
        int[] coinsHead = Arrays.copyOf(coins, coins.length - 1);

        long combs = combs(coins, n, amount - lastCoin, pattern + lastCoin) + //combs that make use of last coin (thus amount reduced)
                     combs(coinsHead, n - 1, amount, pattern); //combs that don't use the last coin

        cache[amount][n] = combs;

        return combs;
    }

    private static int[] readNumbers(Scanner in) {
        String next = in.nextLine();
        String[] split = next.split(" ");

        int[] numbers = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            numbers[i] = Integer.parseInt(split[i]);
        }

        return numbers;
    }
}
