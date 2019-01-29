package Occur3times;

import java.util.Scanner;

/**
 *
 Given two strings S and T, return if they are equal
 when both are typed into empty text editors. # means a backspace character.

 Example 1:

 Input: S = "ab#c", T = "ad#c"
 Output: true
 Explanation: Both S and T become "ac".
 */
public class LC844BackspaceStringCompare {
     // method 2
     // O(N) time complexity
     // O(1) space complexity
    public static boolean StringCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        while (true) {
            for (int back = 0; i >= 0 && (back > 0 || s.charAt(i) == '#'); i--) {
                if (s.charAt(i) == '#') {
                    back++;
                } else {
                    back--;
                }
            }

            for (int back = 0; j >= 0 && (back > 0 || t.charAt(j) == '#'); j--) {
                if (t.charAt(j) == '#') {
                    back++;
                } else {
                    back--;
                }
            }

            if (i >= 0 && j >= 0 && s.charAt(i) == t.charAt(j)) {
                i--;
                j--;
            } else {
                return i == -1 && j == -1;
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("please input S : " );
        String S = sc.next();
        System.out.println();
        System.out.print("please input T : " );
        String T = sc.next();
        StringBuilder sb = new StringBuilder();


        System.out.println(StringCompare(S, T));
    }
}
