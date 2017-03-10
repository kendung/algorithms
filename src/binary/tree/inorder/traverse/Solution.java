package binary.tree.inorder.traverse;

import path.sum.TreeNode;

import java.util.*;

/**
 * Created by xudeng on 3/9/17.
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {

        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> traversal = new ArrayList<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            while(temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            TreeNode node=stack.pop();
            traversal.add(node.val);
            temp=node.right;
        }
        return traversal;

    }
}
