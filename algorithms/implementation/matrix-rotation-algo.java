import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
*   Solution for https://www.hackerrank.com/challenges/matrix-rotation-algo
*/
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] ints = readNumbers(in);
        int rows = ints[0];
        int cols = ints[1];
        int rots = ints[2];

        int[][] matrix = new int[rows][];

        load(matrix, in);

        int submatrices = Math.min(rows, cols) / 2;

        for (int submatrix = 0; submatrix < submatrices; submatrix++) {
            int subrows = rows - 2 * submatrix;
            int subcols = cols - 2 * submatrix;

            int a = subrows + (subcols - 1) + (subrows - 1) + (subcols - 2);

            for (int i = 0; i < rots % a; i++) {
                rotate(matrix, submatrix);
            }
        }

        print(matrix);
    }

    private static void rotate(int[][] m, int offset) {
        int minRow = offset;
        int minCol = offset;
        int maxRow = m.length - offset;
        int maxCol = m[0].length - offset;

        int aux = 0;
        int prev = 0;

        //move left side
        prev = m[minRow][minCol];
        for (int i = 1 + minRow; i < maxRow; i++) {
            aux = m[i][minCol];
            m[i][minCol] = prev;
            prev = aux;
        }

        //move bottom side
        for (int j = 1 + minCol; j < maxCol; j++) {
            aux = m[maxRow - 1][j];
            m[maxRow - 1][j] = prev;
            prev = aux;
        }

        //move right side
        for (int i = maxRow - 2; i >= minRow; i--) {
            aux = m[i][maxCol - 1];
            m[i][maxCol - 1] = prev;
            prev = aux;
        }

        //move top side
        for (int j = maxCol - 2; j >= minCol ; j--) {
            aux = m[minRow][j];
            m[minRow][j] = prev;
            prev = aux;
        }
    }

    private static void load(int[][] matrix, Scanner in) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = readNumbers(in);
        }
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }

            System.out.println();
        }
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
