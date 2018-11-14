import java.util.Stack;

public class CelebrityProblem {
    /**
     * In a party of N people, only one person is known to everyone.
     * Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party.
     * We can only ask questions like “does A know B? “.
     * Find the stranger (celebrity) in minimum number of questions.
     */
    static int[][] matrix = {
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}
    };

    public static void main(String[] args) {


        System.out.println(findCelebrity(2));
    }

    private static int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();
        int c;

        // step 1: push everybody onto stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            //step 2: pop off top two elements from stack
            // discard one person based on return status of knows(A, B)
            int a = stack.pop();
            int b = stack.pop();

            // step 3: push the remained person onto stack
            if (knows(a, b)) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }

        c = stack.pop();

        // step 5: check if the last preson is celebrity or not
        for (int i = 0; i < n; i++) {
            if (i != c && (knows(c, i) || !knows(i, c))) {
                return -1;
            }
        }
        return c;
    }

    private static  boolean knows(int a, int b) {
        boolean res = matrix[a][b] == 1;
        return res;
    }
}
