
import static java.lang.System.*;

public class TreeRecursion {
  
  public TreeRecursion() {
    TreeNode root = initializeTree();

    boolean found = findVal(4, root, 0);
  }

  private boolean findVal(int val, TreeNode node, int debugLevel) {
    out.println("checking Node " + node.val);
    if (val == node.val) {
      out.println("found " + val + " at level " + debugLevel);
      return true;
    }
    else if (node.left != null && val < node.val) {
      out.println("going left...");
      return findVal(val, node.left, ++debugLevel);
    }
    else if (node.right != null && val >= node.val) {
      out.println("going right...");
      return findVal(val, node.right, ++debugLevel);
    }

    return false;
  }
    
  //manually initializing a shallow binary tree of Integers
  private TreeNode initializeTree() {
    TreeNode root = new TreeNode(7);
    root.left = new TreeNode(3);
    root.right = new TreeNode(11);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(9);
    root.right.right = new TreeNode(13);
    root.left.left.left = new TreeNode(0);
    root.left.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(4);
    root.left.right.right = new TreeNode(6);
    root.right.left.left = new TreeNode(8);
    root.right.left.right = new TreeNode(10);
    root.right.right.left = new TreeNode(12);
    root.right.right.right = new TreeNode(14);
  
    return root;
  }
    
  public static void main(String[] args) {
    new TreeRecursion();
  }
}
