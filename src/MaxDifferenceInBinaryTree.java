public class MaxDifferenceInBinaryTree {
    /**
     * 给一个二叉树，存的是int，找到全局里面祖先节点和他孩子节点的差值的最大值
     *
     * DFS时候加两个parameter， 正在访问的node的祖先的maxValue和minVlaue，
     * 计算现在node的值与maxValue和minValue的差值，更新maxDiff
     * 因为最大差值一定是和祖先的最大值或最小值的差值
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }

    public int getMinimumDifference(TreeNode root) {
        int res = root.val;
        dfs(root, res, root.val, root.val);
        return res;
    }

    public void dfs(TreeNode root, int res, int maxval, int minval) {
        if (root == null) {
            return;
        }

        maxval = Math.max(maxval, root.val);
        minval = Math.min(minval, root.val);

        int temp = Math.max(Math.abs(root.val - maxval), Math.abs(root.val - minval));
        res = Math.max(temp, res);
        dfs(root.left, res, maxval, minval);
        dfs(root.right, res, maxval, minval);
    }

}
