import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
*   Solution to https://www.hackerrank.com/challenges/angry-professor/
*/
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int tests = readInt(in);

        for (int test = 0; test < tests; test++) {
            int[] studentsAndTreshold = readNumbers(in);
            int students = studentsAndTreshold[0];
            int tresh = studentsAndTreshold[1];

            int[] arrivals = readNumbers(in);
            int onTime = 0;

            for (int arrival : arrivals) {
                if (arrival <= 0) onTime++;
            }

            System.out.println(onTime < tresh ? "YES" : "NO");
        }
    }

    private static int readInt(Scanner in) {
        return Integer.parseInt(in.nextLine().trim());
    }

    private static int[] readNumbers(Scanner in) {
        String next = in.nextLine().trim();
        String[] split = next.split("\\s+");

        int[] numbers = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            numbers[i] = Integer.parseInt(split[i].trim());
        }

        return numbers;
    }
}
