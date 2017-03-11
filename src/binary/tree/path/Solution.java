package binary.tree.path;

import binary.tree.right.side.view.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xudeng on 3/11/17.
 */
public class Solution {



    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePaths(result, null, root);
        return result;
    }

    private void binaryTreePaths(List<String> result,
                                 String currentPath, TreeNode node)
    {
        if (node == null)
        {
            return;
        }
        if (currentPath == null)
        {
            currentPath = String.valueOf(node.val);
        }else
        {
            currentPath = currentPath + "->" + String.valueOf(node.val);
        }
        if (node.left == null && node.right == null)
        {
            result.add(currentPath);
        }
        if (node.left != null)
        {
            binaryTreePaths(result, currentPath, node.left);
        }
        if (node.right != null)
        {
            binaryTreePaths(result, currentPath, node.right);
        }

    }

}
