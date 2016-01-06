import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
*   Solution to https://www.hackerrank.com/challenges/the-time-in-words
*/
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int h = in.nextInt();
        int m = in.nextInt();

        String hour = "";
        String minutes = "";
        boolean minsFirst = true;
        boolean increaseHour = false;
        
        if (m == 0) {
            minutes = "o' clock";
            minsFirst = false;
        }
        else if (m == 1) {
            minutes = toWord(m).trim() + " minute past";
        }
        else if (m > 1 && m < 30 && m != 15) {
            minutes = toWord(m).trim() + " minutes past";
        }
        else if (m == 15) {
            minutes = "quarter past";
        }
        else if (m == 30) {
            minutes = "half past";
        }
        else if (m == 45) {
            minutes = "quarter to";
            increaseHour = true;
        }
        else if (m < 59){
            minutes = toWord(60 - m).trim() + " minutes to";
            increaseHour = true;
        }
        else {
            minutes = toWord(60 - m).trim() + " minute to";
            increaseHour = true;
        }
        
        if (increaseHour) {
            h++;
            if (h > 12) {
                h = 1;
            }
        }

        switch (h) {
            default: hour = toWord(h);
        }

        System.out.println(minsFirst ? minutes + " " + hour : hour + " " + minutes);
    }

    private static String toWord(int digit) {
        switch (digit) {
            case 0: return "";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            case 10: return "ten";
            case 11: return "eleven";
            case 12: return "twelve";
            case 13: return "thirteen";
            case 14: return "fourteen";
            case 15: return "fifteen";
            case 16: return "sixteen";
            case 17: return "seventeen";
            case 18: return "eighteen";
            case 19: return "nineteen";
        }

        if (digit >= 50) {
            return "fifty " + toWord(digit - 50);
        }

        if (digit >= 40) {
            return "forty " + toWord(digit - 40);
        }

        if (digit >= 30) {
            return "thirty " + toWord(digit - 30);
        }

        if (digit >= 20) {
            return "twenty " + toWord(digit - 20);
        }

        throw new UnsupportedOperationException();
    }

    public static String getNumber(int n, String pattern) {
        if (n == 0) {
            return pattern;
        }

        if (n < 0) {
            return ""; //invalid possibility
        }

        String possible1 = getNumber(n - 3, "555" + pattern);
        String possible2 = getNumber(n - 5, "33333" + pattern);

        return possible1.length() > possible2.length() ? possible1 : possible2;
    }

    private static long read(Scanner in) {
        return Long.parseLong(in.nextLine().trim());
    }
}
