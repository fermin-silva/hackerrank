import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
*   Solution to https://www.hackerrank.com/challenges/bfsshortreach/
*/
public class Solution {

    public static final int DIST = 6;

    private static long[][] cache;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int tests = readInt(in);

        for (int test = 0; test < tests; test++) {
            int[] nm = readNumbers(in);
            int nodes = nm[0];

            int[][] m = new int[nodes][nodes];

            int edges = nm[1];

            for (int i = 0; i < edges; i++) {
                int[] edge = readNumbers(in);

                m[edge[0] - 1][edge[1] - 1] = 1; //-1 to make it zero based
                m[edge[1] - 1][edge[0] - 1] = 1;
            }

            int start = readInt(in) - 1; //-1 to make it zero based

            printDistances(m, start);
        }

        System.out.println();
    }

    private static void printDistances(int[][] con, int start) {
        boolean[] open = new boolean[con.length];
        int[] dist = new int[con.length]; Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        open[start] = true;
        int openSize = 1;

        while (openSize > 0) {
            int minIndex = getMin(dist, open);
            open[minIndex] = false;
            openSize--;

            for (int i = 0; i < con.length; i++) {
                if (minIndex != i && con[minIndex][i] != 0) { //this node has connection with the ith node
                    if (dist[minIndex] + DIST < dist[i]) { //the distance going through minIndex node is shorter
                        open[i] = true; //put the node back to open list
                        openSize++;

                        dist[i] = dist[minIndex] + DIST; //update the distance
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            if (i != start) {
                System.out.print(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
                System.out.print(" ");
            }
        }

        System.out.println();
    }

    private static int getMin(int[] dist, boolean[] open) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < dist.length; i++) {
            if (open[i]) {
                if (dist[i] < minValue) {
                    minValue = dist[i];
                    minIndex = i;
                }
            }
        }

        return minIndex;
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
