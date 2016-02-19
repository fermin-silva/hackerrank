import java.util.Scanner;

/**
 * Solution to https://www.hackerrank.com/challenges/count-luck
 * Created by Fermin on 19/2/16.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int tests = nextInt(in);

        for (int t = 0; t < tests; t++) {
            solve(in);
        }
    }

    private static int[] nextNumbers(Scanner in) {
        String[] strings = in.nextLine().split(" ");
        int[] nums = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }

        return nums;
    }

    private static int nextInt(Scanner in) {
        return Integer.parseInt(in.nextLine());
    }

    public static final int EMPTY = 0;
    public static final int HASTREE = 1;
    public static final int VISITED = 2;

    private static void solve(Scanner in) {
        int[] size = nextNumbers(in);
        int[][] m = new int[size[0]][size[1]];

        int exitRow = 0, exitCol = 0, startRow = 0, startCol = 0;

        for (int i = 0; i < size[0]; i++) {
            char[] chars = in.nextLine().toCharArray();

            for (int j = 0; j < chars.length; j++) {
                switch (chars[j]) {
                    case '.': m[i][j] = EMPTY; break;
                    case 'X': m[i][j] = HASTREE; break;
                    case 'M': m[i][j] = EMPTY; startRow = i; startCol = j; break;
                    case '*': m[i][j] = EMPTY; exitRow = i; exitCol = j; break;
                }
            }
        }

        int k = nextInt(in);

        int choices = solve(m, startRow, startCol, exitRow, exitCol, 0);

        System.out.println(k == choices ? "Impressed" : "Oops!");
    }

    private static int solve(int[][] m, int startR, int startC, int endR, int endC, int totalChoices) {
        m[startR][startC] = VISITED;

        if (startR == endR && startC == endC) {
            //got to the end, return valid route
            return totalChoices;
        }

        int up = startR > 0 ? m[startR - 1][startC] : -1;
        int down = startR < m.length - 1 ? m[startR + 1][startC] : -1;
        int left = startC > 0 ? m[startR][startC - 1] : -1;
        int right = startC < m[0].length - 1 ? m[startR][startC + 1] : -1;

        int choices = 0;

        if (up == EMPTY) { choices++; }

        if (down == EMPTY) { choices++; }

        if (left == EMPTY) { choices++; }

        if (right == EMPTY) { choices++; }

        if (choices == 0) {
            return 0; //dead end, discard totalChoices
        }
        else if (choices > 1) {
            //more than one available path, so wave the magic wand
            totalChoices++;
        }

        return (up == EMPTY ? solve(m, startR - 1, startC, endR, endC, totalChoices) : 0) +
               (down == EMPTY ? solve(m, startR + 1, startC, endR, endC, totalChoices) : 0) +
               (left == EMPTY ? solve(m, startR, startC - 1, endR, endC, totalChoices) : 0) +
               (right == EMPTY ? solve(m, startR, startC + 1, endR, endC, totalChoices) : 0);
    }
}
