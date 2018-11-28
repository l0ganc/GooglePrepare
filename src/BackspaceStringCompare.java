//import java.util.Scanner;
//import java.util.Stack;
//
//public class BackspaceStringCompare {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("please input S : " );
//        String S = sc.next();
//        System.out.println();
//        System.out.print("please input T : " );
//        String T = sc.next();
//
//        System.out.println(backspacecompare(S, T));
//    }
//
//    private static boolean backspacecompare(String S, String T) {
//        return helper(S).equals(helper(T));
//    }
//
//    private static String helper(String s) {
//        Stack<Character> stack = new Stack<>();
//        for (char c : s.toCharArray()) {
//            if (c != '#') {
//                stack.push(c);
//            } else if (!stack.isEmpty()) {
//                stack.pop();
//            }
//        }
//        return String.valueOf(stack);
//    }
//}



import java.util.Scanner;

/**
 * method 2
 * O(N) time complexity
 * O(1) space complexity
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("please input S : " );
        String S = sc.next();
        System.out.println();
        System.out.print("please input T : " );
        String T = sc.next();
        StringBuilder sb = new StringBuilder();


        System.out.println(backspacecompare(S, T));
    }

    private static boolean backspacecompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;

        while (true) {
            for (int back = 0; i >= 0 && (back > 0 || S.charAt(i) == '#'); i--) {
                if (S.charAt(i) == '#') {
                    back += 1;
                } else {
                    back -= 1;
                }
            }

            for (int back = 0; j >= 0 && (back > 0 || T.charAt(j) == '#'); j--) {
                if (T.charAt(j) == '#') {
                    back += 1;
                } else {
                    back -= 1;
                }
            }

            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                return i == -1 && j == -1;
            }
        }
    }
}

