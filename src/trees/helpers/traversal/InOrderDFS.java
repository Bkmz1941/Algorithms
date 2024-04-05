package trees.helpers.traversal;

import trees.helpers.SimpleTreeNode;

public class InOrderDFS {
    public void run(SimpleTreeNode node) {
        if (node == null) return;
        run(node.left);
        System.out.print(node.value + " ");
        run(node.right);
    }
}
