package tree.path.sum;

/**
 * Created by xudeng on 1/13/17.
 */
public class Solution {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int findPath(TreeNode node, int sum) {
        int result = 0;
        if (node == null) {
            return result;
        }
        if (sum == node.val) {
            result++;
        }
        result += findPath(node.left, sum - node.val);
        result += findPath(node.right, sum - node.val);
        return result;
    }

    public static void main(String args[])
    {
        Solution main = new Solution();
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(11);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(-2);
        TreeNode node8 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.right = node8;
        System.out.println(main.pathSum(root, 1));
    }
}
