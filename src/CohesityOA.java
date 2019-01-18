import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * You are given a recursive notation of a binary tree: each node of a tree is represented as a set of three elements:
 *
 * value of the node;
 * left subtree;
 * right subtree.
 * So, a tree can be written as (value left_subtree right_subtree). If a node doesn't exist then it is represented as an empty set: (). For example, here is a representation of a tree in the given picture:
 *
 * tree = "(2 (7 (2 () ()) (6 (5 () ()) (11 () ()))) (5 () (9 (4 () ()) ())))"
 * the output should be treeBottom(tree) = [5, 11, 4].
 */
public class CohesityOA {
    public static void main(String[] args) {
        String tree = "(2 (7 (2 () ()) (6 (5 () ()) (11 () ()))) (5 () (9 (4 () ()) ())))";
        System.out.println(Arrays.toString(maxDepthNodeArr(tree)));
        //System.out.println('9' - '0');
    }

    private static int[] maxDepthNodeArr(String tree) {
        if (tree == null || tree.length() == 0) {
            return new int[0];
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int level = -1;
        int mark = -1;

        int i = 0;
        while (i < tree.length()) {
            if (tree.charAt(i) == '(') {
                level++;
                i++;
            } else if (tree.charAt(i) == ')') {
                level--;
                i++;
            } else if (tree.charAt(i) <= '9' && tree.charAt(i) >= '0') {
                int num = 0;
                while (tree.charAt(i) != ' ') {
                    num += (tree.charAt(i) - '0');
                    num *= 10;
                    i++;
                }
                num /= 10;

                if (!map.containsKey(level)) {
                    map.put(level, new ArrayList<>());
                }
                map.get(level).add(num);

                if (mark < level) {
                    mark = level;
                }
            } else if (tree.charAt(i) == ' ') {
                i++;
            }
        }

        List<Integer> result = map.get(mark);
        int[] leafArray = new int[result.size()];
        for (int j = 0; j < result.size(); j++) {
            leafArray[j] = result.get(j);
        }
        return leafArray;
    }
}
