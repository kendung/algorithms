package lowest.common.ancestor;

import binary.tree.right.side.view.TreeNode;

/**
 * Created by xudeng on 3/13/17.
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q)
        {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
        {
            return root;
        }
        if (left != null)
        {
            return left;
        }
        return right;
    }
}
