package Occur3times;


import java.util.HashMap;

/**
 * 思路：dfs+dp存抢当前node和不抢当前node的最大值
 *
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode (int val) {
        this.val = val;
    }
}
public class LC337HouseRobberIII {
    public static int rob(TreeNode root) {
        return startRob(root, new HashMap<>());
    }

    private static int startRob(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }

        int value = 0;
        if (root.left != null) {
            value += startRob(root.left.left, map) + startRob(root.left.right, map);
        }

        if (root.right != null) {
            value += startRob(root.right.left, map) + startRob(root.right.right, map);
        }

        // 抢当前层跟不抢当前层的最大值
        value = Math.max(root.val + value, startRob(root.left, map) + startRob(root.right, map));

        map.put(root, value);

        return value;
    }
}
