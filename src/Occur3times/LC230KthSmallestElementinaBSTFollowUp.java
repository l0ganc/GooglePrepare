package Occur3times;

/**
 * Follow up:
 * What if the BST is modified (insert/delete operations) often
 * and you need to find the kth smallest frequently?
 *
 * How would you optimize the kthSmallest routine?
 *
 * If we could add a count field in the BST node class,
 * it will take O(n) time when we calculate the count value for the whole tree,
 * but after that, it will take O(logn) time when insert/delete a node or calculate the kth smallest element.
 */
public class LC230KthSmallestElementinaBSTFollowUp {
    static class TreeNodeWithCount {
        int val;
        int count;
        TreeNodeWithCount left;
        TreeNodeWithCount right;
        TreeNodeWithCount(int x) {val = x; count = 1;};
    }

    public static int kthSmallest(TreeNode root, int k) {
        TreeNodeWithCount rootWithCount = buildTreeWithCount(root);
        return kthSmallestNew(rootWithCount, k);
    }

    public static TreeNodeWithCount buildTreeWithCount(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNodeWithCount rootWithCount = new TreeNodeWithCount(root.val);
        rootWithCount.left = buildTreeWithCount(root.left);
        rootWithCount.right = buildTreeWithCount(root.right);
        if (rootWithCount.left != null) {
            rootWithCount.count += rootWithCount.left.count;
        }
        if (rootWithCount.right != null) {
            rootWithCount.count += rootWithCount.right.count;
        }
        return rootWithCount;
    }

    public static int kthSmallestNew(TreeNodeWithCount rootWithCount, int k) {
        if (k <= 0|| k > rootWithCount.count) {
            return -1;
        }
        if (rootWithCount.left != null) {
            if (rootWithCount.left.count >= k) {
                return kthSmallestNew(rootWithCount.left, k);
            } else if (rootWithCount.left.count + 1 < k) {
                return kthSmallestNew(rootWithCount.right, k - 1 - rootWithCount.left.count);
            }
            return rootWithCount.val;
        } else {
            if (k == 1) {
                return rootWithCount.val;
            } else {
                return kthSmallestNew(rootWithCount.right, k - 1);
            }
        }
    }

}
