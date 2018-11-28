import java.util.Stack;

public class EvaluateReversePolishNotation {
    private static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return -1;
        }

        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < tokens.length; i++) {
            String ch = tokens[i];
            if (ch == "/") {
                int back = stack.pop();
                int front = stack.pop();
                stack.push(front / back);
            } else if (ch == "+") {
                stack.push(stack.pop() + stack.pop());
            } else if (ch == "*") {
                stack.push(stack.pop() * stack.pop());
            } else if (ch == "-") {
                stack.push(-stack.pop() + stack.pop());
            } else {
                stack.push(Integer.valueOf(ch));
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        String[] tokens1 = {"4", "13", "5", "/", "+"};
        String[] tokens2 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
        System.out.println(evalRPN(tokens1));
        System.out.println(evalRPN(tokens2));


    }
}
