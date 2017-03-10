package binary.tree.min.depth;

import binary.tree.right.side.view.TreeNode;

import java.util.LinkedList;

/**
 * Created by xudeng on 3/9/17.
 */
public class Solution {

    public int minDepth(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root == null)
        {
            return 0;
        }
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty())
        {
           int size = queue.size();
           depth++;
           for(int i = 0; i < size; i++)
           {
               TreeNode node = queue.remove();
               if (node.left == null && node.right == null)
               {
                   return depth;
               }
               if (node.left != null)
               {
                   queue.add(node.left);
               }
               if (node.right != null)
               {
                   queue.add(node.right);
               }
           }
        }
        return -1;
    }
}
