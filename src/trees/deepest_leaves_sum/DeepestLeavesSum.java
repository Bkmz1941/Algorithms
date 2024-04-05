package trees.deepest_leaves_sum;

import trees.helpers.SimpleTreeNode;
import trees.helpers.Trees;

import java.util.ArrayDeque;

/**
 * Given the root of a binary tree, return the sum of values of its deepest leaves:
 */
public class DeepestLeavesSum {
    public static void main(String[] args) {
        SimpleTreeNode root = Trees.generateTree(new Integer[]{1,2,3,4,5,null,6,7,null,null,null,null,8});
        int answer = deepestLeavesSum(root);
        System.out.println(answer);
    }

    public static int deepestLeavesSum(SimpleTreeNode node) {
        if (node == null) return 0;

        ArrayDeque<SimpleTreeNode> currQueue = new ArrayDeque<>();
        ArrayDeque<SimpleTreeNode> nextQueue = new ArrayDeque<>();
        nextQueue.add(node);

        while (!nextQueue.isEmpty()) {
            currQueue = nextQueue.clone();
            nextQueue.clear();
            for (SimpleTreeNode currNode: currQueue) {
                if (currNode.left != null) nextQueue.add(currNode.left);
                if (currNode.right != null) nextQueue.add(currNode.right);
            }
        }

        int ans = 0;
        for (SimpleTreeNode currNode: currQueue) {
            ans += currNode.value;
        }
        return ans;
    }
}
