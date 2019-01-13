class Node {
    int data;
    Node left;
    Node right;
    Node parent;

    Node(int d) {
        data = d;
        left = right = parent = null;
    }
}
public class InorderSuccessorInBST {
    static Node head;

    /* Given a binary search tree and a number,
     inserts a new node with the given number in
     the correct place in the tree. Returns the new
     root pointer which the caller should then use
     (the standard trick to avoid using reference
     parameters). */

    Node insert(Node node, int data) {
        // if the tree is empty, return a new, single node
        if (node == null) {
            return (new Node(data));
        } else {
            Node temp = null;

            // otherwise, recur down the tree
            if (data <= node.data) {
                temp = insert(node.left, data);
                node.left = temp;
                temp.parent = node;
            } else {
                temp = insert(node.right, data);
                node.right = temp;
                temp.parent = node;
            }
            return node;
        }
    }

    Node inOrderSuccessor(Node root, Node n) {
        /**
         * step 1:
         *  If right subtree of node is not NULL,
         *  then succ lies in right subtree.
         *  Do following.
         * Go to right subtree and return the node with
         * minimum key value in right subtree.
         *
         * step 2:
         *  If right sbtree of node is NULL,
         *  then succ is one of the ancestors.
         *  Do following.
         * Travel up using the parent pointer until you see a node which is left
         * child of it’s parent. The parent of such a node is the succ.
         */

        // step1
        if (n.right != null) {
            return minValue(n.right);
        }

        // step2
        Node p = n.parent;
        while (p != null && n == p.right) {
            n = p;
            p = p.parent;
        }
        return p;
    }

    static Node minValue(Node node) {
        Node current = node;

        // loop down tp find the leftmost leaf
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    public static void main(String[] args) {
        InorderSuccessorInBST tree = new InorderSuccessorInBST();
        Node root = null, temp = null, suc = null, min = null;
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        temp = root.left.right.right;
        suc = tree.inOrderSuccessor(root, temp);
        if (suc != null) {
            System.out.println("Inorder successor of " + temp.data +
                    " is " + suc.data);
        } else {
            System.out.println("Inorder successor does not exist");
        }


    }
}
