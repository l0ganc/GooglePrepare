package MostFrequentlyQuestions;

import java.util.List;

public class NTree17 {
    public static void main(String[] args) {

    }

    private void bfs(Node root, Node parent, List<Node> res) {
        if (root == null) {
            return;
        }
        if (parent.color.equals("red") && !root.color.equals("red")) {
            res.add(root);
        }

        for (Node child : root.children) {
            bfs(child, root, res);
        }
    }
}


class Node{
    int val;
    List<Node> children;
    String color;

    public Node() {}

    public Node(int _val,List<Node> _children, String color) {
        val = _val;
        children = _children;
        this.color = color;
    }
}