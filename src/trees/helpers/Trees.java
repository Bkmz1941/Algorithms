package trees.helpers;

import java.util.*;

public class Trees {
    public static void main(String[] args) {
//        SimpleTreeNode root = generateTree();
//        PreOrderDFS preorderDFS = new PreOrderDFS();
//        InOrderDFS inorderDFS = new InOrderDFS();
//        PostOrderDFS postorderDFS = new PostOrderDFS();
//
//        preorderDFS.run(root);
//        System.out.println();
//        inorderDFS.run(root);
//        System.out.println();
//        postorderDFS.run(root);
    }

    public static SimpleTreeNode generateTree(Integer[] values) {
        if (values.length == 0) return null;
        SimpleTreeNode root = new SimpleTreeNode(values[0], null, null);
        Queue<SimpleTreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean passLeft = false;
        for (int i = 1; i < values.length; i++) {
            SimpleTreeNode node = queue.peek();
            if (node == null) continue;
            if (node.left == null && !passLeft) {
                if (values[i] != null) {
                    node.left = new SimpleTreeNode(values[i], null, null);
                    queue.add(node.left);
                } else {
                    passLeft = true;
                }
            } else if (node.right == null) {
                if (values[i] != null) {
                    node.right = new SimpleTreeNode(values[i], null, null);
                    queue.add(node.right);
                }
                passLeft = false;
                queue.remove();
            }
        }

        return root;
    }
}
