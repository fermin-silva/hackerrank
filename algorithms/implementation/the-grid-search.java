import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
*   Solution for https://www.hackerrank.com/challenges/the-grid-search/
*/
public class Solution {
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String G[] = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String P[] = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }

            if (isPresent(G, P)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isPresent(String[] larger, String[] smaller) {
        int smallerIndex = 0;

        for (int i = 0; i < larger.length; i++) {
            int index = larger[i].indexOf(smaller[smallerIndex]);

            if (index != -1) { //found
                boolean found = true;
                smallerIndex++;

                for (int j = i + 1; j < larger.length && smallerIndex < smaller.length; j++, smallerIndex++) {
                    String toFind = smaller[smallerIndex];

                    found &= larger[j].substring(index, index + toFind.length()).equals(toFind);
                }

                if (found) {
                    return true;
                }
                else {
                    smallerIndex = 0; //reset and start again
                }
            }
        }

        return false;
    }
}
