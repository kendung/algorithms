package binary.tree.postorder.traverse;

import binary.tree.right.side.view.TreeNode;

import java.util.*;

/**
 * Created by xudeng on 3/13/17.
 */
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<TreeNode> stack = new ArrayList<>();
        List<Integer> traverse = new ArrayList<>();
        List<TreeNode> visited = new ArrayList<>();
        if (root == null)
        {
            return traverse;
        }
        stack.add(root);
        while(!stack.isEmpty())
        {
            TreeNode node = stack.get(stack.size() - 1);
            if (node.left == null && node.right == null)
            {
                traverse.add(node.val);
                visited.add(node);
                stack.remove(stack.size() -1);
            }else
            {
                if (node.right != null && !visited.contains(node.right))
                {
                   stack.add(node.right);
                }
                if (node.left != null && !visited.contains(node.left))
                {
                    stack.add(node.left);
                }
                if (node.right != null && visited.contains(node.right))
                {
                    traverse.add(node.val);
                    visited.add(node);
                    stack.remove(stack.size() - 1);
                }
                if (node.left != null && node.right == null && visited.contains(node.left))
                {
                    traverse.add(node.val);
                    visited.add(node);
                    stack.remove(stack.size() - 1);
                }
            }
        }
        return traverse;

    }
}
