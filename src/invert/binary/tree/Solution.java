package invert.binary.tree;

import binary.tree.right.side.view.TreeNode;

/**
 * Created by xudeng on 3/10/17.
 */
public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
        {
            return null;
        }
        if (root.left == null && root.right == null)
        {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
