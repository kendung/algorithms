package binary.tree.zigzag.order.traversal;

import binary.tree.right.side.view.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xudeng on 3/10/17.
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<TreeNode> cache = new LinkedList<>();
        List<List<Integer>> traversal = new ArrayList<>();
        if(root == null)
        {
            return traversal;
        }
        cache.push(root);
        boolean leftToRight = true;
        while(!cache.isEmpty())
        {
            int size = cache.size();
            List<Integer> row = new ArrayList<>();
            traversal.add(row);
            List<TreeNode> temp = new ArrayList<>();
            for(int i = 0; i < size; i++)
            {
                TreeNode node = cache.pop();
                row.add(node.val);
                temp.add(node);
            }
            for(TreeNode tn : temp)
            {
                if (leftToRight)
                {
                    if (tn.left != null)
                    {
                        cache.push(tn.left);
                    }
                    if (tn.right != null)
                    {
                        cache.push(tn.right);
                    }
                }else
                {
                    if (tn.right != null)
                    {
                        cache.push(tn.right);
                    }
                    if (tn.left != null)
                    {
                        cache.push(tn.left);
                    }
                }
            }
            leftToRight = !leftToRight;
        }
        return traversal;
    }
}
