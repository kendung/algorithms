package flatten.binary.tree;

/**
 * Created by xudeng on 1/10/17.
 */
public class Solution {

    private TreeNode latestNode;

    public void flatten(TreeNode root) {
        latestNode = root;
        preorder(root);
        switchTree(root);
        System.out.println("Complete");
    }

    public void preorder(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        latestNode = root;
        if (root.left != null)
        {
            preorder(root.left);
        }
        if (root.right != null)
        {
            latestNode.left = root.right;
            preorder(root.right);
        }
    }

    public void switchTree(TreeNode root)
    {
        while(root != null)
        {
            root.right = null;
            root.right = root.left;
            root.left = null;
            root = root.right;
        }
    }
    public static void main(String args[])
    {
        Solution main = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node5;
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node2.left = node3;
        node2.right = node4;
        TreeNode node6 = new TreeNode(6);
        node5.right = node6;
        main.flatten(root);
    }
}
