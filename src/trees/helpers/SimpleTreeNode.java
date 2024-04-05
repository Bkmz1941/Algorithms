package trees.helpers;

public class SimpleTreeNode {
     public int value;
     public SimpleTreeNode left;
     public SimpleTreeNode right;

     public SimpleTreeNode(int value, SimpleTreeNode left, SimpleTreeNode right) {
          this.value = value;
          this.left = left;
          this.right = right;
     }
}
