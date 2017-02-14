package path.sum;

/**
 * Created by xudeng on 2/13/17.
 */
public class Solution {

    private boolean found = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        preorder(root, 0, sum);
        return found;
    }

    private void preorder(TreeNode root, int currentSum, int sum)
    {
        if (root == null)
        {
            return;
        }
        if (found)
        {
            return;
        }
        if (root != null)
        {
            currentSum = currentSum + root.val;
            if (root.left == null &&
                    root.right == null &&
                    currentSum == sum)
            {
                found = true;
                return;
            }
            if (root.left != null)
            {
                preorder(root.left, currentSum, sum);
            }
            if (root.right != null)
            {
                preorder(root.right, currentSum, sum);
            }
        }
    }
}
