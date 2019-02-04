package RecentlyQuestions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * n-ary tree 求最大深度
 */
class Node{
    public int val;
    public List<Node> children;

    public Node() {

    }

    public Node (int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
public class LC559MaximumDepthofNaryTree {
    // DFS way
    // Time = O(n);  Space = O(N)
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        for (Node child : root.children) {
            int value = maxDepth(child);
            if (value > max) {
                max = value;
            }
        }
        return 1 + max;
    }

    // BFS way
    // Time = O(n);  Space = O(N)
    public int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                for (Node child : current.children) {
                    queue.offer(child);
                }
            }
            depth++;
        }
        return depth;
    }
}
