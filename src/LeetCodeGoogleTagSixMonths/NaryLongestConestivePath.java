package LeetCodeGoogleTagSixMonths;

import java.util.List;

/**
 * N-ary tree to find a longest consecutive path
 *
 *
 */
public class NaryLongestConestivePath {
    public static int res;

    public int longestConsecutive(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.children == null || root.children.size() == 0) {
            return 1;
        }

        res = 1;
        for (int i = 0; i < root.children.size(); i++) {
            dfs(root.children.get(i), root.val, 1);
        }
        return res;
    }


    static class Node{
        int val;
        List<Node> children;
        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public static void dfs(Node root, int pre, int len) {
        if (root == null) {
            res = Math.max(res, len);
            return;
        }

        if (root.children == null || root.children.size() == 0) {
            res = Math.max(res, len + 1);
            return;
        }

        if (root.val > pre) {
            for (int i = 0; i < root.children.size(); i++) {
                dfs(root.children.get(i), root.val, len + 1);
            }
        } else {
            for (int i = 0; i < root.children.size(); i++) {
                dfs(root.children.get(i), root.val, 1);
            }
        }
    }
}
