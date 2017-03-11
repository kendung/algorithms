package balanced.binary.tree;

import binary.tree.right.side.view.TreeNode;

/**
 * Created by xudeng on 3/11/17.
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1)
        {
            return false;
        }
        return (isBalanced(root.left) && isBalanced(root.right));
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
