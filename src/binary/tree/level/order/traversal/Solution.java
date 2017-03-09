package binary.tree.level.order.traversal;

import binary.tree.right.side.view.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xudeng on 3/8/17.
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        LinkedList<TreeNode> cache = new LinkedList<>();
        if(root == null)
        {
            return traversal;
        }
        cache.add(root);
        while(cache.size() > 0)
        {
            int count = cache.size();
            List<Integer> level = new ArrayList<>();
            traversal.add(level);
            for(int i = 0; i < count; i++)
            {
                TreeNode node = cache.poll();
                level.add(node.val);
                if (node.left != null)
                {
                    cache.add(node.left);
                }
                if (node.right != null)
                {
                    cache.add(node.right);
                }
            }
        }

        return traversal;
    }
}
