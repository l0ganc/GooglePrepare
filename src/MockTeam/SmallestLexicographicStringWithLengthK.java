package MockTeam;

import java.util.Stack;

public class SmallestLexicographicStringWithLengthK {
    public static void main(String[] args) {
        System.out.println(findSmallestSubsequence("dacbd", 3));
    }

    private static String findSmallestSubsequence(String s, int k) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            while (!stack.isEmpty() && stack.peek() > s.charAt(i) && stack.size() + s.length() - i > k) {
                stack.pop();
            }

            stack.push(s.charAt(i));

        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
