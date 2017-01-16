package binary.tree.right.side.view;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xudeng on 1/15/17.
 */
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if (root == null)
        {
            return view;
        }
        List<TreeNode> cache = new ArrayList<>();
        cache.add(root);
        while(cache.size() > 0)
        {
            TreeNode node = cache.get(cache.size() - 1);
            view.add(node.val);
            int size = cache.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode element = cache.get(i);
                if (element.left != null)
                {
                    cache.add(element.left);
                }
                if (element.right != null)
                {
                    cache.add(element.right);
                }
            }
            for (int i = 0; i < size; i++)
            {
                cache.remove(0);
            }
        }
        return view;
    }

    public static void main(String args[])
    {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node1;
        root.right = node3;
        node1.right = node5;
        node3.right = node4;
        Solution main = new Solution();
        List<Integer> result = main.rightSideView(root);
        for(Integer item : result)
        {
            System.out.print(item + ",");
        }

    }
}
