package trees.helpers.traversal;

import trees.helpers.SimpleTreeNode;

public class PreOrderDFS {
    public void run(SimpleTreeNode node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        run(node.left);
        run(node.right);
    }
}
