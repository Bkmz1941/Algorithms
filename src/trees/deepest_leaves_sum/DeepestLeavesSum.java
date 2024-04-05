package trees.deepest_leaves_sum;

import trees.helpers.Pair;
import trees.helpers.SimpleTreeNode;
import trees.helpers.Trees;

import java.util.ArrayDeque;

/**
 * Given the root of a binary tree, return the sum of values of its deepest leaves:
 */
public class DeepestLeavesSum {
    public static void main(String[] args) {
        SimpleTreeNode root = Trees.generateTree(new Integer[]{1,2,3,4,5,null,6,7,null,null,null,null,8});
        int answer1 = deepestLeavesSumBFS(root);
        int answer2 = deepestLeavesSumDFS(root);
        System.out.println(answer1); // 15
        System.out.println(answer2); // 15
    }

    public static int deepestLeavesSumDFS(SimpleTreeNode node) {
        if (node == null) return 0;

        int answer = 0, maxDepth = 0, currDepth = 0;
        ArrayDeque<Pair> deque = new ArrayDeque<>();
        deque.add(new Pair(node, 0));

        while (!deque.isEmpty()) {
            Pair pair = deque.remove();
            SimpleTreeNode pairNode = pair.node;
            int pairDepth = pair.depth;
            if (pairNode.left == null && pairNode.right == null) {
                if (maxDepth < pairDepth) {
                    maxDepth = pairDepth;
                    answer = pairNode.value;
                } else if (maxDepth == pairDepth) {
                    answer += pairNode.value;
                }
            } else {
                if (pairNode.left != null) deque.add(new Pair(pairNode.left, pairDepth + 1));
                if (pairNode.right != null) deque.add(new Pair(pairNode.right, pairDepth + 1));
            }
        }

        return answer;
    }

    public static int deepestLeavesSumBFS(SimpleTreeNode node) {
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
