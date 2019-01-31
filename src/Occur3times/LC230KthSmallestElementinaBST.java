package Occur3times;

/**
 *
 Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 Example 1:

 Input: root = [3,1,4,null,2], k = 1
 3
 / \
 1   4
 \
 2
 Output: 1
 */
public class LC230KthSmallestElementinaBST {
    public static int kthSmallest(TreeNode root, int k) {
        int count = countNode(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (count + 1 < k) {
            return kthSmallest(root.right, k - 1 - count);
        }
        return root.val;
    }

    public static int countNode(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNode(root.left) + countNode(root.right);
    }
}
