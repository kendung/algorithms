package flatten.binary.tree;

/**
 * Created by xudeng on 7/15/17.
 */
public class SumLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null){
            return 0;
        }
        if (root != null){
            int sum = 0;
            if (root.left != null){
                if (root.left.left == null && root.left.right == null)
                {
                    sum = sum + root.left.val;
                }
                sum += sumOfLeftLeaves(root.left);


            }
            if (root.right != null){
                sum += sumOfLeftLeaves(root.right);
            }
            return sum;
        }
        return 0;
    }


}
