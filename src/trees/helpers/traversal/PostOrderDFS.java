package trees.helpers.traversal;

import trees.helpers.SimpleTreeNode;

public class PostOrderDFS {
    public void run(SimpleTreeNode node) {
        if (node == null) return;
        run(node.left);
        run(node.right);
        System.out.print(node.value + " ");
    }
}
