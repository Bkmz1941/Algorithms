package trees.zigzagLevelOrder;

import trees.helpers.SimpleTreeNode;
import trees.helpers.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class zigzagLevelOrder {
    public static void main(String[] args) {
        SimpleTreeNode root = Trees.generateTree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(SimpleTreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        // add the root element with a delimiter to kick off the BFS loop
        LinkedList<SimpleTreeNode> node_queue = new LinkedList<SimpleTreeNode>();
        node_queue.addLast(root);
        node_queue.addLast(null);

        LinkedList<Integer> level_list = new LinkedList<Integer>();
        boolean is_order_left = true;

        while (node_queue.size() > 0) {
            SimpleTreeNode curr_node = node_queue.pollFirst();
            if (curr_node != null) {
                if (is_order_left)
                    level_list.addLast(curr_node.value);
                else
                    level_list.addFirst(curr_node.value);

                if (curr_node.left != null)
                    node_queue.addLast(curr_node.left);
                if (curr_node.right != null)
                    node_queue.addLast(curr_node.right);

            } else {
                // we finish the scan of one level
                results.add(level_list);
                level_list = new LinkedList<Integer>();
                // prepare for the next level
                if (node_queue.size() > 0)
                    node_queue.addLast(null);
                is_order_left = !is_order_left;
            }
        }
        return results;
    }
}
