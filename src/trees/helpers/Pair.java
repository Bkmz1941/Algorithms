package trees.helpers;

public class Pair {
    public SimpleTreeNode node;
    public int depth; // maxSoFar, curr, something else
    public Pair(SimpleTreeNode node, int depth) {
        this.depth = depth;
        this.node = node;
    }
}
