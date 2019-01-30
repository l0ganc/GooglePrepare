package Occur3times;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class LC426ConvertBinarySearchTreetoSortedDoublyLinkedList {
    /**
     * step1: inorder tranversal by recursion to connect the original BST
     * step2: connect the head and tail to make it circular
     */
    static Node prev = null;
    public static Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node dummy = new Node(0, null, null);
        prev = dummy;

        // step 1: inorder traverse
        inorder(root);

        // step 2: connect head and tail
        prev.right = dummy.right;
        dummy.right.left = prev;

        return dummy.right;

    }

    public static void inorder(Node cur) {
        if (cur == null) {
            return;
        }
        inorder(cur.left);
        prev.right = cur;
        cur.left = prev;
        prev = cur;
        inorder(cur.right);
    }
}
