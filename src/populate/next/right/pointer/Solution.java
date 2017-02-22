package populate.next.right.pointer;

/**
 * Created by xudeng on 2/21/17.
 */
public class Solution {

    public void connect(TreeLinkNode root) {
        if (root == null)
        {
            return;
        }
        root.next = null;
        recursive(root.left, root.right);
    }

    private void recursive(TreeLinkNode left, TreeLinkNode right)
    {
        if (left == null)
        {
            return;
        }
        left.next = right;
        recursive(left.left, left.right);
        recursive(left.right, right.left);
        recursive(right.left, right.right);
    }
}
