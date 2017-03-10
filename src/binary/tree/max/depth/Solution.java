package binary.tree.max.depth;

import binary.tree.right.side.view.TreeNode;

/**
 * Created by xudeng on 3/9/17.
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
